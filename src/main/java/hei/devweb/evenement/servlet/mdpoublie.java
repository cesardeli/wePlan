package hei.devweb.evenement.servlet;

import hei.devweb.evenement.daos.DataSourceProvider;
import hei.devweb.evenement.entites.SendTextMessage;
import hei.devweb.evenement.entites.Utilisateur;
import hei.devweb.evenement.managers.UtilisateurManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cesar on 10/05/16.
 */

@WebServlet("/mdpoublie")
public class mdpoublie extends HttpServlet {
    public static final String CHAMP_EMAIL = "utilisateur_mail";
    public static final String ATT_ERREURS = "erreurs";
    public static final String VUE = "/WEB-INF/mdpoublie.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Map<String, String> erreurs = new HashMap<String, String>();


        String utilisateur_mail = request.getParameter("utilisateur_mail");
        System.out.println("recuperation" + utilisateur_mail);


        // System.out.println("Utilisateur : " + utilisateur_mail);
        // System.out.println("MDP : " + utilisateur_mdp);


        try {
            validationEmail(utilisateur_mail);

        } catch (Exception e) {
            e.printStackTrace();

            /* Gérer les erreurs de validation ici. */
            erreurs.put(CHAMP_EMAIL, e.getMessage());
            System.out.println("erreur : " + erreurs);

        }


        if (erreurs.isEmpty()) {
            String utilisateur_mdp = generate();
            Utilisateur nouvelUtilisateur = new Utilisateur(null, utilisateur_mail, utilisateur_mdp, null);


            UtilisateurManager.getInstance().mdpoublie(nouvelUtilisateur);

            SendTextMessage envoyeurDeMail = new SendTextMessage();


            try {
                String message = "Hello,\n\n"
                        + "Tu viens de modifier ton mot de passe WePlan.\n"
                        + "Voici ton nouveau mot de passe :  " + utilisateur_mdp + "\n\n"
                        + "A bientôt sur WePlanHei!";
                envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "weplanhei@gmail.com",
                        utilisateur_mail, "Mot de passe oublié",
                        message);
            } catch (Exception e) {
                e.printStackTrace();
            }


             /* Redirection vers confirmation inscription ! */
            response.sendRedirect("/connexion");
        } else {

            /* Stockage du résultat et des messages d'erreur dans l'objet request */
            request.setAttribute(ATT_ERREURS, erreurs);


            /* Transmission de la paire d'objets request/response à notre JSP */
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

            //this.getServletContext().getRequestDispatcher("/inscription").forward(request, response);
        }

    }


    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail(String email) throws Exception {
        if (email != null && email.trim().length() != 0) {
            if (!email.matches("^[a-z-]*\\.[a-z-]*@hei\\.fr$")) {
                throw new Exception("Merci de saisir une adresse mail de la forme prenom.nom@hei.fr.");
            }else{
                try {
                    Connection connection = DataSourceProvider.getDataSource().getConnection();

                    Statement stmt = connection.createStatement();
                    ResultSet results = stmt.executeQuery("SELECT COUNT(*) AS total FROM utilisateur WHERE utilisateur_mail = '" + email + "'");
                    results.next();

                    if(results.getInt(1)==0){
                        throw new Exception("Le compte n'existe pas");
                    }


                    stmt.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new Exception("Echec de connexion à la base de données.");
                }
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }


    public String generate() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890"; // Tu supprimes les lettres dont tu ne veux pas
        String motdepass = "";
        for (int x = 0; x < 8; x++) {
            int i = (int) Math.floor(Math.random() * 32); // Si tu supprimes des lettres tu diminues ce nb
            motdepass += chars.charAt(i);
        }
        System.out.println(motdepass);
        return motdepass;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/mdpoublie.jsp");
        view.forward(request, response);
    }
}

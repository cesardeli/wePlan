
package hei.devweb.evenement.servlet;


import hei.devweb.evenement.entites.Utilisateur;
import hei.devweb.evenement.managers.UtilisateurManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
    public static final String CHAMP_EMAIL = "utilisateur_mail_inscription";
    public static final String ATT_ERREURS = "erreurs";
    public static final String VUE = "/WEB-INF/inscription.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Map<String, String> erreurs = new HashMap<String, String>();


        String utilisateur_mail = request.getParameter("utilisateur_mail_inscription");
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
            Utilisateur nouvelUtilisateur = new Utilisateur(null, utilisateur_mail, utilisateur_mdp, 0);


            UtilisateurManager.getInstance().ajouterUtilisateur(nouvelUtilisateur);


             /* Redirection vers confirmation inscription ! */
            response.sendRedirect("confirmationinscription");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
        view.forward(request, response);


    }

}



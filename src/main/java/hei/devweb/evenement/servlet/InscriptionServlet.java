package hei.devweb.evenement.servlet;


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


@WebServlet("/inscription2")

public class InscriptionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String utilisateur_mail = request.getParameter("utilisateur_mail");
        String utilisateur_mdp = generate();
        String erreurs=request.getParameter("erreurs");
        //String resultat=request.getParameter("resultat");

        Utilisateur nouvelUtilisateur = new Utilisateur(null, utilisateur_mail, utilisateur_mdp);
        UtilisateurManager.getInstance().ajouterUtilisateur(nouvelUtilisateur);

        System.out.println("Utilisateur : " + nouvelUtilisateur);

        SendTextMessage envoyeurDeMail = new SendTextMessage();

        try {
            String message = "Yo gros,\n\n"
                    + "Tu viens de t'inscrire sur WePlan.\n"
                    + "Voici ton mot de passe généré aléatoirement: " + utilisateur_mdp + "\n\n"
                    + "A bientôt sur WePlanHei!";
            envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "weplanhei@gmail.com",
                    utilisateur_mail, "Inscription pour aller voir les évènements",
                    message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("evenements");

    }

    public String generate() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
        String motdepass = "";
        for (int x = 0; x < 8; x++) {
            int i = (int) Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
            motdepass += chars.charAt(i);
        }
        System.out.println(motdepass);
        return motdepass;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/inscription2.jsp");
        view.forward(request, response);

    }


}


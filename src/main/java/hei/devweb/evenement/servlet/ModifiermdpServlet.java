package hei.devweb.evenement.servlet;

import hei.devweb.evenement.daos.ModifiermdpForm;
import hei.devweb.evenement.entites.SendTextMessage;
import hei.devweb.evenement.entites.Utilisateur;
import hei.devweb.evenement.managers.UtilisateurManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Cesar on 09/05/16.
 */

@WebServlet("/modifiermdp")
public class ModifiermdpServlet extends HttpServlet {
    public static final String VUE = "/restreint/parametre.jsp";
    public static final String ATT_FORM = "form";


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page parametre */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("utilisateur_mail");

        String mdp = request.getParameter("utilisateur_nouveau_mdp");

        System.out.println("email : " + email);
        System.out.println("mdp : " + mdp);


        /* Préparation de l'objet formulaire */
        ModifiermdpForm form = new ModifiermdpForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = null;
        try {
            utilisateur = form.modifierUtilisateur(request);
            System.out.println(form.modifierUtilisateur(request));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();


        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (form.getErreurs().isEmpty()) {

            UtilisateurManager.getInstance().modifierMDP(email, mdp);
            SendTextMessage envoyeurDeMail = new SendTextMessage();


            try {
                String message = "Hello,\n\n"
                        + "Tu viens de modifier ton mot de passe WePlan.\n"
                        + "Voici ton nouveau mot de passe :  " + mdp + "\n\n"
                        + "A bientôt sur WePlanHei!";
                envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "weplanhei@gmail.com",
                        email, "Modification mot de passe",
                        message);
            } catch (Exception e) {
                e.printStackTrace();
            }


             /* Redirection vers calendrier ! */
            response.sendRedirect("/calendrier");

            System.out.println("Mot de passe modifié");

        } else {
            System.out.println("Mot de passe NON modifié");
            //session.setAttribute( ATT_SESSION_USER, null );

            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute(ATT_FORM, form);


            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }


    }
}





package hei.devweb.evenement.servlet;


import hei.devweb.evenement.entites.SendTextMessage;
import hei.devweb.evenement.entites.Utilisateur;
import hei.devweb.evenement.managers.UtilisateurManager;
import hei.devweb.evenement.managers.ConnexionManager;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminutilisateur")
public class AdminUtilisateurServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String bouton = request.getParameter("bouton");


        if (bouton.equals("inscription")) {
            System.out.println("Bouton inscription");
            String utilisateur_mail = request.getParameter("utilisateur_mail_inscription");
            System.out.println("recuperation" +utilisateur_mail);
            String utilisateur_mdp = generate();
            String erreur = request.getParameter("erreur");

            Utilisateur nouvelUtilisateur = new Utilisateur(null, utilisateur_mail, utilisateur_mdp, 0);
            UtilisateurManager.getInstance().ajouterUtilisateur(nouvelUtilisateur);

            System.out.println("Utilisateur : " + utilisateur_mail);
            System.out.println("MDP : " + utilisateur_mdp);

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


            response.sendRedirect("ConfirmationInscription"); //VERS CONFIRMATION INSCRIPTION


        }

        if (bouton.equals("connexion")) {
            System.out.println("Bouton connexion");
            HttpSession session = request.getSession();



            String utilisateur_mail = request.getParameter("utilisateur_mail_connexion");
            String utilisateur_mdp = request.getParameter("utilisateur_mdp");
            System.out.println("AdminUtilisateurServlet utilisateur mail  : " + utilisateur_mail);
            System.out.println("AdminUtilisateurServlet utilisateur mdp  : " + utilisateur_mdp);
            if (ConnexionManager.getInstance().verifierUtilisateur(utilisateur_mail, utilisateur_mdp)) {
                request.getSession().setAttribute("utilisateurConnecte", utilisateur_mail);
                if(null == session.getAttribute("utilisateurConnecte")){
                    // User is not logged in.
                    System.out.println("Utilisateur non connecté");
                }else{
                    // User IS logged in.
                    System.out.println("Utilisateur  connecté");


                }
                System.out.println("AdminUtilisateurServlet :  if");
                response.sendRedirect("calendrier");
            } else {
                request.getSession().setAttribute("messageErreur", "<h1>Identifiants incorrects !</h1>");
                System.out.println("AdminUtilisateurServlet :  else");
                response.sendRedirect("adminutilisateur");


            }
          // this.doGet(request, response);

        }



    }

        public String generate () {
            String chars = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Tu supprimes les lettres dont tu ne veux pas
            String motdepass = "";
            for (int x = 0; x < 8; x++) {
                int i = (int) Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
                motdepass += chars.charAt(i);
            }
            System.out.println(motdepass);
            return motdepass;

        }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

           RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/AdminUtilisateur.jsp");
            view.forward(request, response);



            String messageErreur = (String) request.getSession().getAttribute("messageErreur");
            if (messageErreur != null && !"".equals(messageErreur)) {
                request.setAttribute("messageErreur", messageErreur);
                request.getSession().removeAttribute("messageErreur");
            }

            String utilisateur_mail = (String) request.getSession().getAttribute("utilisateurConnecte");

            if (utilisateur_mail == null || "".equals(utilisateur_mail)) {

                response.sendRedirect("adminutilisateur");
            //RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/AdminUtilisateur.jsp");
              // view.forward(request, response);
            } else {
                //response.sendRedirect("evenements");
                RequestDispatcher vue = request.getRequestDispatcher("calendrier");
                vue.forward(request, response);
            }


    }

}



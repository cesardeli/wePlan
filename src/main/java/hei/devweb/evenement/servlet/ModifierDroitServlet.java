package hei.devweb.evenement.servlet;

import hei.devweb.evenement.entites.Utilisateur;
import hei.devweb.evenement.managers.EvenementManager;
import hei.devweb.evenement.managers.UtilisateurManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cesar on 07/05/16.
 */

@WebServlet("/modifierdroit")

public class ModifierDroitServlet extends HttpServlet {

    public static void Update(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {


        String utilisateur_mail = request.getParameter("id");


        UtilisateurManager.getInstance().modifierCommission(utilisateur_mail);
        request.getSession().removeAttribute("evenement_id");

        System.out.println("ModifierDroitServlet : mail " + utilisateur_mail);

        resp.sendRedirect("dashboard");
    }

}

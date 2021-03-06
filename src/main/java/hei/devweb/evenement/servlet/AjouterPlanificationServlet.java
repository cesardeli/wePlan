package hei.devweb.evenement.servlet;

import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.managers.EvenementManager;
import hei.devweb.evenement.managers.UtilisateurManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cesar on 07/05/16.
 */

@WebServlet("/ajouterplanification")
public class AjouterPlanificationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String utilisateur_mail = request.getParameter("mailPlanification");

        System.out.println("AjouterPlanificationServlet : "+utilisateur_mail);



        UtilisateurManager.getInstance().ajouterPlanification(utilisateur_mail);

        response.sendRedirect("dashboard");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/restreint/dashboard.jsp");
        view.forward(request, response);

    }

}
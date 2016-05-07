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
import java.util.List;

/**
 * Created by Cesar on 07/05/16.
 */

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 6880801727716084460L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);

        List<Utilisateur> planifications = UtilisateurManager.getInstance().listerPlanification();
        request.setAttribute("planifications", planifications);

        List<Utilisateur> commissions = UtilisateurManager.getInstance().listerCommission();
        request.setAttribute("commissions", commissions);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/dashboard.jsp");
        view.forward(request, response);
    }

}

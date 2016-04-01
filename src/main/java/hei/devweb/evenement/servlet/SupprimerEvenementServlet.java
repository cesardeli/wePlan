package hei.devweb.evenement.servlet;

import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.managers.EvenementManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/supprimerevenement")
public class SupprimerEvenementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String Sevenement_id = request.getParameter("evenement_id");
        int evenement_id = Integer.parseInt(Sevenement_id);
        Evenement nouvelEvenement = new Evenement(evenement_id, null, null, null, null, null, null, null, null);
        EvenementManager.getInstance().supprimerEvenement(evenement_id);
        request.getSession().removeAttribute("evenement_id");
        resp.sendRedirect("evenements");
    }

}
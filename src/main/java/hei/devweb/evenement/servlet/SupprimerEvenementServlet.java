package hei.devweb.evenement.servlet;

import hei.devweb.evenement.managers.EvenementManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/supprimer")
public class SupprimerEvenementServlet extends HttpServlet {


    public static void Update(HttpServletRequest request, HttpServletResponse response) {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {



        String Sevenement_id = request.getParameter("id");
        System.out.println("SupprimerEvenementServlet : String ID " + Sevenement_id);

        int evenement_id = Integer.parseInt(Sevenement_id);
        EvenementManager.getInstance().supprimerEvenement(evenement_id);
        request.getSession().removeAttribute("evenement_id");

        System.out.println("SupprimerEvenementServlet : Int ID " + evenement_id);

        resp.sendRedirect("evenements");
    }


}
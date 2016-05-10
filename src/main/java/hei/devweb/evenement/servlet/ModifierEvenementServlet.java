package hei.devweb.evenement.servlet;

import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.managers.EvenementManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifier")

public class ModifierEvenementServlet extends HttpServlet {




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String evenement_id = ModifierEvenementServlet.find(request.getPathInfo());

       // System.out.println("evenement_id" +evenement_id);

        String evenement_nom = request.getParameter("evenement_nom");
        String evenement_lieu = request.getParameter("evenement_lieu");
        //String evenement_prive = request.getParameter("evenement_prive");

        /*String Sevenement_date_debut = request.getParameter("evenement_date_debut");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date evenement_date_debut = null;
        try {
            evenement_date_debut = sdf.parse(Sevenement_date_debut);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String Sevenement_date_fin = request.getParameter("evenement_date_fin");
        Date evenement_date_fin = null;
        try {
            evenement_date_fin = sdf.parse(Sevenement_date_fin);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        //Time evenement_heure_debut;
        //Date evenement_date_fin;
        //Time evenement_heure_fin;
        String evenement_description = request.getParameter("evenement_description");
        String evenement_link = request.getParameter("evenement_link");


        System.out.println("ModifierEvenementServlet");
        System.out.println("Nom : " + evenement_nom);
        System.out.println("Lieu : " + evenement_lieu);
        System.out.println("Description : " + evenement_description);


        Evenement newEvenement = new Evenement(79, evenement_nom, evenement_lieu, null, null, null, null, null, evenement_description, evenement_link);
        EvenementManager.getInstance().modifierEvenement(newEvenement);
        System.out.println("Retour ModifierEvenementServlet");

        response.sendRedirect("evenements");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/restreint/modifier.jsp");
        view.forward(request, response);

    }
}

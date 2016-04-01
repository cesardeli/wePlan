package hei.devweb.evenement.servlet;

import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.managers.EvenementManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModifierEvenementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String evenement_nom = request.getParameter(" evenement_nom");
        String evenement_lieu = request.getParameter("evenement_lieu");
        //String evenement_prive = request.getParameter("evenement_prive");

        String Sevenement_date_debut = request.getParameter("evenement_date_debut");
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
        }

        //Time evenement_heure_debut;
        //Date evenement_date_fin;
        //Time evenement_heure_fin;
        String evenement_description = request.getParameter("evenement_description");


        Evenement newEvenement = new Evenement(null, evenement_nom, evenement_lieu, null, null, null, null, null, evenement_description);
        EvenementManager.getInstance().modifierEvenement(newEvenement);

        response.sendRedirect("evenements");
    }
}

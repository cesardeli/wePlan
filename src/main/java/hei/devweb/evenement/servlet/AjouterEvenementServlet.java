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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/ajouter")

public class AjouterEvenementServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String evenement_nom = request.getParameter("evenement_nom");
        String evenement_lieu = request.getParameter("evenement_lieu");
        boolean evenement_prive = request.getParameter("evenement_prive") != null;
        String evenement_description = request.getParameter("evenement_description");
        String evenement_link = request.getParameter("evenement_link");



        String Sevenement_date_debut = request.getParameter("evenement_date_debut");
        String Sevenement_date_fin = request.getParameter("evenement_date_fin");


        System.out.println(Sevenement_date_debut);

   /*     String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd MMMM yyyy";

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            str = inputFormat.format(Sevenement_date_debut);
            date = outputFormat.parse(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Test inputFormat : " +date);
*/

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");


        Date evenement_date_debut = null;
        try {
            evenement_date_debut = sdfDate.parse(Sevenement_date_debut);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Date evenement_date_fin = null;
        try {
            evenement_date_fin = sdfDate.parse(Sevenement_date_fin);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //Time evenement_heure_debut;
        //Time evenement_heure_fin;


        System.out.println("AjouterEvenementServlet");
        System.out.println("Nom : " + evenement_nom);
        System.out.println("Lieu : " + evenement_lieu);
        System.out.println("Prive :" + evenement_prive);
        System.out.println("Description : " + evenement_description);
        System.out.println("Date début : " + evenement_date_debut);
        System.out.println("Date fin : " + evenement_date_fin);

        //System.out.println("String Heure début : " +Sevenement_heure_debut);
        //System.out.println("Heure début : " +evenement_heure_debut);


        Evenement nouvelEvenement = new Evenement(null, evenement_nom, evenement_lieu, evenement_prive, evenement_date_debut, null, evenement_date_fin, null, evenement_description, evenement_link);
        EvenementManager.getInstance().ajouterEvenement(nouvelEvenement);

        System.out.println("Evenement : " + nouvelEvenement);


        response.sendRedirect("evenements");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/restreint/ajouter.jsp");
        view.forward(request, response);

    }

}
package hei.devweb.evenement.servlet;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.managers.EvenementManager;



@WebServlet("/ajouter")

public class AjouterEvenementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		String evenement_nom = request.getParameter("evenement_nom");
		String evenement_lieu = request.getParameter("evenement_lieu");
		
		//Boolean evenement_prive = Boolean.valueOf(request.getParameter("evenement_prive"));
		//String evenement_prive = request.getParameter("evenement_prive");
			
		String Sevenement_date_debut = request.getParameter("evenement_date_debut");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");	
		Date evenement_date_debut = null;
		try {
			evenement_date_debut = sdfDate.parse(Sevenement_date_debut);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Sevenement_date_fin = request.getParameter("evenement_date_fin");
		Date evenement_date_fin = null;
		try {
			evenement_date_fin = sdfDate.parse(Sevenement_date_fin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
			
			//Time evenement_heure_debut;
			//Date evenement_date_fin;
			//Time evenement_heure_fin;
		String evenement_description = request.getParameter("evenement_description");
			
		
		System.out.println("AjouterEvenementServlet");
		System.out.println("Nom : " +evenement_nom);
		System.out.println("Lieu : " +evenement_lieu);
		//System.out.println("Prive : " +evenement_prive);
		System.out.println("Date début : " +evenement_date_debut);
		//System.out.println("String Heure début : " +Sevenement_heure_debut);
		//System.out.println("Heure début : " +evenement_heure_debut);





		Evenement nouvelEvenement = new Evenement(null,evenement_nom, evenement_lieu, null, evenement_date_debut, null, evenement_date_fin, null, evenement_description);
		EvenementManager.getInstance().ajouterEvenement(nouvelEvenement);
		
		System.out.println("Evenement : " +nouvelEvenement);

		

	response.sendRedirect("evenements");
}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/ajouter.jsp");
		view.forward(request, response);

	}

}
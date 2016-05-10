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
 * Created by Cesar on 09/05/16.
 */

@WebServlet("/parametre")
public class ParametreServlet extends HttpServlet{

    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);

        RequestDispatcher view = request.getRequestDispatcher("/restreint/parametre.jsp");
        view.forward(request, response);
    }


}

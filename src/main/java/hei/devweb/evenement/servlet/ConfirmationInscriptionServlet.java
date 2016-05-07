package hei.devweb.evenement.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Constance on 07/05/2016.
 */

@WebServlet("/ConfirmationInscription")
public class ConfirmationInscriptionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String bouton = request.getParameter("bouton");

        if (bouton.equals("redirection")) {
            RequestDispatcher vue = request.getRequestDispatcher("adminutilisateur");
            vue.forward(request, response);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/confirmationinscription.jsp");
        view.forward(request, response);
    }


    }



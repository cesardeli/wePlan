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
import java.util.List;

@WebServlet("/calendrier")
public class testCalendrier extends HttpServlet {

    private static final long serialVersionUID = 6880801727716084460L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Evenement> evenements = EvenementManager.getInstance().listerEvenements();


        request.setAttribute("evenements", evenements);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/testCalendrier.jsp");
        view.forward(request, response);
    }


}


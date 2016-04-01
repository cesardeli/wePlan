package hei.devweb.evenement.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {

    private static final long serialVersionUID = 6880801727716084460L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp"); //Faire JSP
        view.forward(request, response);
    }

}


/*package hei.devweb.evenement.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/connexion")

public class ConnexionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/inscription2.jsp"); //A faire EN ATTENTE : connexion.jsp
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (UtilisateurManager.getInstance().verifierUtilisateur(username, password)) {
            request.getSession().setAttribute("utilisateurConnecte", username);
        }
        this.doGet(request, response);
    }


}

*/
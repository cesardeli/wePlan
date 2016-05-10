package hei.devweb.evenement.filters;

/**
 * Created by Cesar on 08/05/16.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/ajoutercommission",
        "/ajouter",
        "/ajouterplanification",
        "/ajoutercommission",
        "/confirmationinscription",
        "/dashboard",
        "/deconnexion",
        "/evenements",
        "/modifierdroit",
        "/parametre",
        "/modifiermdp",
        "/calendrier",
        "/confirmationinscription",
        "/supprimer",
        "/deconnexion"
        })
public class RestrictionFilter implements Filter {
    public static final String ACCES_CONNEXION = "/connexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

          /* Non-filtrage des ressources statiques */
        String chemin = request.getRequestURI().substring(request.getContextPath().length());
        if (chemin.startsWith("/inc") || chemin.startsWith("/js") || chemin.startsWith("/IMG") || chemin.startsWith("/font")) {
            chain.doFilter(request, response);
            return;
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if (session.getAttribute(ATT_SESSION_USER) == null) {
            /* Redirection vers la page publique */
            request.getRequestDispatcher(ACCES_CONNEXION).forward(request, response);
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
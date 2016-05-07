package hei.devweb.evenement.servlet;

import com.google.gson.Gson;
import hei.devweb.evenement.entites.Calendrier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar on 04/05/16.
 */

@WebServlet("/Calendrier")
public class CalendrierServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Calendrier Servlet");


        List l = new ArrayList();

        Calendrier c = new Calendrier();
        c.setId(1);
        c.setStart("2016-05-8");
        c.setEnd("2016-07-29");
        c.setTitle("Task in Progress");

        Calendrier d = new Calendrier();
        c.setId(2);
        c.setStart("2016-05-7");
        c.setEnd("2016-05-8");
        c.setTitle("Task in Progress");

        l.add(c);
        l.add(d);
        System.out.println("c : " + c);
        System.out.println("d : " +d);
        System.out.println("l : " + l);





        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(l));
    }

}


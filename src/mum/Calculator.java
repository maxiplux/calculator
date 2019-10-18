package mum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServletParm
 */
public class Calculator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String add1 = request.getParameter("add1").trim() ;
        String add2 = request.getParameter("add2").trim();
        String mult1 = request.getParameter("mult1").trim();
        String mult2 = request.getParameter("mult2").trim();

        String sum = "";
        String product = "";

        // Check for valid inputs....
        try {
            Integer a1 = Integer.parseInt(add1);
            Integer a2 = Integer.parseInt(add2);
            sum = "" + (a1+a2);
        } catch(NumberFormatException e) {
            if (add1.isEmpty()) add1 = "''";
            if (add2.isEmpty()) add2 = "''";
            sum = "''";
        }

        /*
         * Integer.parseInt(str) throws NumberFormatException
         * if the string cannot be converted to an integer.
         */

        try {
            Integer m1 = Integer.parseInt(mult1);
            Integer m2 = Integer.parseInt(mult2);
            product = "" + (m1 * m2);
        } catch(NumberFormatException e) {
            if (mult1.isEmpty()) mult1 = "''";
            if (mult2.isEmpty()) mult2 = "''";
            product = "''";
        }


        // Another "view" of how to use PrintWriter
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter writer = response.getWriter();
        StringBuilder sb = new StringBuilder("<html><body>");
        sb.append("<title>Calculate</title><head>");
        sb.append("<body>");
        sb.append("<form action='calc2' method='get'>");
        sb.append("<input type = 'text' size = '2' name = 'add1' " + "value = " +  add1 +" />+");
        sb.append("<input type = 'text' size = '2' name = 'add2'"  + "value = " +  add2 + " />=");
        sb.append("<input type = 'text' size = '4' name = 'sum'"   + "value = " +  sum + " readonly  /> <br/>");
        sb.append("<input type = 'text' size = '2' name = 'mult1'" + "value = " +  mult1 + " />*");
        sb.append("<input type = 'text' size = '2' name = 'mult2'" + "value = " +  mult2 + "  />=");
        sb.append("<input type = 'text' size = '4' name = 'product'" + "value = " + product + " readonly  /><br/>");
        sb.append("<input type = 'submit' value = 'Submit'/>");
        sb.append("</form></body></html>");
        writer.println(sb.toString());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}

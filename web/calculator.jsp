<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 10/17/2019
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer add1 =  Integer.parseInt(request.getParameter("add1"));
    Integer add2 = Integer.parseInt(request.getParameter("add2"));


    Integer mult1 =  Integer.parseInt(request.getParameter("mult1"));
    Integer mult2 = Integer.parseInt(request.getParameter("mult2"));



    request.setAttribute("add", add1+add2);
    request.setAttribute("mult", mult1*mult2);
    request.getRequestDispatcher("/result.jsp").forward(request, response);
%>

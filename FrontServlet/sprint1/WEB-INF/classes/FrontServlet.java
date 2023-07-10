package etu002065.framework.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.HashMap;

public class FrontServlet extends HttpServlet {
    HashMap MappingUrls= new HashMap<String, Mapping>() ;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String url=request.getServletPath();
        String requete=request.getQueryString();
        if (requete!=null) {
            url=url+"?"+requete;
        }
        request.setAttribute("url",url);
        RequestDispatcher dispat=request.getRequestDispatcher("url.jsp");
        dispat.forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
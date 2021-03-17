package com.example.TenServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InfoServlet", value = "/Info")
public class InfoServlet extends HttpServlet {
    public InfoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>info</title></head>");
        out.println("<body>");

        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        String contentPath = request.getContextPath();
        String remoteAddr = request.getRemoteAddr();

        out.println("uri: " + uri + "<br>");
        out.println("url: " + url + "<br>");
        out.println("contentPath: " + contentPath + "<br>");
        out.println("remoteAddr: " + remoteAddr + "<br>");

        out.println("</body>");
        out.println("</html>");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.example.TenServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifecycleServlet", value = "/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {


    public LifecycleServlet(){
        System.out.println("LifecycleServlet 생성");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifecycleServlet init test");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");
        out.println("<form method='post' action='/LifecycleServlet'>");
        out.println("name : <input type= 'text' name = 'name'>");
        out.println("<input type = 'submit' value = 'ok'><br>");
        out.println("</form");
        out.println("</body");
        out.println("</html>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        out.println("<h1> hello " + name + "</h1>");
        out.close();
    }

   /* @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("LifecycleServlet service");

    }*/

    @Override
    public void destroy() {
        System.out.println("LifecycleServlet destroy");

    }
}

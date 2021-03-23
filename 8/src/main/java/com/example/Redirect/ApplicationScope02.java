package com.example.Redirect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplicationScope02", value = "/application02")
public class ApplicationScope02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        ServletContext application = getServletContext();

        try {
            int value = (int) application.getAttribute("value");
            value++;
            application.setAttribute("value", value);

            out.println("<h1>value : " + value + " </h1>");
        }catch (NullPointerException e){
            out.println("value의 값이 없습니다.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

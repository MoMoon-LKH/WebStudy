package com.example.ProjectA;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "TodayServlet", value = "/aboutme/today")
public class TodayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>현재 시각</title></head>");
        out.println("<body>");
        out.println("<h2><a href='../index.html'>메인화면</a></h1>");
        out.println("<div style='font-size:30px; display:absolute; margin:auto; text-align:center; font-weight:bold; margin-top:250px;'>현재 시간 : " + formatDate + "</div>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

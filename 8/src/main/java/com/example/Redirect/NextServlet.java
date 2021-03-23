package com.example.Redirect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NextServlet", value = "/next")
public class NextServlet extends HttpServlet {

    public NextServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");

        int dice = (Integer) req.getAttribute("dice");

        out.println("dice: " + dice);
        for (int i = 0; i < dice; i++) {
            out.println("<br>hello");
        }

        out.println("</body>");
        out.println("</html>");

    }
}

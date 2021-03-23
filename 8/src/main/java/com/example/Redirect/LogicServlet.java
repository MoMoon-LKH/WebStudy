package com.example.Redirect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    public LogicServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int v1 = (int) (Math.random() * 100) + 1;
        int v2 = (int) (Math.random() * 100) + 1;

        int result = v1 + v2;

        req.setAttribute("v1",v1);
        req.setAttribute("v2", v2);
        req.setAttribute("result", result);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result.jsp"); //dispatcher를 통해 전달할 URL 설정
        requestDispatcher.forward(req,resp); //forward
    }
}

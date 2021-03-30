import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoAddServlet", value = "/toDoAdd")
public class TodoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        ToDoDao toDoDao = new ToDoDao();

        String title = request.getParameter("title");
        String name = request.getParameter("name");
        int sequence = Integer.parseInt(request.getParameter("sequence"));
        ToDo todo = new ToDo(title, name, sequence);

        int addCount = toDoDao.addTodo(todo);
        log("addCount = " + addCount);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

import dto.ToDo;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoAddServlet", value = "/toDoAdd")
public class TodoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        ToDoDao toDoDao = new ToDoDao();

        String title = request.getParameter("title");
        String name = request.getParameter("name");
        int sequence = Integer.parseInt(request.getParameter("sequence").trim());
        ToDo todo = new ToDo(title, name, sequence);

        int addCount = toDoDao.addTodo(todo);
        log("addCount = " + addCount);

        response.sendRedirect("/main");
    }
}

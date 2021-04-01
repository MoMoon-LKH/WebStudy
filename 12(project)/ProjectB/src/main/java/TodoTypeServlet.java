import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoTypeServlet", value = "/typeUpdate")
public class TodoTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        ToDoDao toDoDao = new ToDoDao();

        Long id = Long.getLong(request.getParameter("id"));
        String type = request.getParameter("type");

        ToDo toDo = new ToDo(id, type);

        int updateCount = toDoDao.updateTodo(toDo);
        log("updateCount = " + updateCount);

        List<ToDo> list = toDoDao.getTodos();

        request.setAttribute("list",list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

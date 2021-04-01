import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoAddServlet", value = "/toDoAdd")
public class TodoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        ToDoDao toDoDao = new ToDoDao();

        String title = request.getParameter("title");
        String name = request.getParameter("name");
        int sequence = Integer.parseInt(request.getParameter("sequence").trim());
        ToDo todo = new ToDo(title, name, sequence);

        int addCount = toDoDao.addTodo(todo);
        log("addCount = " + addCount);

        List<ToDo> list = toDoDao.getTodos();

        request.setAttribute("list",list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

import dto.ToDo;
import org.codehaus.jackson.map.ObjectMapper;

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

        String coventid = request.getParameter("id");
        String type = request.getParameter("type");
        System.out.println("id = " + coventid + " type " + type);
        Long id = Long.parseLong(coventid);

        ToDo toDo = new ToDo(id, type);

        int updateCount = toDoDao.updateTodo(toDo);
        log("updateCount = " + updateCount);

        response.sendRedirect("/main");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

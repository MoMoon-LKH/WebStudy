import dto.ToDo;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TodoTypeServlet", value = "/typeUpdate")
public class TodoTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ToDoDao toDoDao = new ToDoDao();
        PrintWriter out = response.getWriter();

        String coventid = request.getParameter("id");
        String type = request.getParameter("type");
        System.out.println("id = " + coventid + " type " + type);
        Long id = Long.parseLong(coventid);

        ToDo toDo = new ToDo(id, type);

        int updateCount = toDoDao.updateTodo(toDo);
        List<ToDo> list = toDoDao.getTodos();

        log("updateCount = " + updateCount);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonList = objectMapper.writeValueAsString(list);

        out.print(jsonList);
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

import dto.ToDo;
import org.codehaus.jackson.map.ObjectMapper;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        ToDoDao toDoDao = new ToDoDao();
        List<ToDo> list = toDoDao.getTodos();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonList = objectMapper.writeValueAsString(list);
            System.out.println("jsonList = " + jsonList);

            request.setAttribute("list", jsonList);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

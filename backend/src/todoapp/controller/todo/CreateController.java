package todoapp.controller.todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todoapp.dao.todo.TodoDAO;
import todoapp.model.todo.Todo;

@WebServlet("/Create")
public class CreateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/create.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String importance = request.getParameter("importance");
        Todo todo = new Todo(title,Integer.parseInt(importance));
        TodoDAO dao = new TodoDAO();
        dao.insert(todo);
        response.sendRedirect("/todoapp/Read");
    }

}

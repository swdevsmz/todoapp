package todoapp.controller.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todoapp.dao.todo.TodoDAO;

@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_id = request.getParameter("id");
        if(s_id != null) {
            TodoDAO dao = new TodoDAO();
            dao.delete(Integer.parseInt(s_id));
        }
        response.sendRedirect("/todoapp/Read");
    }
}

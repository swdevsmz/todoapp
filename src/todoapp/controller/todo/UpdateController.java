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

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id = request.getParameter("id");
		if(s_id == null) {
			response.sendRedirect("/todoapp/Read");
		}else {
			TodoDAO dao = new TodoDAO();
			Todo todo = dao.findById(Integer.parseInt(s_id));
			request.setAttribute("todo", todo);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/update.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String importance = request.getParameter("importance");
		String id=request.getParameter("id");
		Todo todo = new Todo(Integer.parseInt(id),title,Integer.parseInt(importance));
		TodoDAO dao = new TodoDAO();
		dao.update(todo);

		response.sendRedirect("/todoapp/Read");

	}

}

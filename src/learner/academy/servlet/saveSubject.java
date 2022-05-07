package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;
import learner.academy.model.Subject;

/**
 * Servlet implementation class saveClass
 */
public class saveSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public saveSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		String className = request.getParameter("subject");

		if (className != null && !className.equals("")) {
			if (dao.save(new Subject(className))) {
				response.sendRedirect("subList.jsp");
			} else {
				response.getWriter().println("error while saving");
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("subject.jsp");
			rd.include(request, response);
			response.getWriter().println("please  provide valid  details");

		}
	}

}

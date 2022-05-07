package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;
import learner.academy.model.MyClass;

/**
 * Servlet implementation class saveClass
 */
public class saveClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public saveClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		String className = request.getParameter("class");
		if(className!=null && !className.equals("")) {
		if (dao.save(new MyClass(className))) {
			response.sendRedirect("clist.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			response.getWriter().println("error while saving");
			rd.forward(request, response);
		}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("class.jsp");
			rd.include(request, response);
			response.getWriter().println("please  provide valid  details");

		}
			
	}

}

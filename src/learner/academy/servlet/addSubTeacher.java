package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;

/**
 * Servlet implementation class addSubTeacher
 */
public class addSubTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addSubTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long tid = Long.parseLong(request.getParameter("teacher"));
		Long sid = Long.parseLong(request.getParameter("subject"));
		Long cid = Long.parseLong(request.getParameter("id"));
		DAO dao = new DAO();
		int result = dao.addSubTeacher(cid, tid, sid);
		if (result == 1) {
			request.getRequestDispatcher("clist.jsp").forward(request, response);

		}
		else
		{
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
	}

}

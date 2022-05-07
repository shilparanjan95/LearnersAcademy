package learner.academy.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;

/**
 * Servlet implementation class subjectTeacher
 */
public class subjectTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subjectTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAO dao = new DAO();
		Long id = Long.parseLong(request.getParameter("id"));
		List<Object[]> studTeacher= dao.getSubTeacher(id);
		 request.setAttribute("st", studTeacher);
		System.out.println(studTeacher);
		
		
		RequestDispatcher rd =request.getRequestDispatcher("subteacher.jsp");
		rd.forward(request, response);
		
				//response.sendRedirect("subteacher.jsp");
		
		
	}

}

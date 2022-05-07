package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;
import learner.academy.model.Student;

/**
 * Servlet implementation class editStudent
 */
public class editStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		Long id =Long.parseLong(request.getParameter("id"));
		Student stud = dao.getStudent(id);
		if(stud!=null)
		{
			request.setAttribute("student", stud);
			request.getRequestDispatcher("editStudent.jsp").forward(request, response);
		}

	}

}

package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;
import learner.academy.model.Teacher;

/**
 * Servlet implementation class editTeacher
 */
public class editTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTeacher() {
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
		Teacher teacher = dao.getTeacher(id);
		if(teacher!=null)
		{
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("editTeacher.jsp").forward(request, response);
		}

	}

}

package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;

/**
 * Servlet implementation class DeleteSubTeacher
 */
public class DeleteSubTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSubTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAO dao = new DAO();
		Long classId = Long.parseLong(request.getParameter("class"));
		Long subId = Long.parseLong(request.getParameter("sub"));
		Long teacherId = Long.parseLong(request.getParameter("teach"));

		int c = dao.deletSubTeach(classId,subId,teacherId);
		if(c==1)
		{
			//request.getRE
			request.getRequestDispatcher("clist.jsp").forward(request, response);
			
		}
	}

	
}

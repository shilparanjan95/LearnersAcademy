package learner.academy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;
import learner.academy.model.Student;

/**
 * Servlet implementation class classReport
 */
public class classReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Long id = Long.parseLong(request.getParameter("id"));
      
      DAO dao = new DAO();
     
     List<Student> studList =  dao.getStudentListByClass(id);
     
      RequestDispatcher rd = request.getRequestDispatcher("classReport.jsp");
      if(studList!=null)
      {request.setAttribute("studList", studList);}
		Long sid = Long.parseLong(request.getParameter("id"));
		List<Object[]> studTeacher= dao.getSubTeacher(sid);
		 request.setAttribute("st", studTeacher);
		System.out.println(studTeacher);
		
		
      rd.forward(request, response);
      
      
	
	}

}

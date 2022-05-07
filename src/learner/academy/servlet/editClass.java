package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;

/**
 * Servlet implementation class editClass
 */
public class editClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      DAO dao = new DAO();
      Long id = Long.parseLong(request.getParameter("id"));
      String className = request.getParameter("name");
      if(className!=null && !className.equals(""))
      {dao.editClass(id,className);
      response.sendRedirect("clist.jsp");}
      else
      {
			RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
			rd.include(request, response);
			response.getWriter().println("please  provide valid  details");


      }
      
	}

}

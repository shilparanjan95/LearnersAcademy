package learner.academy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	if(request.getParameter("user").equals(request.getParameter("password")))
	{   
		RequestDispatcher rd = request.getRequestDispatcher("clist.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("user", request.getParameter("user"));
		session.setAttribute("pwd", request.getParameter("user"));
		session.setMaxInactiveInterval(10000);
    	rd.forward(request, response);
	    
	}
	else
		
	{       RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        	rd.include(request, response);
		     response.getWriter().println("<b>Incorrect username or password</b>");
	}
	}

}

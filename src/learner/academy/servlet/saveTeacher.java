package learner.academy.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;
import learner.academy.model.MyClass;
import learner.academy.model.Teacher;

/**
 * Servlet implementation class saveStudent
 */
public class saveTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//make student obj
		//call dao
		//redirect to slist page
		try {
		DAO dao = new DAO();
		Teacher teacher = new Teacher();
		teacher.setFirstName(request.getParameter("fname"));
		teacher.setLastName(request.getParameter("lname"));
		teacher.setAddress(request.getParameter("address"));
		teacher.setDesignation(request.getParameter("designation"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dob = new Date();
		try {
			dob = sdf.parse(request.getParameter("dob"));
			teacher.setDob(dob);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		teacher.setPhone(Long.parseLong(request.getParameter("phone")));
		boolean flag =dao.save(teacher);
		
		if(flag)
		{
			 response.sendRedirect("teachList.jsp");
		} 
		else
		{
			 response.sendRedirect("error.jsp");

		}
		}
		catch(Exception exp)
		{
		
		 response.sendRedirect("error.jsp");
		}
	}

}

package learner.academy.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learner.academy.dao.DAO;
import learner.academy.model.MyClass;
import learner.academy.model.Student;

/**
 * Servlet implementation class saveStudent
 */
public class saveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveStudent() {
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
		Student student = new Student();
		student.setFirstName(request.getParameter("fname"));
		student.setLastName(request.getParameter("lname"));
		student.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dob = null;
		try {
			dob = sdf.parse(request.getParameter("dob"));
			student.setDob(dob);
			System.out.println(dob);
			//System.out.println( new java.sql.Date (dob.getTime()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		Long cid = Long.parseLong(request.getParameter("class"));
		MyClass myclass =  dao.getClass(cid);
		if(myclass!=null)
		{student.setMyclass(myclass);}
		student.setPhone(Long.parseLong(request.getParameter("phone")));
		boolean flag =dao.save(student);
		
		if(flag)
		{
			 response.sendRedirect("slist.jsp");
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

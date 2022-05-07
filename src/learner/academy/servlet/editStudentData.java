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
import learner.academy.model.Student;

/**
 * Servlet implementation class editStudentData
 */
public class editStudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editStudentData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		DAO dao = new DAO();
		Student student = new Student();
		student.setRollNo(Long.parseLong(request.getParameter("roll")));
		Student oldStudent = dao.getStudent(Long.parseLong(request.getParameter("roll")));
		student.setFirstName(request.getParameter("fname"));
		student.setLastName(request.getParameter("lname"));
		student.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		student.setMyclass(oldStudent.getMyclass());
		Date dob = new Date();
		try {
			dob = sdf.parse(request.getParameter("dob"));
			//student.setDob(dob);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		/*
		 * Long cid = Long.parseLong(request.getParameter("class")); MyClass myclass =
		 * dao.getClass(cid); if(myclass!=null) {student.setMyclass(myclass);}
		 */student.setPhone(Long.parseLong(request.getParameter("phone")));
		boolean flag = dao.update(student);

		if (flag) {
			response.sendRedirect("slist.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");

		} }
		catch(Exception exp)
		{
			response.sendRedirect("error.jsp");

		}
	}

}

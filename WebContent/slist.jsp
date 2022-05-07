<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import ="java.util.*,learner.academy.dao.*,learner.academy.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
<div align="center">
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>

<h3>List of Students</h3>
<form action="student.jsp">
<input type="submit" value="Add New Student">
</form>
<table border="1px">
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>DOB</th>
<th>Address</th>
<th>Phone</th>
<th>Class</th>
<th>Edit</th>
<th>Delete</th>

</tr>
<%   
DAO dao = new DAO();
List<Student> slist = dao.getStudentList();
if(slist!=null && slist.size()>0)
{
 for(int i=0;i<slist.size();i++)
 {
%>
<tr>
<td><%=slist.get(i).getRollNo() %></td>
<td><%= slist.get(i).getFirstName() %></td>
<td><%=slist.get(i).getLastName() %></td>
<td><%= slist.get(i).getDob() %></td>
<td><%=slist.get(i).getAddress() %></td>
<td><%= slist.get(i).getPhone() %></td>
<td><%=slist.get(i).getMyclass().getName() %></td>
<td><a href="editStudent?id=<%=slist.get(i).getRollNo()%>">Edit</a></td>
<td><a href="deleteStudent?id=<%=slist.get(i).getRollNo()%>">Delete</a></td>


</tr>

<%} }%>
</table>
</div>
</body>
</html>
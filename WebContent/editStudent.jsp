<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import="learner.academy.dao.*,java.util.*,learner.academy.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>
<div align="center">
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>
<% Student stud = (Student)request.getAttribute("student"); %>

<form action="editStudentData" method="post">
ID<input type="text" name="roll" value="<%= stud.getRollNo() %>" readonly><br>

FirstName<input type="text" name="fname" value="<%= stud.getFirstName() %>"><br>
LastName<input type="text" name="lname" value="<%=stud.getLastName()%>"><br>
DOB <input type="date" name="dob" value="<%= stud.getDob()%>"><br>
Address<input type="text" name="address" value="<%= stud.getAddress()%>"><br>
Phone<input type="number" name="phone" value="<%= stud.getPhone()%>"><br>
<%-- <%
DAO dao = new DAO();
List<MyClass> clist = dao.getClassList();
%>
Select Class<select name="class">
<option value="0">Select an option</option>
<%  if(clist!=null && clist.size()>0) {for(int i=0;i<clist.size();i++) {%> 
<option value="<%= clist.get(i).getId()%>"><%= clist.get(i).getName() %></option>
<%}} %>
</select> <br><br>
 --%>
 <input type="submit"value ="Save">
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import="java.util.*,learner.academy.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>

<%
List<Object[]> studTeacher =(List<Object[]>) request.getAttribute("st");
%>



<% List<Student> slist = (List<Student>) request.getAttribute("studList"); %>
     <%     if(slist!=null && slist.size()>0) {%>
     
	<h1>Class report of <%= slist.get(0).getMyclass().getName()%></h1>
	<%} %>
	
	<table border="1px ">
<tr>
<th>ID</th>
<th>Subject</th>
<th>Teacher Name</th>

</tr>
 <%  int count =1;
 for(Object[] s :studTeacher )
	{ %>
	<tr>
<td><%= count %></td>	
<td><%=s[1] %></td>
<td><%=s[0] %> <%=s[5] %></td>
</tr>
<% count ++;} %>
</table>
	
	<h3>Students List</h3>
	<table border="1px">
	<tr>
<th>ID</th>

<th>FirstName</th>
<th>LastName</th>
<th>DOB</th>
<th>Address</th>
<th>Phone</th>
</tr>
	

<%     if(slist!=null && slist.size()>0) {
for(int i=0;i<slist.size();i++)
 {
	%>
	
<tr>
<td><%= slist.get(i).getRollNo() %></td>

<td><%= slist.get(i).getFirstName() %></td>
<td><%=slist.get(i).getLastName() %></td>
<td><%= slist.get(i).getDob() %></td>
<td><%=slist.get(i).getAddress() %></td>
<td><%= slist.get(i).getPhone() %></td>

</tr>

<%} }%>
</table>

</div>
</body>
</html>
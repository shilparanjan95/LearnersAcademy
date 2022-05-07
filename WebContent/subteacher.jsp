<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
    <%@ page import ="java.util.*,learner.academy.dao.*,learner.academy.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject Teacher Mapping</title>
</head>
<body>
<div align="center">
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>


<h1>Add Subject and Teacher to <%= request.getParameter("name") %></h1>
<%
List<Object[]> studTeacher =(List<Object[]>) request.getAttribute("st");
%>
<%
DAO dao = new DAO();
List<Subject> clist = dao.getSubList();
%>
<form action="addSubTeacher" method="post">
<%-- <%= request.getParameter("id") %>
 --%><input type="hidden" value="<%= request.getParameter("id") %>" name="id">
Select Subject<select name="subject">
<option value="0">Select an option</option>
<% for(int i=0;i<clist.size();i++) {%> 
<option value="<%= clist.get(i).getId()%>"><%= clist.get(i).getName() %></option>
<%} %>
</select> <br><br>

<%

List<Teacher> tlist = dao.getTeacherList();
%>
Select Teacher<select name="teacher">
<option value="0">Select an option</option>
<% for(int i=0;i<tlist.size();i++) {%> 
<option value="<%= tlist.get(i).getId()%>"><%= tlist.get(i).getFirstName() +" "+tlist.get(i).getLastName() %></option>
<%} %>
</select><br><br>
<input type="submit" value="Save">
</form>
<table border="1px ">
<tr>
<th>ID</th>
<th>Subject</th>
<th>Teacher Name</th>
<th>Action</th>

</tr>
 <%  int count =1;
 for(Object[] s :studTeacher )
	{ %>
	<tr>
	<td><%=count %></td>
	
<td><%=s[1] %></td>
<td><%=s[0] %> <%=s[5] %></td>
<td><a href="DeleteSubTeacher?class=<%=s[2] %>&&sub=<%= s[3]%>&&teach=<%= s[4]%>">Delete</a></td>
</tr>
<% count ++;} %>
</table>
</div>
 </body>
</html>
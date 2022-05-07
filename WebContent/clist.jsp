<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import ="java.util.*,learner.academy.dao.*,learner.academy.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classes</title>
</head>
<body>
<div align="center">
<h3>Welcome <%=session.getAttribute("user") %></h3>
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>

<h3>List of classes</h3>
<form action="class.jsp">
<input type="submit" value="Add New Class">
</form>
<table border="1px">
<tr>
<th>Id</th>
<th>ClassName</th>
<th>Delete</th>
<th>Edit</th>
<th>SubjectAndTeacher</th>
<th>ClassReport</th>

</tr>
<%   
DAO dao = new DAO();
List<MyClass> clist = dao.getClassList();
 for(int i=0;i<clist.size();i++)
 {
%>
<tr>
<td><%=clist.get(i).getId() %></td>
<td><%= clist.get(i).getName() %></td>
<td><a href="deleteClass?id=<%=clist.get(i).getId()%>">Delete</a></td>
<td><a href="edit.jsp?id=<%=clist.get(i).getId()%>&&name=<%= clist.get(i).getName() %>">Edit</a></td>
<td><a href="subjectTeacher?id=<%=clist.get(i).getId()%>&&name=<%= clist.get(i).getName() %>">Subject and Teachers</a></td>
<td><a href="classReport?id=<%=clist.get(i).getId()%>&&name=<%= clist.get(i).getName() %>">Class Report</a></td>

</tr>

<%} %>
</table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import ="java.util.*,learner.academy.dao.*,learner.academy.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subjects</title>
</head>
<body>
<div align="center">
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>

<h3>List of Subjects</h3>
<form action="subject.jsp" >
<input type="submit" value="Add New Subject">
</form>
<table border="1px">
<tr>
<th>Id</th>
<th>Subject Name</th>
<th>Edit</th>
<th>Delete</th>

</tr>
<%   
DAO dao = new DAO();
List<Subject> slist = dao.getSubList();
if(slist!=null &&slist.size()>0){
 for(int i=0;i<slist.size();i++)
 {
%>
<tr>
<td><%=slist.get(i).getId() %></td>
<td><%= slist.get(i).getName() %></td>
<td><a href="editSub.jsp?id=<%=slist.get(i).getId() %>&&name=<%= slist.get(i).getName()%>">Edit</a></td>
<td><a href="deleteSubject?id=<%=slist.get(i).getId()%>">Delete</a></td>


</tr>

<%}} %>
</table>
</div>
</body>
</html>
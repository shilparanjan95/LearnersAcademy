<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Class</title>
</head>
<body>
<%

%>
<form action="editClass" method="post">
<label>Class ID:</label> <input type="text" name="id"  value="<%=request.getParameter("id") %>" readonly="readonly"><br>
<label>Class Name :</label> <input type="text" name="name" value="<%=request.getParameter("name") %>"><br>
<input type="submit" value="Submit">
</form>
</body>
</html>
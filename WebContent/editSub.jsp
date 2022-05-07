<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Subject</title>
</head>
<body>
<%

%>
<form action="editSubject" method="post">
<label>Subject  ID :</label> <input type="text" name="id"  value="<%=request.getParameter("id") %>" readonly="readonly"><br>
<label>Subject Name :</label> <input type="text" name="name" value="<%=request.getParameter("name") %>"><br>
<input type="submit" value="Submit">
</form>
</body>
</html>
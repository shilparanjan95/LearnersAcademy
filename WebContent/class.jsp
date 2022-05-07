<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Class</title>
</head>
<body>
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>


<form action="saveClass" method="post">
<input type="text" name="class">
<input type="submit"value ="Save">
</form>
</body>
</html>
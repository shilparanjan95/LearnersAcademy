<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import="learner.academy.dao.*,java.util.*,learner.academy.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Teacher</title>
</head>
<body>
<div align="center">
<a href="clist.jsp">Classes</a>
<a href="slist.jsp">Students</a>
<a href="subList.jsp">Subjects</a>
<a href="teachList.jsp">Teachers</a>
<a href="Logout">Logout</a>

<form action="saveTeacher" method="post">
FirstName<input type="text" name="fname"><br>
LastName<input type="text" name="lname"><br>
DOB <input type="date" name="dob"><br>
Address<input type="text" name="address"><br>
Phone<input type="number" name="phone"><br>
Designation<input type="text" name="designation"><br>

 <br><br>
<input type="submit"value ="Save">
</form>
</div>
</body>
</html>
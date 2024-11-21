<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Data</title>
</head>
<body>
<%ResultSet rs = (ResultSet) request.getAttribute("resultSet"); 
rs.next();%> 
<form action="save-update-student" method="post">

<input type="number" value="<%=rs.getInt(1)%>" name="StudentId" readonly="readonly"><br>
<input type="text" value="<%=rs.getString(2)%>" name="StudentName"><br>
<input type="email" value="<%=rs.getString(3)%>" name="StudentEmail"><br>
<input type="number" value="<%=rs.getInt(4)%>" name="StudentAge"><br>
<input type="text" value="<%=rs.getString(5)%>"name="StudentCourse"><br>
<input type="text" value="<%=rs.getString(6)%>"name="StudentCity"><br>
 <input type="submit" value="UPDATE">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student </title>
</head>
<body>
<h1>Enter the Details:-</h1>
<form action="add-student" method="post">

<input type="number" placeholder="Enter  the StudentId " name="StudentId"><br>
<input type="text" placeholder="Enter the StudentName " name="StudentName"><br>
<input type="email" placeholder="Enter  the StudentEmail"name="StudentEmail"><br>
<input type="number" placeholder="Enter the StudentAge "name="StudentAge"><br>
<input type="text" placeholder="Enter the StudentCourse "name="StudentCourse"><br>
<input type="text" placeholder="Enter the StudentCity " name="StudentCity"><br>
 <input type="submit" value="ADD">
</form>
</body>
</html>
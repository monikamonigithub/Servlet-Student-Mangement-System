<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student database</title>
</head>
<body>
<%
	ResultSet rs = (ResultSet) request.getAttribute("resultSet");

	%>
	<h1>All Students Details:-</h1>
	<table border ="" >
		<tr>
			<th>StudentId</th>
			<th>StudentName</th>
			<th>StudentEmail</th>
			<th>StudentAge</th>
			<th>StudentCourse</th>
			<th>StudentCity</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
		<td>
			<%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><a href="find-by-id?studentId=<%=rs.getInt(1)%>">UPDATE</a></td>
			<td><a href="delete-student?studentId=<%=rs.getInt(1)%>">DELETE</a></td>
			
		</tr>
		<%} %>

	</table>
	<h2><a href="index.jsp">Go back to dash Board </a></h2>


</body>
</html>
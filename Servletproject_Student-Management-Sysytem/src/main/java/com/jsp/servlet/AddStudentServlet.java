package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int StudentId=Integer.parseInt(req.getParameter("StudentId"));
		String StudentName=req.getParameter("StudentName");
		String StudentEmail=req.getParameter("StudentEmail");
		int StudentAge=Integer.parseInt(req.getParameter("StudentAge"));
		String StudentCourse=req.getParameter("StudentCourse");
		String StudentCity=req.getParameter("StudentCity");
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system", "root", "root");
			PreparedStatement pst=conn.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?,?)");
			pst.setInt(1, StudentId);
			pst.setString(2, StudentName);
			pst.setString(3, StudentEmail);
			pst.setInt(4, StudentAge);
			pst.setString(5, StudentCourse);
			pst.setString(6, StudentCity);
			pst.execute();
			resp.sendRedirect("index.jsp");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}

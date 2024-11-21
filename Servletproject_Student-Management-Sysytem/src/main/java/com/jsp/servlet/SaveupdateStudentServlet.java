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
@WebServlet("/save-update-student")
public class SaveupdateStudentServlet extends HttpServlet {
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
			PreparedStatement pst=conn.prepareStatement("UPDATE student SET studentName=?,studentEmail=?,studentAge=?,studentCourse=?,studentCity=? WHERE studentId=?");
			
			pst.setString(1, StudentName);
			pst.setString(2, StudentEmail);
			pst.setInt(3, StudentAge);
			pst.setString(4, StudentCourse);
			pst.setString(5, StudentCity);
			pst.setInt(6, StudentId);
			pst.executeUpdate();
			resp.sendRedirect("display-all-students");

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

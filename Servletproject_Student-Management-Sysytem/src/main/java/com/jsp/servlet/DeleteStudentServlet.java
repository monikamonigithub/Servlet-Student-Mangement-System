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

@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  int studentId=Integer.parseInt(request.getParameter("studentId"));
    	  Connection conn=null;
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system", "root", "root");

            // Execute the query
            
            PreparedStatement pst= conn.prepareStatement("DELETE FROM student WHERE studentID=?");
            pst.setInt(1, studentId);
        pst.execute();


    	response.sendRedirect("display-all-students");
         
        } catch (Exception e) {
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

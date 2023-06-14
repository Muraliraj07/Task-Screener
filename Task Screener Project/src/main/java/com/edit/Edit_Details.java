package com.edit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;

/**
 * Servlet implementation class Edit_Details
 */
public class Edit_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String assigned_to=request.getParameter("assign");
		String department=request.getParameter("dept");
		String priority=request.getParameter("priority");
		String task_type=request.getParameter("task");
		int hour_Spent=Integer.parseInt(request.getParameter("hour"));
		String due_date=request.getParameter("due");
		String customer=request.getParameter("cus");
		String status=request.getParameter("status");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","");
			PreparedStatement ps=con.prepareStatement("update taskdata set title=?,description=?, assigned_to=?, department=?, priority=?, task_type=?, hour_Spent=?, due_date=?, customer=?, status=? where id=?");
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, assigned_to);
			ps.setString(4, department);
			ps.setString(5, priority);
			ps.setString(6, task_type);
			ps.setInt(7, hour_Spent);
			ps.setString(8, due_date);
			ps.setString(9, customer);
			ps.setString(10, status);
			ps.setInt(11, id);
			
			ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		response.sendRedirect("Display_Task.jsp");

	}

}

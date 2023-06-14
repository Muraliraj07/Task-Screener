//package com.display;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.sql.*;
//
///**
// * Servlet implementation class Display_Task
// */
//public class Display_Task extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Display_Task() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter pw=response.getWriter();
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","");
//			PreparedStatement ps=con.prepareStatement("select*from taskdata");
//			ResultSet rs=ps.executeQuery();
//			
//			pw.print("<table border='1'>");
//			pw.print("<tr><th>ID</th><th>Title</th><th>Created Time</th><th>Description</th><th>Assigned To</th>"
//					+ "<th>Department</th><th>Priority</th><th>Task Type</th><th>Hours Spent</th><th>Due Date</th>"
//					+ "<th>Customer</th><th>Status</th></tr>");
//			
//			
//			while(rs.next()) {
//				int id=rs.getInt("id");
//				String title=rs.getString("title");
//				Timestamp created_time = rs.getTimestamp("create_datetime");
//				String description=rs.getString("description");
//				String asigned=rs.getString("assigned_to");
//				String dept=rs.getString("department");
//				String priority=rs.getString("priority");
//				String tasktype=rs.getString("task_type");
//				String hour=rs.getString("hour_Spent");
//				String due=rs.getString("due_date");
//				String cus=rs.getString("customer");
//				String status=rs.getString("status");
//
//				
//				pw.print("<tr><td><a href='Full_Details?id="+id+"'>" +id+ "</a></td><td>" +title+ "</td><td>" +created_time+ "</td><td>" +description+ "</td><td>" +asigned+ "</td>"
//						+ "<td>" +dept+ "</td><td>" +priority+ "</td><td>" +tasktype+ "</td><td>" +hour+ "</td><td>" +due+ "</td>"
//								+ "<td>" +cus+ "</td><td>" +status+ "</td><td><input type='button' value='Edit' onclick=\"window.location.href='Edit.jsp?id="+id+"'\">\r\n"
//										+ " <input type='button' value='Delete' onclick=\"window.location.href='Delete?id="+id+"'\"></td> </tr>");
//				
//			}
//			pw.print("</table>");
//			con.close();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//	}
//
//}

package com.details;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Servlet implementation class Full_Details
 */
public class Full_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Full_Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String sid = request.getParameter("id");		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "");
		    PreparedStatement ps=con.prepareStatement("SELECT * FROM taskdata WHERE id = ?");
		    ps.setString(1, sid);
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		        String title = rs.getString("title");
		        Timestamp create_datetime = rs.getTimestamp("create_datetime");
				String description=rs.getString("description");
				String asigned=rs.getString("assigned_to");
				String dept=rs.getString("department");
				String priority=rs.getString("priority");
				String tasktype=rs.getString("task_type");
				String hrspent=rs.getString("hour_Spent");
				String due=rs.getString("due_date");
				String cus=rs.getString("customer");
				String stat=rs.getString("status");
				

		        pw.print("<h1>Task Details</h1>");
		        pw.print("<p>ID: " + sid + "</p>");
		        pw.print("<p>Title: " + title + "</p>");
		        pw.print("<p>Created Time: " + create_datetime + "</p>");
		        pw.print("<p>Description: " + description + "</p>");
		        pw.print("<p>Assigned: " + asigned + "</p>");
		        pw.print("<p>Department: " + dept + "</p>");
		        pw.print("<p>Priority: " + priority + "</p>");
		        pw.print("<p>Task Type: " + tasktype + "</p>");
		        pw.print("<p>Hour Spent: " + hrspent + "</p>");
		        pw.print("<p>Due Date: " + due + "</p>");
		        pw.print("<p>Customer: " + cus + "</p>");
		        pw.print("<p>Status: " + stat + "</p>");
		    }   
		    
		    // for comment session
		    pw.print("<h2>Add a comment</h2>");
	        pw.print("<form method='post'>");
	        pw.print("<textarea name='comment'></textarea><br>");
	        pw.print("<input type='submit' value='Submit'>");
	        pw.print("</form>");
		  
		    
		    PreparedStatement ps2=con.prepareStatement("select * from comments where id=?");
		    ps2.setString(1, sid);
		    ResultSet rs2=ps2.executeQuery();
		    
		    pw.print("<h2>Comments</h2>");
		    pw.print("<div style='overflow-y:scroll; height:300px;'>");
		    
		    while(rs2.next()) {
		    	String comment=rs2.getString("comment");
		    	Timestamp time=rs2.getTimestamp("time");
		    	pw.print("<div >");
		    	pw.print("<p>" + comment + "</p>");
		    	pw.print("<p style='color: gray;border-bottom:1px solid black';>" + time + "</p><br>");
		    	pw.print("</div>");
		    	
		    }
		    pw.print("</div>");
		    
		    con.close();
	}
		catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
		    String comment = request.getParameter("comment");

		    Timestamp time = new Timestamp(System.currentTimeMillis());
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","");

		        String sql = "insert into comments (id, comment, time) values (?, ?, ?)";
		        PreparedStatement ps = con.prepareStatement(sql);

		        ps.setString(1, id);
		        ps.setString(2, comment);
		        ps.setTimestamp(3, time);

		        ps.executeUpdate();
		        con.close();
		        doGet(request, response); 
		   
	}
		    catch (Exception e) {
		    	System.out.println(e);
		    }

}
}

<%@ 
page import="java.sql.*"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.css"></link>
</head>
<body>

<div class="container">
	<h1 class="text-center">Task Details</h1>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Created Time</th>
			<th>Description</th>
			<th>Assigned To</th>
			<th>Department</th>
			<th>Priority</th>
			<th>Task Type</th>
			<th>Hours Spent</th>
			<th>Due Date</th>
			<th>Customer</th>
			<th>Status</th>
			<th colspan="2">Action</th>
		</tr>
		
		<%
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select*from taskdata");
			
			while(rs.next()){
				int id=rs.getInt("id");
				String title=rs.getString("title");
				Timestamp created_time = rs.getTimestamp("create_datetime");
				String description=rs.getString("description");
				String asigned=rs.getString("assigned_to");
				String dept=rs.getString("department");
				String priority=rs.getString("priority");
				String tasktype=rs.getString("task_type");
				String hour=rs.getString("hour_Spent");
				String due=rs.getString("due_date");
				String cus=rs.getString("customer");
				String status=rs.getString("status");
				
		%>
		<tr>
			<td>
			<a href='Full_Details?id=<%= rs.getInt("id") %>'>
			<%= rs.getInt("id") %>
			</a>
			</td>
			<td><%= rs.getString("title") %></td>
			<td><%= rs.getTimestamp("create_datetime") %></td>
			<td><%= rs.getString("description") %></td>
			<td><%= rs.getString("assigned_to") %></td>
			<td><%= rs.getString("department") %></td>
			<td><%= rs.getString("priority") %></td>
			<td><%= rs.getString("task_type") %></td>
			<td><%= rs.getString("hour_Spent") %></td>
			<td><%= rs.getString("due_date") %></td>
			<td><%= rs.getString("customer") %></td>
			<td><%= rs.getString("status") %></td>
			<td>
			<input type='button' value='Edit' class="btn-sm btn-primary mb-3" onclick="window.location.href='Edit.jsp?id=<%= rs.getInt("id") %>'">
			
			<input type='button' value='Delete' class="btn-sm btn-danger" onclick="window.location.href='Delete?id=<%= rs.getInt("id") %>'">
			</td>
		</tr>
		
		
		<%	
			}    
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		%>
	</table>
<input type="button" class="btn btn-primary" value="Create" onclick="window.location.href='Index.html'" />


</div>



</body>
</html>
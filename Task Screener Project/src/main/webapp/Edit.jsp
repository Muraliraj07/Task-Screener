<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="com.edit.Edit" %>


	<%
    //int userId = 1000; // Set the user ID here
    int userId=Integer.parseInt(request.getParameter("id"));
    Edit user = new Edit();
    user.setId(userId);
    user.getdata();
	%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="Edit.css"></link>

</head>
<body>
<div>
	<div class="container">
	<form action="Edit_Details?id=<%= user.getId() %>" method="post">
    
	   <div>
		<h2 class="text-center mb-5">Edit Page</h2>
		<div>
			<input type="text" placeholder="Title" value="<%= user.getTitle() %>" name="title" class="line" width="100%">
		</div>	
		
		<div class="mt-3 mb-3"> 
		<textarea name="description" placeholder="Description"  cols="100" rows="4"><%= user.getDescription() %></textarea><br>
		</div>	
	</div>

	<div>
		<div class="row ">
			<div class="col-4">
				<div>
				<input type="text" name="assign" placeholder="Assigned to"  value="<%= user.getAsigned() %>" class="line1 mt-3"><br>
				<input type="text" name="dept" placeholder="Choose department" value="<%= user.getDept() %>"  class="mt-2 line1">
				</div>
				
				<select name="priority" class="mt-3">
    				<option>Select Priority</option>
    				<option value="High" <%= user.getPriority().equals("High") ? "selected" : "" %>>High</option>
   					<option value="Medium" <%= user.getPriority().equals("Medium") ? "selected" : "" %>>Medium</option>
    				<option value="Low" <%= user.getPriority().equals("Low") ? "selected" : "" %>>Low</option>
				</select><br>
			</div>


			<div class="col-4">
				<select class="drpdwn mt-3" name="task">
    				<option value="">Task type</option>
   				 	<option value="Bug" <%= user.getTasktype().equals("Bug") ? "selected" : "" %>>Bug</option>
				    <option value="Additional" <%= user.getTasktype().equals("Additional") ? "selected" : "" %>>Additional</option>
				    <option value="Testing" <%= user.getTasktype().equals("Testing") ? "selected" : "" %>>Testing</option>
				    <option value="API" <%= user.getTasktype().equals("API") ? "selected" : "" %>>API</option>
				    <option value="Implementation" <%= user.getTasktype().equals("Implementation") ? "selected" : "" %>>Implementation</option>
				    <option value="Estimation" <%= user.getTasktype().equals("Estimation") ? "selected" : "" %>>Estimation</option>
				</select><br>

 				<input type="number" name="hour" placeholder="Hour spent" value="<%= user.getHour() %>" class="line1 mt-3"><br>
 			</div>

			<div class="col-4">
				<input type="text" name="due" placeholder="Due date" value="<%= user.getDue() %>" class="line1 mt-3"><br>
				
				<input type="text" name="cus" placeholder="Choose customer" value="<%= user.getCus() %>" class="line1 mt-3"><br>

				<select class="drpdwn mt-3" name="status">
					<option selected disabled>Choose status</option>					
					<option value="Open" <%= user.getStatus().equals("Open") ? "selected" : "" %>>Open</option>
					<option value="Close" <%= user.getStatus().equals("Close") ? "selected" : "" %>>Close</option>
					<option value="Rework" <%= user.getStatus().equals("Rework") ? "selected" : "" %>>Rework</option>
					<option value="Testing" <%= user.getStatus().equals("Testing") ? "selected" : "" %>>Testing</option>
					<option value="Re-testing" <%= user.getStatus().equals("Re-testing") ? "selected" : "" %>>Re-testing</option>
				</select><br>
			</div>	
		</div>	

		<div class="row mt-3">
		<div class="text-center">
			<input type="submit" value="Update" class="btn btn-success mx-auto">
		</div>
		
	</div>
	</div>
	</form>
	</div>
</div>	
</body>
</html>
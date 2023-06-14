package com.edit;

import java.sql.*;

public class Edit {
	int id;
	String title;
	Timestamp created_time;	
	String description;
	String asigned;
	String dept;
	String priority;
	String tasktype;
	int hour;
	String due;
	String cus;
	String status;
	
	public Edit() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAsigned() {
		return asigned;
	}

	public void setAsigned(String asigned) {
		this.asigned = asigned;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public String getCus() {
		return cus;
	}

	public void setCus(String cus) {
		this.cus = cus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void getdata() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task ","root","");
			PreparedStatement ps=con.prepareStatement("Select title,create_datetime,description,assigned_to,department,priority,"
					+ "task_type,hour_Spent,due_date,customer,status from taskdata where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				this.id=id;
				title=rs.getString("title");
				created_time=rs.getTimestamp("create_datetime");
				description=rs.getString("description");
				asigned=rs.getString("assigned_to");
				dept=rs.getString("department");
				priority=rs.getString("priority");
				tasktype=rs.getString("task_type");
				hour=rs.getInt("hour_Spent");
				due=rs.getString("due_date");
				cus=rs.getString("customer");
				status=rs.getString("status");
			}
			rs.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}

package cybersoft.java11.crm.model;

import java.sql.Date;

public class Task {
private int id;
private String name;
private String description;
private Date start_date;
private Date due_date;
private int assignee;
private int project_id;
private int status_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getStart_date() {
	return start_date;
}
public void setStart_date(Date start_date) {
	this.start_date = start_date;
}
public Date getDue_date() {
	return due_date;
}
public void setDue_date(Date due_date) {
	this.due_date = due_date;
}
public int getAssignee() {
	return assignee;
}
public void setAssignee(int assignee) {
	this.assignee = assignee;
}
public int getProject_id() {
	return project_id;
}
public void setProject_id(int project_id) {
	this.project_id = project_id;
}
public int getStatus_id() {
	return status_id;
}
public void setStatus_id(int status_id) {
	this.status_id = status_id;
}
public Task(int id, String name, String description, Date start_date, Date due_date, int assignee, int project_id,
		int status_id) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.start_date = start_date;
	this.due_date = due_date;
	this.assignee = assignee;
	this.project_id = project_id;
	this.status_id = status_id;
}
public Task() {
	super();
	// TODO Auto-generated constructor stub
}

}

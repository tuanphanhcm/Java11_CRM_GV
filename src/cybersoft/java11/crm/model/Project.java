package cybersoft.java11.crm.model;

import java.sql.Date;

public class Project {
	private int id;
	private String name;
	private String description;
	private Date start_date;
	private Date end_date;
	private User created_by_user;
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
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public User getCreated_by_user() {
		return created_by_user;
	}
	public void setCreated_by_user(User created_by_user) {
		this.created_by_user = created_by_user;
	}
	public Project(int id, String name, String description, Date start_date, Date end_date, User created_by_user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.created_by_user = created_by_user;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}

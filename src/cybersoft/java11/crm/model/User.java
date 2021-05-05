package cybersoft.java11.crm.model;

public class User {
private int id;
private String email;
private String passwork;
private String fullname;
private String address;
private String phone;
private Role role;
public User(int id, String email, String passwork, String fullname, String address, String phone, Role role) {
	super();
	this.id = id;
	this.email = email;
	this.passwork = passwork;
	this.fullname = fullname;
	this.address = address;
	this.phone = phone;
	this.role = role;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
	this.id = -1;
	this.email = "";
	this.passwork = "";
	this.fullname = "";
	this.address = "";
	this.phone = "";
	this.role = null;
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPasswork() {
	return passwork;
}
public void setPasswork(String passwork) {
	this.passwork = passwork;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}


}

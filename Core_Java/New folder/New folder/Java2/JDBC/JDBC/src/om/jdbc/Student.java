package om.jdbc;

public class Student {
private int sid;
private String sname;
private String city;
private String email;

public Student(){}
public Student(int sid, String sname, String city, String email) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.city = city;
	this.email = email;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}

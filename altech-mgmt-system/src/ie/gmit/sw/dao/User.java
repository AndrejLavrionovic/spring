package ie.gmit.sw.dao;

import java.util.Date;

public class User {
	
	// fields
	private int userid;
	private String firstname;
	private String lastname;
	private int empnum;
	private Date registered;
	private Date dob;
	private int tel;
	private String email;
	private String nationality;
	private int status;
	private int siteid;
	private int addressid;
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CONSTRUCTORS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User(){}
	
	public User(String firstname, String lastname, int empnum,
			Date registered, Date dob, int tel, String email,
			String nationality, int status, int siteid, int addressid){
		this.firstname = firstname;
		this.lastname = lastname;
		this.empnum = empnum;
		this.registered = registered;
		this.dob = dob;
		this.tel = tel;
		this.email = email;
		this.nationality = nationality;
		this.status = status;
		this.siteid = siteid;
		this.addressid = addressid;
	}
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GETTERS/SETTERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid){
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getEmpnum() {
		return empnum;
	}
	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}
	public Date getRegistered() {
		return registered;
	}
	public void setRegistered(Date registered){
		this.registered = registered;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSiteid() {
		return siteid;
	}
	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
}

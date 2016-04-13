package ie.gmit.sw.dao;

import java.util.Date;

public class User {
	
	// fields
	private int userid;
	private String firstname;
	private String lastname;
	private int empnum;
	private int posid;
	private Date registered;
	private int tel;
	private String email;
	private String nationality;
	private int status;
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CONSTRUCTORS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User(){}
	
	public User(String firstname, String lastname, int empnum,
			Date registered, int tel, String email,
			int posid, String nationality, int status){
		this.firstname = firstname;
		this.lastname = lastname;
		this.empnum = empnum;
		this.registered = registered;
		this.tel = tel;
		this.email = email;
		this.posid = posid;
		this.nationality = nationality;
		this.status = status;
	}
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GETTERS/SETTERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::

	public int getPosid() {
		return posid;
	}
	public void setPosid(int posid){
		this.posid = userid;
	}
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
}

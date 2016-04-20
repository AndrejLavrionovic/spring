package ie.gmit.sw.dao;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	// fields
	private int userid;
	
	@Size(min=3, max=40, message="The name must be 3-40 characters long.")
	private String firstname;
	
	@Size(min=3, max=40, message="The lastname must be 3-40 characters long.")
	private String lastname;
	
	@NotNull(message="Employee number field must be completed.")
	@Min(value=100000, message="Employee number must be higher than 100000.")
	private int empnum;
	
	@NotNull(message="Employee number field must be completed.")
	private int posid;
	
	private Date registered;
	
	@Size(min=10, max=10, message="Telephone must contain 9 characters")
	private String tel;
	
	@NotNull
	@Pattern(regexp=".*\\@.*\\..*", message="Email is not valid.")
	private String email;
	
	@NotNull
	@Size(min=3, max=3, message="Enter 3 character for nationality.")
	private String nationality;
	
	@NotNull
	private int statusid;
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CONSTRUCTORS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User(){}
	
	public User(String firstname, String lastname, int empnum,
			Date registered, String tel, String email,
			int posid, String nationality, int statusid){
		this.firstname = firstname;
		this.lastname = lastname;
		this.empnum = empnum;
		this.registered = registered;
		this.tel = tel;
		this.email = email;
		this.posid = posid;
		this.nationality = nationality;
		this.statusid = statusid;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
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
		return statusid;
	}
	public void setStatus(int statusid) {
		this.statusid = statusid;
	}
}

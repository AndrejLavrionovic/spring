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
	
	@NotNull
	@Pattern(regexp=".*\\@.*\\..*", message="Email is not valid.")
	private String email;
	
	@NotNull(message="Employee number field must be completed.")
	@Min(value=100000, message="Employee number must be higher than 100000.")
	private int empnum;

	private Date regDate;
	
	@Size(min=10, max=10, message="Telephone must contain 9 characters")
	private String tel;
	
	@NotNull
	@Size(min=3, max=3, message="Enter 3 character for nationality.")
	private String nationality;
	
	@NotNull(message="Employee number field must be completed.")
	private int positionid;
	
	@NotNull
	private int statusid;
	
	private String address1;
	private String address2;
	private String town;
	private String county;
	
	private String username;
	private String password;
	private int enabled;
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CONSTRUCTORS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User(){}
	
	public User(String firstname, String lastname, int empnum, Date regDate,
			String tel, String email, int positionid, String nationality, int statusid,
			String address1, String address2, String town, String county,
			String username, String password, int enabled){
		this.firstname = firstname;
		this.lastname = lastname;
		this.empnum = empnum;
		this.regDate = regDate;
		this.tel = tel;
		this.email = email;
		this.positionid = positionid;
		this.nationality = nationality;
		this.statusid = statusid;
		this.address1 = address1;
		this.address2 = address2;
		this.town = town;
		this.county = county;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GETTERS/SETTERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpnum() {
		return empnum;
	}

	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getPositionid() {
		return positionid;
	}

	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
}

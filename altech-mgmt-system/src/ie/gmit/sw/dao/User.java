package ie.gmit.sw.dao;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	// fields
	private int userid;
	
	@Size(min=3, max=45, message="The username must be 3-40 characters long.")
	@NotNull
	private String username;
	@Size(min=4, max=16, message="The password must be 3-40 characters long.")
	@NotNull
	private String password;
	private boolean enabled = false;
	
	@NotNull
	@Pattern(regexp=".*\\@.*\\..*", message="Email is not valid.")
	private String email;
	
	@NotNull(message="Employee number field must be completed.")
	@Min(value=100000, message="Employee number must be higher than 100000.")
	private int empnum;
	
	@Size(min=3, max=40, message="The name must be 3-40 characters long.")
	@NotNull
	private String firstname;
	
	@Size(min=3, max=40, message="The lastname must be 3-40 characters long.")
	@NotNull
	private String lastname;
	private int tel;
	
	@NotNull
	private String authority;
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CONSTRUCTORS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User(){}
	
	public User(int userid, String username, String password, boolean enabled, String email, int empnum,
			String firstname, String lastname, int tel, String authority) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.empnum = empnum;
		this.firstname = firstname;
		this.lastname = lastname;
		this.tel = tel;
		this.authority = authority;
	}
	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}

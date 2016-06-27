package ie.gmit.sw.dao;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import ie.gmit.sw.dao.user.UserDobConverter;

public class User {
	
	// fields
	@NotBlank(message="Username cannot be blank.")
	@Size(min=4, max=10, message="Username must be 4-10 characters long")
	@Pattern(regexp = "^[A-Z,a-z]\\w{3,9}$", message="The username is not match conditions.")
	private String username;
	
	@Size(min=4, max=16, message="The password must be 3-40 characters long.")
	@NotNull
	@NotBlank(message="Password cannot be blank.")
	@Pattern(regexp="^\\S+$", message="Password cannot contain spaces.")
	private String password;
	
	private boolean enabled = false;
	private String email;
	private String firstname;
	private String lastname;
	private String authority;
	private Integer telNumber;
	private String telPrefix;
	private String tel;
	private Integer empnum;
	private Date dob;
	private Integer month;
	private Integer day;
	private Integer year;
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// INSTANCES
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	private UserDobConverter dobConverter = new UserDobConverter();
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CONSTRUCTORS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User(){
	}
	
	public User(String username, String password, boolean enabled, String email, Integer empnum,
			String firstname, String lastname, String tel, String authority, Date dob) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.empnum = empnum;
		this.firstname = firstname;
		this.lastname = lastname;
		this.tel = tel;
		this.authority = authority;
		this.dob = dob;
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

	public Integer getEmpnum() {
		return empnum;
	}

	public void setEmpnum(Integer empnum) {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setTel(String telPrefix, Integer telNumber){
		this.tel = telPrefix.concat(String.format("%d", telNumber));
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public Date getDob(){
		return dob;
	}
	
	public void setDob(Date dob){
		this.dob = dob;
	}
	
	public void setDob(){
		dobConverter.setCalendarDob(this.year, this.month, this.day);
		this.dob = dobConverter.getDateDob(dobConverter.getCalendarDob());
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public String getTelPrefix(){
		return this.telPrefix;
	}
	public void setTelPrefix(String telPrefix){
		this.telPrefix = telPrefix;
	}
	public Integer getTelNumber(){
		return this.telNumber;
	}
	public void setTelNumber(Integer telNumber){
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", enabled=" + enabled + ", email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", authority=" + authority + ", telNumber=" + telNumber + ", telPrefix="
				+ telPrefix + ", tel=" + tel + ", empnum=" + empnum + ", dob=" + dob + ", month=" + month + ", day="
				+ day + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((empnum == null) ? 0 : empnum.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((telNumber == null) ? 0 : telNumber.hashCode());
		result = prime * result + ((telPrefix == null) ? 0 : telPrefix.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.toString().equals(other.dob.toString()))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empnum == null) {
			if (other.empnum != null)
				return false;
		} else if (!empnum.equals(other.empnum))
			return false;
		if (enabled != other.enabled)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}

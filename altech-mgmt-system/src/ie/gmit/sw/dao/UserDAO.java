package ie.gmit.sw.dao;

import java.util.List;

public interface UserDAO {

	public List<User> getAllUsers();
	public User getUserById(int userid);
	public User getUserByEmployeeNumber(int empnum);
	public User getUserByName(String firstname, String lastname);
}

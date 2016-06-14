package ie.gmit.sw.dao;

import java.util.List;

public interface UserDAO {

	public List<User> getAllUsers();
	public boolean createUser(User user);
	public boolean exists(String username);
	public User getUserByEmpnum(int empnum);
	public User getUserByUsername(String username);
	public int updateUser(User user);
}

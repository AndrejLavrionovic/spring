package ie.gmit.sw.dao;

import java.util.List;

public interface UserDAO {

	public List<User> getAllUsers();
	public boolean createUser(User user);
}

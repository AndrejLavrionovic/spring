package ie.gmit.sw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.dao.User;
import ie.gmit.sw.dao.UserDAO;
import ie.gmit.sw.dao.UserDaoImpl;

@Service("usersService")
public class UsersService {

	private UserDAO userDao;
	
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public  List<User> getCurrent(){
		return userDao.getAllUsers();
	}

	// create user
	public void create(User user) {
		userDao.createUser(user);
	}
	
	// get users
//	public User getUser(int empnum){
//		return userDao.getUserByEmpnum(empnum);
//	}
	public void getUser(String name){
		
	}
	
}

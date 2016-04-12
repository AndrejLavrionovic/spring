package ie.gmit.sw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.dao.User;
import ie.gmit.sw.dao.UserDaoImpl;

@Service("usersService")
public class UsersService {

	private UserDaoImpl userDao;
	
	@Autowired
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public  List<User> getCurrent(){
		return userDao.getAllUsers();
	}
	
}

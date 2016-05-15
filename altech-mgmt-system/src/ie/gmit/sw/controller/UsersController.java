package ie.gmit.sw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.dao.User;
import ie.gmit.sw.service.UsersService;

@Controller
public class UsersController {
	
	private UsersService userService;
	
	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}


	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// USERS.JSP PAGE EXECUTION
	// POPULATES TABLE WITH USERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping("/users")
	public String showUsers(Model model){
		
		List<User> users = userService.getCurrent();
		
		model.addAttribute("users", users);
		
		return "users";
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE.JSP PAGE EXECUTION
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping("/create")
	public String createUser(Model model){
		model.addAttribute("user", new User());
		
		return "create";
	}

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE USER FORM EXECUTION
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(@Valid User user, BindingResult result){
		
		// Validation #1
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		if(result.hasErrors()){
			System.out.println("NOT VALID");
			return "create";
		}
		
		if(userService.exists(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.users.username", "This username allready exists!");
			return "create";
		}
		
		try {
			userService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.users.username", "This username allready exists!");
			return "create";
		}
		
		
		return "usercreated";
	}
	
	@RequestMapping(value="/getuserbyid", method=RequestMethod.POST)
	public String showUserById(Model model, int empnum){
		
		User user = userService.getUser(empnum);
		
		model.addAttribute("user", user);
		
		System.out.println(user.toString());
		return "users";
	}
}

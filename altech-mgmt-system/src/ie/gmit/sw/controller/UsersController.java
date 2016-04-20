package ie.gmit.sw.controller;

import java.util.List;

import javax.validation.Valid;

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
	
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	public void showUsers(Model model){
		
		List<User> users = userService.getCurrent();
		
		model.addAttribute("users", users);
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
	// FORM EXECUTION
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid User user, BindingResult result){
		
		// Validation #1
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		if(result.hasErrors()){
			
			return "create";
		}else{
			return "usercreated";
		}
	}

	@RequestMapping("/users")
	public String showHome(){
		
		return "users";
	}
	
	@RequestMapping("/usercreated")
	public String showUserCreated(){
		return "usercreated";
	}
}

package ie.gmit.sw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/create")
	public String showCreate(){
		return "create";
	}

	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, User user){
		
		return "usercreated";
	}

	@RequestMapping("/users")
	public String showHome(){
		
		
		
		return "users";
	}
}

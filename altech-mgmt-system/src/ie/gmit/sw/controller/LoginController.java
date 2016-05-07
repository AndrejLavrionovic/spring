package ie.gmit.sw.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.dao.User;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping(value="/dologin", method=RequestMethod.POST)
	public String doLogin(User user){
		
		System.out.println("Username is: " + user.getUsername() + " - " + user.getPassword());
		
		return "home";
	}
}

package ie.gmit.sw.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.dao.User;
import ie.gmit.sw.service.UsersService;

@Controller
public class UsersController {
	
	private static Logger logger = Logger.getLogger(UsersController.class);
	
	private UsersService userService;
	
	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	private String getUsername(Principal principal){
		return principal.getName();
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// USERS.JSP PAGE EXECUTION
	// POPULATES TABLE WITH USERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping("/users")
	public String showUsers(Model model, Principal principal){
		try{
			model.addAttribute("username", getUsername(principal)); // is user logged in
			
			List<User> users = userService.getCurrent();
			
			model.addAttribute("users", users);
			
			return "users";
		}
		catch(NullPointerException ex){
			model.addAttribute("username", null);
			
			return "login";
		}
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE.JSP PAGE EXECUTION
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping("/create")
	public String createUser(Model model, Principal principal){
		model.addAttribute("user", new User());
		
		String username = null;
		try{
			username = principal.getName();
			model.addAttribute("username", username);
		}
		catch(NullPointerException ex){
			model.addAttribute("username", null);
		}
		
		return "create";
	}

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE USER FORM EXECUTION
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(@Valid User user, BindingResult result, Model model, Principal principal){
		
		// Validation #1
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		if(result.hasErrors()){
			logger.info("Data is Not Valid");
			return "create";
		}
		
		try { // if username allready exists
			userService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.users.username", "This username allready exists!");
			return "create";
		}
		
		String username = null;
		try{
			username = principal.getName();
			model.addAttribute("username", username);
		}
		catch(NullPointerException ex){
			model.addAttribute("username", null);
		}
		
		return "usercreated";
	}
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// RETRIEVE USER BY HIS EMPLOYEE NUMBER
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping(value="/getuserbyid", method=RequestMethod.POST)
	public String showUserById(Model model, int empnum, Principal principal){
		
		User user = userService.getUser(empnum);
		
		model.addAttribute("user", user);
		
		System.out.println(user.toString());
		
		String username = null;
		try{
			username = principal.getName();
			model.addAttribute("username", username);
		}
		catch(NullPointerException ex){
			model.addAttribute("username", null);
		}
		
		return "users";
	}
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// PROCEED TO THE EDIT USER FORM
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping(value="/edituser", method=RequestMethod.GET)
	public String goToUpdateUserForm(HttpServletRequest request, Model model, Principal principal){
		
		User user = null;
		String username = null;

		try{
			model.addAttribute("username", getUsername(principal)); // is user logged in
			
			username = request.getParameter("u");
			logger.info("You choose the edit user option (" + username + ") ........");
			
			
			if(username != null){
				user = userService.getUser(username);
				logger.info("User ----> " + user.toString());
			}
			else{
				user = new User();
				logger.info("User ----> " + user.toString());
			}
			
			model.addAttribute("user", user);
			
			return "edituserform";
		}
		catch(NullPointerException ex){
			model.addAttribute("username", null);
			
			return "login";
		}
	}
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// UPDATE EXISTING USER
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@RequestMapping(value="/doupdateuser", method=RequestMethod.POST)
	public String doUpdateUser(@Valid User user, BindingResult result, Model model, Principal principal){

		logger.info(user.toString());
		// Validation #1
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		/*
		if(result.hasErrors()){
			System.out.println("NOT VALID");
			
			model.addAttribute("user", user);
			return "edituserform";
		}
		*/
		
		String username = null;
		try{
			username = principal.getName();
			model.addAttribute("username", username);
		}
		catch(NullPointerException ex){
			model.addAttribute("username", null);
			return "login";
		}
		
		logger.info("User ---> " + user.toString());
		userService.update(user);
		//model.addAttribute("user", user);
		
		return "userupdated";
	}
}

package ie.gmit.sw.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.dao.AmsMessage;
import ie.gmit.sw.dao.User;
import ie.gmit.sw.service.AmsMsgService;
import ie.gmit.sw.service.AmsMsgServiceImpl;
import ie.gmit.sw.service.UsersService;

@Controller
public class AmsMsgController {
	
	private AmsMsgService amsMsgService;
	private UsersService userService;
	
	@Autowired
	public void setAmsMsgService(AmsMsgServiceImpl amsMsgService) {
		this.amsMsgService = amsMsgService;
	}
	
	@Autowired
	public void setUsersService(UsersService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value="/createamsmsg", method=RequestMethod.POST)
	public String doCreateMsg(AmsMessage amsMessage, Principal principal){
		
		String username = principal.getName();
		
		amsMessage.getUser().setUsername(username);
		
		System.out.println(amsMessage.toString());
		
		amsMsgService.createMsg(amsMessage);
		
		return "home";
	}
}

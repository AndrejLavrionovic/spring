package ie.gmit.sw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}

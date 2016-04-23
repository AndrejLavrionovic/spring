package ie.gmit.sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HollidaysController {


	@RequestMapping("/hollidays")
	public String showCreate(){
		return "hollidays";
	}
}

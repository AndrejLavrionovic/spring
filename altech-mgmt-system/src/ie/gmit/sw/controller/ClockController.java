package ie.gmit.sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClockController {

	@RequestMapping("/clock")
	public String showCreate(){
		return "clock";
	}
}

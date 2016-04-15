package ie.gmit.sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayrollController {

	@RequestMapping("/payroll")
	public String showCreate(){
		return "payroll";
	}
}

package pl.discount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/showLoginPage", method= RequestMethod.GET)
	public String showLoginPage() {
		
		return "login-page";
	}
}

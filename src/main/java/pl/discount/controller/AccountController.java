package pl.discount.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.discount.model.entity.Users;
import pl.discount.service.UsersService;

@Controller
public class AccountController {
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value="/accountPage", method=RequestMethod.GET)
	public String accountPage(Principal principal, Model theModel) {
		
		String username = principal.getName();
		Users user = usersService.findByUserName(username);
		theModel.addAttribute("User", user);
		
		return "account-view";
	}
	
}

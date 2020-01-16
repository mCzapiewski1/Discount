package pl.discount.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.discount.formtemplates.UserRegistrationTemplate;
import pl.discount.service.UsersService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UsersService userService;
	
	@RequestMapping(value = "/showRegisterPage", method = RequestMethod.GET)
	public String getRegisterPage(Model theModel) {
		
		UserRegistrationTemplate userTemplate = new UserRegistrationTemplate();
		theModel.addAttribute("newUser", userTemplate);
		
		return "register-page";
	}
	
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("newUser") UserRegistrationTemplate userTemplate, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "register-page";
		}else {
			userService.saveUsers(userTemplate);
			return "redirect:/showLoginPage";
		}
	}
}

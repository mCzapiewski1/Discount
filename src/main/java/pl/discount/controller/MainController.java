package pl.discount.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.discount.model.entity.Users;
import pl.discount.service.UsersService;

@Controller
public class MainController {
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String testPage(Model theModel) {
		
		Optional<Users> user = usersService.getUser(Integer.valueOf(1));
		System.out.println("WARTOSC user.name ===>>>>>>" + user.get().getUsername());
		String path = "user_images/iaintclicking.jpg";
		theModel.addAttribute("pic_path", path);
		
		return "main-view";
	}
}

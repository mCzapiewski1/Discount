package pl.discount.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.discount.model.entity.Items;
import pl.discount.model.entity.Users;
import pl.discount.service.ItemsService;
import pl.discount.service.UsersService;

@Controller
public class ItemsController {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	ItemsService itemsService;
	
	@RequestMapping(value="/myItemsPage", method=RequestMethod.GET)
	public String myItemPage(Principal principal, Model theModel) {
		
		String username = principal.getName();
		Users user = usersService.findByUserName(username);
		//TODO: Napisac query do items where user=:???;
		//Collection<Items> items = user.ge
		
		return "myitems-page";
	}
	
	@RequestMapping(value="/addItemPage", method=RequestMethod.POST)
	public String addItemPage(Model theModel) {
		
		Items newItem = new Items();
		theModel.addAttribute("newItem", newItem);
		
		return "addItem-view";
	}
	
	@RequestMapping(value="/saveItem", method=RequestMethod.POST)
	public String saveItem(@ModelAttribute("newItem") Items newItem) {
		
		itemsService.saveItem(newItem);
		
		return "redirect:/main-view";
	}
	
}

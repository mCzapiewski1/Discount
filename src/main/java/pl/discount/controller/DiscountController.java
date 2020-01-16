package pl.discount.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.discount.model.entity.Discount;
import pl.discount.model.entity.Users;
import pl.discount.service.DiscountService;
import pl.discount.service.UsersService;

@Controller
public class DiscountController {
	
	@Autowired
	DiscountService discountService;
	
	@Autowired
	UsersService usersService;
	
	
	@RequestMapping(value="/myDiscounts", method=RequestMethod.GET)
	public String myDiscountPage(Model theModel, Principal principal) {
		
		System.out.println(principal.getName());
		Users user = usersService.findByUserName(principal.getName());
		Collection<Discount> myDiscounts = user.getDiscounts();
		theModel.addAttribute("myDiscounts", myDiscounts);
		
		return "mydiscount-view";
	}
	
	@RequestMapping(value="/addDiscountPage", method=RequestMethod.GET)
	public String addDiscountPage(Model theModel) {
		
		Discount newDiscount = new Discount();
		theModel.addAttribute("newDiscount",newDiscount);
		
		return "addDiscount-view";
	}
	
	@RequestMapping(value="/editDiscount/{id}", method=RequestMethod.GET)
	public String editDiscountPage(Model theModel,@PathVariable(value="id") String id) {
		
		Optional<Discount> editOptDiscount = discountService.getDiscount(Integer.parseInt(id));
		Discount editDiscount = editOptDiscount.get();
		Discount editedDiscount = new Discount();
		theModel.addAttribute("editDiscount", editDiscount);
		theModel.addAttribute("editedDiscount", editedDiscount);
		
		return "editDiscount-view";
	}
	
	
	@RequestMapping(value="/saveDiscount", method=RequestMethod.POST)
	public String saveDiscount(Principal principal, @ModelAttribute("newDiscount") Discount newDiscount) {
		
		String username = principal.getName();
		Users user = usersService.findByUserName(username);
		newDiscount.setUser(user);
		discountService.saveDiscount(newDiscount);
		
		return "redirect:/myDiscounts";
	}
	
	@RequestMapping(value="/changeDiscount/{id}", method=RequestMethod.POST)
	public String editDiscount(Model theModel, @PathVariable(value="id") String id, @ModelAttribute("editedDiscount") Discount editedDiscount) {
		
		Optional<Discount> optDiscount = discountService.getDiscount(Integer.parseInt(id));
		Discount oldDiscount = optDiscount.get();
		oldDiscount.setAddress1(editedDiscount.getAddress1());
		oldDiscount.setAddress2(editedDiscount.getAddress2());
		oldDiscount.setAddress3(editedDiscount.getAddress3());
		oldDiscount.setAddress4(editedDiscount.getAddress4());
		oldDiscount.setEmail(editedDiscount.getEmail());
		oldDiscount.setName(editedDiscount.getName());
		oldDiscount.setNip(editedDiscount.getNip());
		oldDiscount.setPhoneNumber(editedDiscount.getPhoneNumber());
		oldDiscount.setZip(editedDiscount.getZip());
		discountService.saveDiscount(oldDiscount);
		
		return "redirect:/myDiscounts";
	}
}

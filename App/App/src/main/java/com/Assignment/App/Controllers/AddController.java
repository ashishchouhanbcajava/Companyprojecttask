package com.Assignment.App.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Assignment.App.Model.User;
import com.Assignment.App.Service.UserService;

@Controller
public class AddController {

	@Autowired
	private UserService userService;

	@GetMapping("/AddUserForm")
	public String addUserForm(Model model) {
		model.addAttribute("user", new User());
		return "AddUser";
	}

	@PostMapping("/Adduser")
	public String addUser(@ModelAttribute("user") User user) {
		user.setEnabled(true);
		User saveUser = userService.saveUser(user);
		if (saveUser != null) {
			return "redirect:/";

		} else {
			return "redirect:/AddUserForm";
		}
	}

	@GetMapping("/EditUserForm")
	public String populateUser(@RequestParam("id") Long id, Model model) {
		User byId = userService.getById(id);
		if(byId!=null)
		{
		
		model.addAttribute("user", byId);
		return "AddUser";
		}
		return "/";
	}

	@PostMapping("/EnabledandDisabled")
	@ResponseBody
	public String toggleEnabled(@RequestBody User user) {
	    User existingUser = userService.getById(user.getId());
	    if (existingUser != null) {
	        existingUser.setEnabled(user.getEnabled());
	        userService.saveUser(existingUser);
	        return "Success";
	    }
	    return "Failure";
	}


}

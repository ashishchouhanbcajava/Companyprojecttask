package com.Assignment.App.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Assignment.App.Service.UserService;

@Controller
public class ListController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String userList(Model model) {
		model.addAttribute("list", userService.getAll());
		return "ListOfUsers";
	}

}

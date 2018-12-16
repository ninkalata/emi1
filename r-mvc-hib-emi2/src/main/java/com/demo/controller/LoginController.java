package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.User;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/newuser")
	public String showFormForAdd(Model theModel) {

		// create model
		User theUser = new User();

		theModel.addAttribute("user", theUser);

		return "new-user-form";
	}

	@PostMapping("/saveUser")
	public String saveCustomer(@ModelAttribute("user") User theUser) {

		// save the customer 
		loginService.saveUser(theUser);

		return "new-user-registered";
	}

	@GetMapping("/loginform")
	public String showLoginForm(Model theModel) {

		// create model
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);

		return "login-form";
	}

	@PostMapping("/validateUser")
	public String validateUser(@ModelAttribute("user") User theUser) {

		// save the customer 
		if (loginService.validateUser(theUser) != null) {
			return "redirect:/customer/list";
		}
		return "login-error";
	}
}

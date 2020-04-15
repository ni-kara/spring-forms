package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.service.IUserService;

@Controller
@RequestMapping("/")
public class mainController {

	@Autowired
	private IUserService userService;

	// remove white space
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showSignUpPage")
	public String showRegisterPage(Model theModel) {
		theModel.addAttribute("user", new User());
		theModel.addAttribute("countries", userService.getCountries());

		return "SignUpPage";
	}

	@RequestMapping("/showSignInPage")
	public String showLoginPage(Model theModel) {
		theModel.addAttribute("user", new User());
		return "SignInPage";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult,	Model theModel) {

		System.out.println(theUser);
		
		if (theBindingResult.hasErrors()) 
		{
			theModel.addAttribute("user", theUser);
			theModel.addAttribute("countries", userService.getCountries());
			
			return "SignUpPage";
		} 
		else {
			userService.saveUser(theUser);
			return "SuccessPage";
		}
	}
}

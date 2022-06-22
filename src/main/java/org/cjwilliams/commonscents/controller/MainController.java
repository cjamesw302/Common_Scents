package org.cjwilliams.commonscents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Basic getmapping controller class for views 

@Controller
public class MainController {
	//Getmapping for index view
	@GetMapping("/")
	public String root() {
	    return "index";
	}
	//Getmapping for login view
	@GetMapping("/login")
	public String login(Model model) {
	    return "/login";
	}
	//Getmapping for home view
	@GetMapping("/home")
	public String home() {
	    return "home";
	}
}
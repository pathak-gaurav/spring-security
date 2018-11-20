package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String homePage(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "home-page";
	}
}

package com.validate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.entities.LoginData;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("loginData",new LoginData());
		return  "login";
	}
	
	@PostMapping("/process")
	public String success(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result) {
		System.out.println(loginData);
		if(result.hasErrors()) {
			System.out.println(result);
			return "login";
		}
		return "success";
	}

}

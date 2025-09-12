package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.User;

@Controller
public class HomeController {

	@GetMapping("/map-register")
    public String mapRegister() {
        return "register";
    }
	@GetMapping("/map-login")
	public String mapLogin() {
		return "login";
	}
	@GetMapping("/map-job")
	public String mapJobs() {
		return "addJob";
	}
}

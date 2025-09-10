package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/map-register")
	public String mapRegister() {
		return "register";
	}
	@GetMapping("/map-login")
	public String mapLogin() {
		return "login";
	}
	@GetMapping("/map-song")
	public String mapSongs() {
		return "addSongs";
	}
	@GetMapping("/samplePayment")
	public String samplePayment() {
		return "samplePayment";
	}
}

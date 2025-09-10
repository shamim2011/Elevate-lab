package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Songs;
import com.example.demo.entity.Users;
import com.example.demo.service.SongService;
import com.example.demo.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	@Autowired
	UsersService uservice;
	
	@Autowired
	SongService sgservice;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		boolean userstatus=uservice.emailExist(user.getEmail());
		if(userstatus==false) {
			uservice.addUser(user);
			return "registerSuccess";
		}
		return "registerFail";
	}
	
	@PostMapping("/login")
	public String validUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
		boolean loginStatus=uservice.validUser(email, password);
		if(loginStatus==true) {
			session.setAttribute("email", email);
			String role=uservice.getRole(email);
			if(role.equals("admin")) {
				return "adminHome";
			}
			else{
				return "customerHome";
			}	
		}
		return "loginFail";
	}
	@GetMapping("/exploreSong")
	public String exploreSongs(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		Users user=uservice.getUser(email);
		
		boolean userStatus=user.isPremium();
		if(userStatus==true) {
			List<Songs> sList=sgservice.fetchAllSongs();
			model.addAttribute("songlist",sList);
			return "displaySong";
		}
		else {
			return "samplePayment";
		}
	}
}

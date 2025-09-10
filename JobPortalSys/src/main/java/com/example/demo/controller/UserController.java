package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.service.JobService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userv;
	
	@Autowired
	JobService jserv;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		boolean userstatus = userv.emailExist(user.getEmail());
		if(userstatus == false) {
			userv.addUser(user);
			return "registerSuccess";
		}
		return "registerFail";
	}
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
		User user = userv.getUser(email);
		if(user != null && user.getPassword().equals(password)) {
			session.setAttribute("user", user);
			String role = userv.getRole(email);
			if(role.equals("EMPLOYER")) {
				return "adminHome";
			}
			else {
				return "customerHome";
			}
		}
		return "loginFail";
	}
	@GetMapping("/exploreJob")
	public String exploreJobs(HttpSession session,Model model) {
		String email = (String) session.getAttribute("email");
		User user = userv.getUser(email);
		boolean userstatus = user.isPremium();
		if(userstatus == true && user!=null) {
			List<Job> jlist = jserv.fetchAllJob();
			model.addAttribute("joblist",jlist);
			return "displayAllJob";
		}
		return "samplePayment";
	}
}

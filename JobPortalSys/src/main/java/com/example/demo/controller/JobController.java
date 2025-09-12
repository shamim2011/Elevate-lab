package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Job;
import com.example.demo.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class JobController {

	@Autowired
	JobService jserv;
	
	@PostMapping("/addJob")
	public String addJob(@ModelAttribute Job job) {
		long empId = job.getEmpId();
		boolean status = jserv.jobExist(empId);
		if(status == false) {
			jserv.addJob(job);
			return "jobAddSuccess";
		}
		return "jobAddFail";
	}
	@GetMapping("/exploreJob")
	public String exploreJobs(HttpSession session,Model model) {
		List<Job> jlist = jserv.fetchAllJob();
		model.addAttribute("joblist",jlist);
		return "displayAllJob";
	}
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Job;

public interface JobService {

	public String addJob(Job job);
	
	public boolean jobExist(String title);
	
	List<Job> fetchAllJob();
	
	public void updateJob(Job job);
	
}

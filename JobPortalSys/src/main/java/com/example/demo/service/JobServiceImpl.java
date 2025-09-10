package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobRepository jrepo;

	@Override
	public String addJob(Job job) {
		jrepo.save(job);
		return "Jobs are added Successfully";
	}

	@Override
	public boolean jobExist(String title) {
		Job job = jrepo.findByTitle(title);
		if(job==null) {
			return false;
		}
		return false;
	}

	@Override
	public List<Job> fetchAllJob() {
		List<Job> li = jrepo.findAll();
		return li;
	}

	@Override
	public void updateJob(Job job) {
		jrepo.save(job);
	}

	
}

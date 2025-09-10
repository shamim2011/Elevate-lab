package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	// ✅ Many Applications -> 1 Job
	@ManyToOne
	Job job;
	
	// ✅ Many Applications -> 1 Applicant (User)
	@ManyToOne
	User applicant;

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(int id, Job job, User applicant) {
		super();
		this.id = id;
		this.job = job;
		this.applicant = applicant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", job=" + job + ", applicant=" + applicant + "]";
	}
	
}

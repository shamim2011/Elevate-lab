package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String title;
	String description;
	String salary;
	String job_type;
	long emp_id;
	String link;
	
	 // Many jobs posted by one employer
	@ManyToOne
	User employee;
	
	// One job -> many applications
	@OneToMany
	List<Application> app;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int id, String title, String description, String salary, String job_type, long emp_id, String link,
			User employee, List<Application> app) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.salary = salary;
		this.job_type = job_type;
		this.emp_id = emp_id;
		this.link = link;
		this.employee = employee;
		this.app = app;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	} 

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public List<Application> getApp() {
		return app;
	}

	public void setApp(List<Application> app) {
		this.app = app;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", salary=" + salary
				+ ", job_type=" + job_type + ", emp_id=" + emp_id + ", link=" + link + ", employee=" + employee
				+ ", app=" + app + "]";
	}
}

package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // avoid conflict with SQL reserved word
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String email;
    private String fullName;
    private String gender;
    private String role;

    // By default every new user will be premium
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isPremium = true;

    // Employer -> Jobs
    @OneToMany
    private List<Job> jobs;

    // Applicant -> Applications
    @OneToMany
    private List<Application> applications;

    // --- Constructors ---
    public User() {}

    public User(int id, String username, String password, String email, String fullName,
                String gender, String role, boolean isPremium,
                List<Job> jobs, List<Application> applications) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.role = role;
        this.isPremium = isPremium;
        this.jobs = jobs;
        this.applications = applications;
    }

    // --- Getters & Setters ---
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public boolean isPremium() {
        return isPremium;
    }
    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public List<Job> getJobs() {
        return jobs;
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Application> getApplications() {
        return applications;
    }
    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    // --- toString() ---
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", isPremium=" + isPremium +
                '}';
    }
}

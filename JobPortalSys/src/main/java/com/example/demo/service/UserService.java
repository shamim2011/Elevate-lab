package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	public String addUser(User user);
	
	public boolean emailExist(String email);
	
	public boolean validateUser(String username,String password);
	
	public String getRole(String email);
	
	public User getUser(String email);
	
	public void updateUser(User user);
	
}

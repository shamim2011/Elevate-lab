package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository urepo;
	@Override
	public String addUser(User user) {
		urepo.save(user);
		return "user is created and saved";
	}

	@Override
	public boolean emailExist(String email) {
		if(urepo.findByEmail(email)==null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validateUser(String username, String password) {
		User user = urepo.findByEmail(password);
		String db_pass = user.getPassword();
		if(user != null && db_pass.equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public String getRole(String email) {
		User user = urepo.findByEmail(email);
		String role = user.getRole();
		return role;
	}

	@Override
	public User getUser(String email) {
		return urepo.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		urepo.save(user);
	}
}

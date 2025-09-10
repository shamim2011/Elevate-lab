package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{
	@Autowired
	UsersRepository urepo;
	
	@Override
	public String addUser(Users user) {
		urepo.save(user);
		return "User is created and saved";
	}

	@Override
	public boolean emailExist(String email) {
		if(urepo.findByEmail(email)==null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validUser(String email, String password) {
		Users user=urepo.findByEmail(email);
		
		String db_pass=user.getPassword();
		if(db_pass.equals(password)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public String getRole(String email) {
		Users user=urepo.findByEmail(email);
		String role=user.getRole();
		return role;
	}

	@Override
	public Users getUser(String email) {
		return urepo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		urepo.save(user);
		
	}
	
	
}

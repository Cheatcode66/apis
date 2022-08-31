package com.ivs.Student_Management_App.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivs.Student_Management_App.model.User;
import com.ivs.Student_Management_App.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> Login(User user){
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	public Optional<User> find(Integer id){
		return userRepository.findById(id);
	}
	public String Signup(User user) {
		try {
			if(!userRepository.findByUsername(user.getUsername()).isEmpty()) {
				System.out.println(userRepository.findByUsername(user.getUsername()).get().toString());
				return "Tai khoan da ton tai";
			}
			userRepository.save(user);
			return "tao tai khoan thanh cong";
			
		}
		catch(NoSuchElementException e) {
			userRepository.save(user);
			return "tao tai khoan thanh cong";
		}
		
	}
}

package com.ivs.Student_Management_App.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivs.Student_Management_App.model.Student;
import com.ivs.Student_Management_App.model.User;
import com.ivs.Student_Management_App.repository.StudentRepository;
import com.ivs.Student_Management_App.service.UserService;
@CrossOrigin(origins = {"*"})
@RestController
public class UserController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) {
		try {
			return userService.find(id).get();
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}
	@PostMapping(value ="/login")
	public User login(@RequestBody User user, HttpServletResponse response) {
		Cookie cookie = new Cookie("cookie", "cookieNE");
		response.addCookie(cookie);
		return userService.Login(user).get();
	}
	@PostMapping("/signup")
	public String signup(@RequestBody User user) {
		return userService.Signup(user);
	}
	
}

package com.ivs.Student_Management_App.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivs.Student_Management_App.model.Student;
import com.ivs.Student_Management_App.service.StudentService;

@CrossOrigin(origins = {"*"})
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping(value = "/student")
	public List<Student> getAllStudent(){
		return studentService.getAll();
	}
	@PostMapping(value = "/student")
	public String addStudent(@RequestBody Student student) {
		if(studentService.add(student)!=null) {
			return "Them hoc sinh thanh cong";
		}
		else
			return "Them hoc sinh that bai";
	}
	@GetMapping("/student/{name}")
	public Optional<Student> getStudentByName(@PathVariable String name) {
		return studentService.findByName(name);
	}
	@DeleteMapping("/student/{id}")
	public String deleteUserByID(@PathVariable Integer id) {
		return studentService.deleteByID(id);
	}
	@PostMapping(value = "/student/update")
	public Student updateTeam(@RequestBody Student student) {
		return studentService.updateTeam(student);
	}
}

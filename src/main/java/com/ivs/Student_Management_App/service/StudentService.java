package com.ivs.Student_Management_App.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivs.Student_Management_App.model.Student;
import com.ivs.Student_Management_App.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	public Student add(Student student) {
		return studentRepository.save(student);
	}
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	public Optional<Student> findByName(String name){
		try {
			return studentRepository.findByName(name);
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}
	public Student updateTeam(Student student) {
		try {
			Student temp = studentRepository.findByName(student.getName()).get();
			temp.setTeams(student.getTeams());
			studentRepository.save(temp);
			return temp;
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}
	public String deleteByID(Integer id) {
		if(studentRepository.findById(id).isEmpty()) {
			return "ID khong hop le";
		}
		else
			studentRepository.deleteById(id);
			System.out.println("delete success!!");
			return "Xoa Student thanh cong";
	}
}

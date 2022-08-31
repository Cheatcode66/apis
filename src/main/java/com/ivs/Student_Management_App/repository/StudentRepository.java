package com.ivs.Student_Management_App.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivs.Student_Management_App.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Optional<Student> findByName(String name);
}

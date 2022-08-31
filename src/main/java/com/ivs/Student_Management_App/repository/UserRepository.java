package com.ivs.Student_Management_App.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivs.Student_Management_App.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
	public Optional<User> findByUsername(String username);
	public Optional<User> findByUsernameAndPassword(String username, String password);
	
}

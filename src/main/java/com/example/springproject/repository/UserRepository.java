package com.example.springproject.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springproject.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public List<User> findByFirstName(String firstName);
	
	public List<User> findByFirstNameAndLastName(String firstName,String lastName);
	
	public List<User> findByFirstNameAndLastName(String firstName,String lastName,Pageable page);
	
}

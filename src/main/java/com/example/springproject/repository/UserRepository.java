package com.example.springproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springproject.model.User;

@Repository
public class UserRepository {
	
	private static List<User> users = new ArrayList<User>();
	
	public List<User> add(User user){
		users.add(user);
		return users;
	}

	public List<User> getAll() {
		return users;
	}

}

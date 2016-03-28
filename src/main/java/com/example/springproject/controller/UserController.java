package com.example.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproject.model.User;
import com.example.springproject.service.IndexService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> get(){
		return indexService.getUser();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public List<User> post(@RequestBody User user){
		user = indexService.appendZ(user);
		return indexService.addUser(user);
	}

}

package com.example.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springproject.model.User;
import com.example.springproject.repository.UserRepository;
import com.example.springproject.service.IndexService;

//@RestController
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> get(){
		//return userRepository.findAll(new Sort(Direction.ASC, "firstName","lastName"));
		return userRepository.findAll(new PageRequest(1, 1)).getContent();
	}
	
	@RequestMapping(value="/page/{page}",method=RequestMethod.GET)
	public Page<User> page(@PathVariable("page") int page){
		return userRepository.findAll(new PageRequest(page, 1,Direction.DESC,"firstName"));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public List<User> post(@RequestBody @Validated User user){
		user = indexService.appendZ(user);
		return indexService.addUser(user);
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public List<User> findByFirstnameAndLastName(@RequestBody User user){
		return userRepository
				.findByFirstNameAndLastName(
						user.getFirstName(),
						user.getLastName(),
						new PageRequest(1, 1,Direction.DESC,"firstName"));
	}

}

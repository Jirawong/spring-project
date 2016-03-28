package com.example.springproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproject.service.IndexService;

@RestController
public class IndexController {
	
	private static Map<String, String> MAPS = new HashMap<String, String>();
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public Map<String, String> get(){	
		return MAPS;
	}
	
	@RequestMapping(value = "/",method=RequestMethod.POST)
	public Map<String, String> post(@RequestBody Map<String, String> map){
		map = indexService.appendZ(map);
		MAPS.putAll(map);
		return MAPS;
	}
}

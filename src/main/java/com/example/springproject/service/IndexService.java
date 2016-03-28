package com.example.springproject.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class IndexService {

	public Map<String, String> appendZ(Map<String, String> map){
		
		
		String name = map.get("name");
		name = name+"Z";
		map.put("name", name);
		
		
		return map;
	}
	
}

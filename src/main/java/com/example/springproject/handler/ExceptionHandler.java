package com.example.springproject.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

	@ResponseBody
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> handler(MethodArgumentNotValidException ex){
		
		Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            Map<String, Object> mapError = new HashMap<String, Object>();
            mapError.put("field", error.getField());
            mapError.put("message", error.getDefaultMessage());
            list.add(mapError);
        }
        map.put("errors", list);
        return map;
		
		
	}
}

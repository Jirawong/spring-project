package com.example.springproject.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartWith, String> {
	
	private String value;

	public void initialize(StartWith constraintAnnotation) {
		this.value = constraintAnnotation.value();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.startsWith(this.value);
	}

}

package com.example.springproject.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=StartWithValidator.class)
public @interface StartWith {
	
	String message() default "String must start with";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	String value();
	
	String value2() default "something";
}

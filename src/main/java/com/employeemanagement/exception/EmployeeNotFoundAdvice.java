package com.employeemanagement.exception;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice

public class EmployeeNotFoundAdvice {
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String,String>exceptionHandler(EmployeeNotFoundException exception) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("Error Message", exception.getMessage());
		return errorMap;
	}

}

package com.employeemanagement.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException  {
	public EmployeeNotFoundException (Long empId) {
	super("could not found the employee with id : "+empId);

}
}

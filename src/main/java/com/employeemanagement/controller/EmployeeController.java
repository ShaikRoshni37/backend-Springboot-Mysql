package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employeemanagement.exception.EmployeeNotFoundException;
import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;

@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin(origins="*",allowedHeaders="*")
//@RequestMapping("/api/auth")
public class EmployeeController 
{
@Autowired

private EmployeeRepository employeeRepository;
@PostMapping("/employees")
Employee newEmployee(@RequestBody Employee newEmployee)
{
	return employeeRepository.save(newEmployee);
}
@GetMapping("/employees")
List<Employee> getAllEmployees() {
	return employeeRepository.findAll();
}
@GetMapping("/employee/{employeeId}")
Employee getEmployeeById(@PathVariable Long employeeId) {
//	System.out.println("New Employee:"+empId);
	return employeeRepository.findById(employeeId)
			.orElseThrow(()->new EmployeeNotFoundException(employeeId));
}
@PutMapping("/employee/{empId}")
Employee updateEmployee(@PathVariable Long empId,@RequestBody Employee newEmployee) {
//   System.out.println("New Employee :"+empId);
	return employeeRepository.findById(empId)
			.map(employee -> {
				employee.setFirstName(newEmployee.getFirstName());
				employee.setLastName(newEmployee.getLastName());
				employee.setEmailId(newEmployee.getEmailId());
				employee.setPassWord(newEmployee.getPassWord());
				return employeeRepository.save(employee);
				
			})
			.orElseThrow(()->new EmployeeNotFoundException(empId));
}
@DeleteMapping("/employee/{empId}")
String deleteEmployee(@PathVariable Long empId) {
	if(!employeeRepository.existsById(empId)) {
		throw new EmployeeNotFoundException(empId);
	}
	employeeRepository.deleteById(empId);
	return "Employee with id "+empId+" has been deleted successfully";	
}
//@Autowired
//private AuthenticationManager authenticationManager;
//@Autowired
//private EmployeeDetailServiceImpl employeeDetailService;
//@Autowired
//private JwtUtil jwtUtil;
//@PostMapping("/employees")
//public ResponseEntity<?> authenticateEmployee(@RequestBody AuthenticationRequest authenticationRequest)
//{
//	try {
//		authenticationManager.authenticate(new EmailIdPasswordAuthenticationToken(authenticationRequest.getEmailId(),authenticationRequest.getPassWord()))
//	}
//	catch (BadCredentialsException e)
//	{
//		throw new BadCredentialsException("Incorrect Email or PassWord");
//	}
//	 
//	final EmployeeDetails employeeDetails = employeeDetailsService.loadEmployeeByEmailId(authenticationRequest.getEmailId());
//	final String token =jwtUtil.genetareToken(employeeDetails);
//	return ResponseEntity.ok(new AuthenticationResponse(token));
//}
}


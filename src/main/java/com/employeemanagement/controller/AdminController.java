package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.model.Admin;
import com.employeemanagement.repository.AdminRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
	@Autowired

	private AdminRepository adminRepository;
	@GetMapping("/admin")
	List<Admin> getAllEmployees() {
		return adminRepository.findAll();
	}

	@PostMapping("/signup")
	Admin newAdmin(@RequestBody Admin newAdmin) {
		System.out.println("Haii");
		return adminRepository.save(newAdmin);
		
	}
//	@PostMapping("/login")
//	public ResponseEntity<String> login(@RequestBody Admin admin, HttpSession session) {
//		Admin existingAdmin = adminRepository.findByAdminName(admin.getAdminName());
//		if (existingAdmin != null && existingAdmin.getPassWord().equals(admin.getPassWord())) {
//			session.setAttribute("admin", existingAdmin);
//			return ResponseEntity.ok().build();
//		} else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//		}
//	}
}

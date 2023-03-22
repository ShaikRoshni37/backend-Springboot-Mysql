package com.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByAdminName(String adminName);

}

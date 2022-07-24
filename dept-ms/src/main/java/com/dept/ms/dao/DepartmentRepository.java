package com.dept.ms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dept.ms.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	
}

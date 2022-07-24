package com.dept.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dept.ms.dao.EmployeeRepository;
import com.dept.ms.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/getAll/{deptno}")
	public List<Employee> getEmployeesonDeptId(@PathVariable int deptno)
	{
		return repository.findByDeptno(deptno);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee employeeData = repository.findById(employee.getId()).get();
		employeeData.setDeptno(employee.getDeptno());
		employeeData.setJob(employee.getJob());
		employeeData.setName(employee.getName());
		employeeData.setSal(employee.getSal());
		return repository.save(employeeData);
	}

}

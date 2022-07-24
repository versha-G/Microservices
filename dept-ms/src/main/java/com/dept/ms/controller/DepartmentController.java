package com.dept.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dept.ms.dao.DepartmentRepository;
import com.dept.ms.entity.Department;
import com.dept.ms.model.Employee;
import com.dept.ms.model.MyResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository repository;
	
	@Autowired
	RestTemplate template;
	
	@GetMapping("/getAll")
	public List<Department> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/get/{deptid}")
	@HystrixCommand(fallbackMethod = "getDepartment")
	public ResponseEntity<MyResponse> getDepartmentsById(@PathVariable int deptid){
		
		Department department = repository.findById(deptid).get();
		
		List<Employee> list = template.getForObject("http://EMP-MODULE/emp/getAll/"+deptid, List.class);
		
		MyResponse response = new MyResponse();
		response.setDepartment(department);
		response.setEmployeeList(list);
		
		return new ResponseEntity<MyResponse>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<MyResponse> getDepartment(@PathVariable int deptid){
		
		Department department = repository.findById(deptid).get();

		MyResponse response = new MyResponse();
		response.setDepartment(department);
		
		
		return new ResponseEntity<MyResponse>(response,HttpStatus.OK);
	}
	
	
	


}

package com.dept.ms.model;

import java.util.List;

import com.dept.ms.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyResponse {
	
	private Department department;
	private List<Employee> employeeList;

}

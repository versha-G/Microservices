package com.dept.ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

	private int id;
	private String name;
	private String job;
	private double sal;
	private int deptno;
}
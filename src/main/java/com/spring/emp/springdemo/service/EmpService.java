package com.spring.emp.springdemo.service;

import com.spring.emp.springdemo.bean.Employee;

public interface EmpService {
	
	public int saveEmp(Employee employee);
	public Employee findEmployee(long id);

}

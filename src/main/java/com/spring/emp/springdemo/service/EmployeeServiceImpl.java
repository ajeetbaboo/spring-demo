package com.spring.emp.springdemo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emp.springdemo.bean.Employee;


@Service
@Transactional
public class EmployeeServiceImpl implements EmpService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public int saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		int count=0;
		Employee emploee=employeeRepository.save(employee);
		if(employee!=null) {
			count=1;
			System.out.println("Saved..."+employee.getId());
		}
		
		
		return count;
	}

	@Override
	public Employee findEmployee(long id) {
		// TODO Auto-generated method stub
		Employee emp=null;
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			emp=employee.get();
		}
		return emp;
	}


	
}

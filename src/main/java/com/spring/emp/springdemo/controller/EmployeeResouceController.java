package com.spring.emp.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.emp.springdemo.bean.Address;
import com.spring.emp.springdemo.bean.Department;
import com.spring.emp.springdemo.bean.Employee;
import com.spring.emp.springdemo.bean.EmployeeDetails;
import com.spring.emp.springdemo.service.EmpService;

@RestController
public class EmployeeResouceController {

	
	@Autowired
	EmpService empService;
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody EmployeeDetails employee) {
		String saveStatus="";
		try {
			if(employee!=null) {
				Employee emp=new Employee();
				Department dept=new Department();
				Address address=new Address();
				
				emp.setFname(employee.getFname());
				emp.setLname(employee.getLname());
				
				dept.setDept(employee.getDept());
				dept.setDesignation(employee.getDesignation());
				
				address.setAddress(employee.getAddress());
				address.setSalary(employee.getSalary());
			
				emp.setDept(dept);
				emp.setAddress(address);
				
				address.setEmp(emp);
				dept.setEmp(emp);
				
				long status=empService.saveEmp(emp);
				if(status==1) {
					saveStatus="Data Saved Successfully.";
				}
				
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			saveStatus="Data Not Saved.";
		}
		return saveStatus;
		
	}
	
	@GetMapping("/emp/{empId}")
	public Employee getEmpDetails(@PathVariable long empId){
			
			Employee employeeDetails=empService.findEmployee(empId);
			System.out.println("Address: "+employeeDetails.getAddress().getAddress());
			return employeeDetails;
					//new ResponseEntity(employeeDetails, HttpStatus.OK);
		}
	
	
	
}

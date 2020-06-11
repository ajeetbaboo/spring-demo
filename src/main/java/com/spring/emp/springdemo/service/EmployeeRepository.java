package com.spring.emp.springdemo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.emp.springdemo.bean.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,	Long> {

}

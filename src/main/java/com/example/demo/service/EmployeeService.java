package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee employee);
	public void deleteEmployee(int id);
	public Employee getEmployeeById(int id);
		
	}



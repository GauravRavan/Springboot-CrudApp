package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService {
@Autowired
  EmployeeRepository employeeRepository;

@Override
public List<Employee> getAllEmployees() {
	
	return employeeRepository.findAll();
}

@Override
public void saveEmployee(Employee employee) {
	employeeRepository.save(employee);	
}

@Override
public void deleteEmployee(int id) {
	employeeRepository.deleteById(id);
	
}

@Override
public Employee getEmployeeById(int id) {
	
	Optional<Employee> optional=employeeRepository.findById(id);
	Employee employee=null;
		if(optional.isPresent()) 
	{
		employee=optional.get();
	}

	return employee;
}






}

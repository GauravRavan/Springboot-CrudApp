package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeCtrl {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "HomePage";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		Employee emp=new Employee();
		model.addAttribute("employee",emp);
		return "NewEmployeePage";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.saveEmployee(employee);
		
		return "redirect:/";
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable(value="id")int id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/";
	
	}
	
	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable(value="id")int id,Model model)
	{
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute(employee);
		return "updateEmployeeForm";
	
	}
}


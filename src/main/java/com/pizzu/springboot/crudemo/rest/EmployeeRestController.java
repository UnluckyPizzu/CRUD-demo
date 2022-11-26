package com.pizzu.springboot.crudemo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzu.springboot.crudemo.entity.Employee;
import com.pizzu.springboot.crudemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{theId}")
	public Employee findById(@PathVariable int theId) {
		Employee thEmployee = employeeService.findById(theId);
		
		if(thEmployee == null) {
			throw new RuntimeException("Employee not found!");
		}
		
		return thEmployee;
	}
	
	@PostMapping("/employees")
	public Employee saveOrUpdateEmployee(@RequestBody Employee employee) {
		employee.setId(0);		
		employeeService.save(employee);		
		
		return employee;
	}
	
	@DeleteMapping("/employees/{theId}")
	public String deleteEmployee(@PathVariable int theId) {
		if(employeeService.findById(theId) == null)
			throw new RuntimeException("Employee not found!");
		else {
			employeeService.deleteById(theId);
		}
		
		return "Deleted employee id " + theId;
		
	}
	
	
	
	
}

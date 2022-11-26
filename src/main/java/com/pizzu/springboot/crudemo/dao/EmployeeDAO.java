package com.pizzu.springboot.crudemo.dao;

import java.util.List;

import com.pizzu.springboot.crudemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}

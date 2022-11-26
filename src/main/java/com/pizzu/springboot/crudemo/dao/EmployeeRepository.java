package com.pizzu.springboot.crudemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizzu.springboot.crudemo.entity.Employee;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//Does everything alone, delete @transactional from service
	//With spring-boot-starter-data-rest you can delete Service & Rest, it works
}

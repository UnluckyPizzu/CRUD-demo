package com.pizzu.springboot.crudemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzu.springboot.crudemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		org.hibernate.Session currentSession = entityManager.unwrap(org.hibernate.Session.class);
		
		org.hibernate.query.Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		org.hibernate.Session currentSession = entityManager.unwrap(org.hibernate.Session.class);
		Employee theEmployee = currentSession.get(Employee.class, theId);
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {
		org.hibernate.Session currentSession = entityManager.unwrap(org.hibernate.Session.class);
		currentSession.saveOrUpdate(theEmployee);
	}


	@Override
	public void deleteById(int theId) {
		org.hibernate.Session currentSession = entityManager.unwrap(org.hibernate.Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
	}

}

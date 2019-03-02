package com.example.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.example.jpa.model.Employee;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> getAllEmployee() {
		StoredProcedureQuery result = em.createNamedStoredProcedureQuery("getAllEmployees"); 
		return result.getResultList();
	}

	@Override
	public List<Employee> getEmpById(int id) {
		StoredProcedureQuery result = em.createNamedStoredProcedureQuery("getEmpById").setParameter("eid", id);
		
		return result.getResultList();
	}

	@Override
	public List<Employee> getEmpByIdAndSalary(int id) {
		StoredProcedureQuery query =em.createNamedStoredProcedureQuery("getAll").setParameter("id", id).setParameter("salary", 10000);
		return query.getResultList();
	}

}

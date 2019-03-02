package com.example.jpa.service;

import java.util.List;

import com.example.jpa.model.Employee;

public interface EmployeeCustomRepository {
	List<Employee> getAllEmployee();
	List<Employee> getEmpById(int id);
	List<Employee> getEmpByIdAndSalary(int id);

}

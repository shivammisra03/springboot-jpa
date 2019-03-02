package com.example.jpa.service;

import org.springframework.data.repository.CrudRepository;

import com.example.jpa.model.Employee;

public interface DefaultRepository extends CrudRepository<Employee, Integer>,EmployeeCustomRepository {

}

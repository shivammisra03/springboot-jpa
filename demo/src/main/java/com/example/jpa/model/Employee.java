package com.example.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="getAllEmployees",procedureName="get_all_employees"),
	@NamedStoredProcedureQuery(name="getEmpById",procedureName="get_emp_by_id",
	parameters= {
		@StoredProcedureParameter(mode=ParameterMode.IN, name="eid", type=Integer.class)
	}),
	@NamedStoredProcedureQuery(name="getAll",procedureName="get_emp_using_id_salary",
	parameters= {
		@StoredProcedureParameter(mode=ParameterMode.IN,name="id",type=Integer.class),
		@StoredProcedureParameter(mode=ParameterMode.IN,name="salary",type=Integer.class)
	})
})

public class Employee {
	@Id
	private int id;
	private String name;
	private int salary;
	
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}

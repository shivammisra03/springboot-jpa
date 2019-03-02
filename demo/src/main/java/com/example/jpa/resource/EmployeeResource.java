package com.example.jpa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.model.Employee;
import com.example.jpa.model.resp.EmpError;
import com.example.jpa.service.DefaultRepository;

@RestController
@RequestMapping(path="/employees")
public class EmployeeResource {
	
	@Autowired
	private DefaultRepository drepo;
	
	
	@RequestMapping(method=RequestMethod.GET,path="/getEmployees")
	public List<Employee> getAllEmployees(){
		return drepo.getAllEmployee();
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/getEmployeesById")
	public List<Employee> getEmployeesById(@RequestParam int id){
		return drepo.getEmpById(id);
	}
	@RequestMapping(method=RequestMethod.GET,path="/getEmpUsingIdAndSal")
	public ResponseEntity getEmployeesByIdAndSal(@RequestParam int id){
		
		List<Employee> employee= drepo.getEmpByIdAndSalary(id);
		if(employee.size()==0)
		{
			EmpError empError = new EmpError();
			empError.setErrorMsg("No Employees found for the given id and salary combination");
			return ResponseEntity.badRequest().body(empError);
		}
			
		else
			return ResponseEntity.ok(employee);
	}

}

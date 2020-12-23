package com.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class employeeResource {

	@RequestMapping("employees")
	public List<Employee> getEmployees()
	{
		List<Employee> employee=new ArrayList<Employee>();
		
		Employee e=new Employee();
		e.setId(101);
		e.setName("Renuka");
		e.setMarks(100);
		
		Employee e1=new Employee();
		e1.setId(102);
		e1.setName("Saravanan");
		e1.setMarks(200);
		
		employee.add(e);
		employee.add(e1);
		
		return employee;	
	}
}

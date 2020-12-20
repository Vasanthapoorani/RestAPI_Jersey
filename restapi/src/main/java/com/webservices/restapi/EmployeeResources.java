package com.webservices.restapi;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResources {
	
	EmployeeRepository repo=new EmployeeRepository();

	@GET //Retrieving the resource
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //Denotes the return type of the obj
	public List<Employee> getEmployees() //Returns Employee List object
	{
		System.out.println("getEmployee Method called..");
		return repo.getEmployees();	
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //From Server to Client
	@Path("employee/{id}") //{}-Place holder of the value id
	public Employee getEmployee(@PathParam("id") int id) //"id" will be assigned to id by PathParam
	{
		return repo.getEmployee(id);	
	}
	
	@POST //Creating a resource
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //From Client to Server
	@Path("employee")
	public Employee createEmployee(Employee e1)
	{
		System.out.println(e1);
		repo.create(e1);
		return e1;
	}
	
	@PUT //Creating a resource
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //From Client to Server
	@Path("employee")
	public Employee updateEmployee(Employee e1)
	{
		System.out.println(e1);
		if(repo.getEmployee(e1.getId()).getId()==0)
		{
			repo.create(e1);
		}
		else
		{
		repo.update(e1);
		}
		return e1;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //From Server to Client
	@Path("employee/{id}") //{}-Place holder of the value id
	public Employee deleteEmployee(@PathParam("id") int id) //"id" will be assigned to id by PathParam
	{
		
		Employee e= repo.getEmployee(id);	
		
		if(e.getId()!=0)
		{
			repo.delete(id);
		}
		
		return e;
	}
}

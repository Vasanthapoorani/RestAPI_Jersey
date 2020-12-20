package com.webservices.restapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

	
	Connection con=null;
	public EmployeeRepository()//Constructor
	{
		String url="jdbc:mysql://localhost:3306/restdb?autoReconnect=true&useSSL=false";
		String username="root";
		String password="Saravanan@23";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			
			System.out.println(e);
			
		}
	}
	
	
	public List<Employee> getEmployees() //Returns Employee List object
	{	
		List<Employee> employee=new ArrayList<Employee>();
		String sql="select * from employee";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next())
			{
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setMarks(rs.getInt(3));
				
				employee.add(e);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		
			}
		return employee;
	}
	
	public Employee getEmployee(int id)
	{
		String sql="select * from employee where id="+id;
		Employee e=new Employee();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next())
			{		
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setMarks(rs.getInt(3));			
			}
		}
		catch(Exception s)
		{
			System.out.println(s);
		
			}
		
		return e;
	}

	public void create(Employee e1) {
		
		String sql="insert into employee values (?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,e1.getId());
			st.setString(2,e1.getName());
			st.setInt(3,e1.getMarks());
			st.executeUpdate();
			System.out.println("Into the create method....");
			}
		catch(Exception e)
		{
			System.out.println(e);
		
			}
	}
	
public void update(Employee e1) {
		
		String sql="update employee set name=?, marks=? where id=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,e1.getName());
			st.setInt(2,e1.getMarks());
			st.setInt(3,e1.getId());
			
			st.executeUpdate();
			System.out.println("Into the update method....");
			}
		catch(Exception e)
		{
			System.out.println(e);
		
			}	
	}


public void delete(int id) {
	
	String sql="delete from employee where id=?";
	try
	{
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1,id);
		st.executeUpdate();
		
		System.out.println("Into the update method....");
		}
	catch(Exception e)
	{
		System.out.println(e);
	
		}
	
	
}
	
	
}

/*List<Employee> employees;

public EmployeeRepository()//Constructor
{
employees=new ArrayList<Employee>();

Employee e1=new Employee();
e1.setId(101);
e1.setName("Pooja");
e1.setMarks(99);

Employee e2=new Employee();
e2.setId(102);
e2.setName("Poorani");
e2.setMarks(100);

employees.add(e1);
employees.add(e2);

}


public Employee getEmployee(int id)
{
	
	for(Employee e: employees)
	{
		if(e.getId()==id)
			return e;
	}
	
	return null;
}

*public void create(Employee e1) {
		// TODO Auto-generated method stub
		
		employees.add(e1);
		
	}*/

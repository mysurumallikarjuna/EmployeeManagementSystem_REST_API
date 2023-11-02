package com.Frist.main.Service;

import java.util.List;

import com.Frist.main.Module.Employee;

public interface EmployeeService {
	
	
	//here we can declare methods for implementation
	//syntax  class name       method name(class name        object);
	            Employee       saveEmployee(Employee         employee);
	            
	  //get all employees          
	 List <Employee> getAllEmployees(); 
	 //get employee by id
	 Employee getEmployeeById(int id);
	 
	 
	 //UPDATE employee
	 Employee updateEmployee(Employee employee , int id);
	 
	 //delete method
	 void  deleteEmployee(int id );
	 

}

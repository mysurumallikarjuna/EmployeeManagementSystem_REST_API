package com.Frist.main.ServiceImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Frist.main.Exception.ResourceNotFoundException;
import com.Frist.main.Module.Employee;
import com.Frist.main.Repository.EmployeeRepository;
import com.Frist.main.Service.EmployeeService;

@Service
//we dont need @transaction for methods 
public class EmployeeServiceimpl implements EmployeeService {

		//import REPOSITORY , if spring bean only one constructor we dont need to use@Autowire 
	private EmployeeRepository   employeeRepository ;
	//generate constructor for REPOSITORY
	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	//override methods from SERVICE	
	     // for create employee
		public Employee saveEmployee(Employee employee) {
			   //that can stores in repository
				return employeeRepository.save(employee);
		}
		// for get all employees
		public List<Employee> getAllEmployees() { 
			 //that can stores in repository
			
			return employeeRepository.findAll();
		}
		//for get element by id 
		public Employee getEmployeeById(int id) {
			
		/*	//here we use Optional<Employee> because we get data from there
			Optional<Employee> employee =  employeeRepository.findById(id);
			
			if(employee.isPresent()) 
			{
				//get is inbuilt method in optional class
				return employee.get();
			}else
			{
				throw new ResourceNotFoundException("Employee","id",id);
			} */
			//by using lamda logic we  can write in single line
			return employeeRepository.findById(id).orElseThrow
					//this is lamda expression
					(()->new  ResourceNotFoundException("Employee","id",id));
			
		}
		
		
		//for update id
		
		public Employee updateEmployee(Employee employee, int id) {
			
			//here we need to check whether employee with given id is exist in DB or not
			Employee  existingEmployee = employeeRepository.findById(id).orElseThrow
			                                        //(resource,field name,field value)
					(()->new  ResourceNotFoundException("Employee","id",id));
			//if id is correct you can enter into updation
			existingEmployee.setFirstname(employee.getFirstname());
			existingEmployee.setLastname(employee.getLastname());
			existingEmployee.setEmail(employee.getEmail());
			//now save that employee
			employeeRepository.save(existingEmployee);
			
					return existingEmployee;
		}
		//delete employee
		public void deleteEmployee(int id) {
			// TODO Auto-generated method stub
			employeeRepository.findById(id).orElseThrow
                    //(resource,field name,field value)
					(()->new  ResourceNotFoundException("Employee","id",id));
			
			employeeRepository.deleteById(id);
			
		}
		
		
		

	

}

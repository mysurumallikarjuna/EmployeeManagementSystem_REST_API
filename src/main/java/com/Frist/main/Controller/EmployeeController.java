package com.Frist.main.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Frist.main.Module.Employee;
import com.Frist.main.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	//import SERVICE
	private EmployeeService employeeService;
	//create constructor for this SERVICE

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//build REST API for CREATE employee
	//here use response entity because it handles all details for that class
	//@postmapping handle post http Request
	@PostMapping
	//@requset body allows us to HTTP REQUEST convert into JAVA OBJECT
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	 return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	
	//BUILD get all employee REST API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return  employeeService.getAllEmployees();
		
	}
	
	//BUILD get  employee by id REST API
	//@GetMapping(path="id")
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id){
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
		
	}
	//update REST API
	@PutMapping ("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id
			                                         , @RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
	}
	
	//delete REST api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		//delete employee from DB
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("employee deleted successfully",HttpStatus.OK);
	}
	
}
	
	
	


package com.Frist.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Frist.main.Module.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

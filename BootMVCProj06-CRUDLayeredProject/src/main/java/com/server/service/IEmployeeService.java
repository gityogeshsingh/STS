package com.server.service;

import java.util.Iterator;

import com.server.model.Employee;

public interface IEmployeeService {
	Iterable<Employee> getAllEmployee();

	String registerEmployee(Employee emp);

	Employee findEmployeeById(int eno);

	String updateEmployee(Employee emp);

	String deleteEmployeeById(int eid);
}

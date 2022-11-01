package com.server.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.model.Employee;
import com.server.repository.IEmployeeRepository;



@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IEmployeeRepository repo;
	@Override
	public Iterable<Employee> getAllEmployee() {
		return repo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		
		return "Employee  registered with Eid::"+repo.save(emp).getEid();
	}

	@Override
	public Employee findEmployeeById(int eno) {
		return repo.findById(eno).orElseThrow(()->new IllegalArgumentException());
		
	}

	@Override
	public String updateEmployee(Employee emp) {
		Employee e=repo.save(emp);
		return "employee updated Eid::"+e.getEid();
	}

	@Override
	public String deleteEmployeeById(int eid) {
		repo.deleteById(eid);
		return "Employee Deleted Eid::"+eid;
	}

}

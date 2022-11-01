package com.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.server.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}

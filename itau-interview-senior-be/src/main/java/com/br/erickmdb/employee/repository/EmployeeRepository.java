package com.br.erickmdb.employee.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.br.erickmdb.employee.model.Employee;

@EnableScan
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}

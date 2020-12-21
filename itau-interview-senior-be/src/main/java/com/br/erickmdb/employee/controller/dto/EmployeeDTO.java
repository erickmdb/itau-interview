package com.br.erickmdb.employee.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.erickmdb.employee.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	private String id;

	private String firstName;

	private String lastName;

	private String email;

	public Employee employeeDTOToEmployee() {
		return Employee.builder().id(this.id).firstName(this.firstName).lastName(this.lastName).email(this.email)
				.build();
	}

	static public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
		return EmployeeDTO.builder().id(employee.getId()).firstName(employee.getFirstName())
				.lastName(employee.getLastName()).email(employee.getEmail()).build();
	}

	public static List<EmployeeDTO> convert(List<Employee> employees) {
		return employees.stream().map(EmployeeDTO::employeeToEmployeeDTO).collect(Collectors.toList());
	}
}

package com.br.erickmdb.employee.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.erickmdb.employee.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeForm {

	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	public Employee convert() {
		return Employee.builder().firstName(this.firstName).lastName(this.lastName).email(this.email).build();
	}

	public Employee atualizar(Employee employee) {

		employee.setFirstName(this.firstName);
		employee.setLastName(this.lastName);
		employee.setEmail(this.email);

		return employee;
	}
}

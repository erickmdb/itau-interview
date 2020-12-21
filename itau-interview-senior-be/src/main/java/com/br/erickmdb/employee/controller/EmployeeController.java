package com.br.erickmdb.employee.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.erickmdb.employee.controller.dto.EmployeeDTO;
import com.br.erickmdb.employee.controller.form.EmployeeForm;
import com.br.erickmdb.employee.model.Employee;
import com.br.erickmdb.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@CrossOrigin
	@GetMapping
	public List<EmployeeDTO> lista() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return EmployeeDTO.convert(employees);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<EmployeeDTO> cadastrar(@RequestBody @Valid EmployeeForm form,
			UriComponentsBuilder uriBuilder) {
		Employee employee = form.convert();
		employeeRepository.save(employee);

		URI uri = uriBuilder.path("/employees/{id}").buildAndExpand(employee.getId()).toUri();
		return ResponseEntity.created(uri).body(EmployeeDTO.employeeToEmployeeDTO(employee));
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> detalhar(@PathVariable String id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return ResponseEntity.ok(EmployeeDTO.employeeToEmployeeDTO(employee.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> atualizar(@PathVariable String id, @RequestBody @Valid EmployeeForm form) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {

			Employee employee = form.atualizar(optional.get());
			employeeRepository.save(employee);
			return ResponseEntity.ok(EmployeeDTO.employeeToEmployeeDTO(employee));
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			employeeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}

package com.example.farnoune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.farnoune.entities.Employee;
import com.example.farnoune.service.EmployeeService;



@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> findAllEmployee() {
		return service.findAll();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		return service.create(employee);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Employee employee = service.findById(id);
		if (employee == null) {
			return new ResponseEntity<Object>("Employee avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(employee);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Employee newEmployee) {
		Employee oldEmployee = service.findById(id);
		if (oldEmployee == null) {
			return new ResponseEntity<Object>("Employee avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newEmployee.setId(id);
			return ResponseEntity.ok(service.update(newEmployee));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		Employee employee = service.findById(id);
		if (employee == null) {
			return new ResponseEntity<Object>("Employee avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(employee);
			return ResponseEntity.ok("filière supprimée");
		}
	}

}

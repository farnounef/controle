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


import com.example.farnoune.entities.Service;

import com.example.farnoune.service.ServiceService;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
	@Autowired
	private ServiceService ser;

	@GetMapping
	public List<Service> findAllService() {
		return ser.findAll();
	}

	@PostMapping
	public Service createService(@RequestBody Service service) {
		service.setId(0);
		return ser.create(service);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Service service = ser.findById(id);
		if (service == null) {
			return new ResponseEntity<Object>("Etage avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(service);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable int id, @RequestBody Service newService) {
		Service oldService = ser.findById(id);
		if (oldService == null) {
			return new ResponseEntity<Object>("Etage avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newService.setId(id);
			return ResponseEntity.ok(ser.update(newService));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteService(@PathVariable int id) {
		Service etage = ser.findById(id);
		if (etage == null) {
			return new ResponseEntity<Object>("Etage avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ser.delete(etage);
			return ResponseEntity.ok("filière supprimée");
		}
	}

}

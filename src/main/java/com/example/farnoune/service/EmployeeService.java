package com.example.farnoune.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.farnoune.dao.IDao;
import com.example.farnoune.entities.Employee;

import com.example.farnoune.repositories.EmployeeRepository;

@Service
public class EmployeeService  implements IDao<Employee> {
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee create(Employee o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Employee o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Employee update(Employee o) {
		return repository.save(o);
	}

	@Override
	public Employee findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}


}

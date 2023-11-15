package com.example.farnoune.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.farnoune.dao.IDao;
import com.example.farnoune.repositories.ServiceRepository;



@Service
public class ServiceService implements IDao<com.example.farnoune.entities.Service> {
	@Autowired
	private ServiceRepository repository;

	@Override
	public com.example.farnoune.entities.Service create(com.example.farnoune.entities.Service o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(com.example.farnoune.entities.Service o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public com.example.farnoune.entities.Service update(com.example.farnoune.entities.Service o) {
		return repository.save(o);
	}

	@Override
	public com.example.farnoune.entities.Service findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<com.example.farnoune.entities.Service> findAll() {
		return repository.findAll();
	}


}

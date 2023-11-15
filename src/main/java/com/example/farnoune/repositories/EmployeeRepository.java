package com.example.farnoune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farnoune.entities.Employee;


@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	

}

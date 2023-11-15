package com.example.farnoune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farnoune.entities.Service;



@Repository

public interface ServiceRepository extends JpaRepository<Service,Integer>  {

}

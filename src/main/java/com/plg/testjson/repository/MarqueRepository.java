package com.plg.testjson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plg.testjson.models.Marque;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, UUID>{
  
  
}

package com.plg.testjson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plg.testjson.models.EnergieVehicule;

@Repository
public interface EnergieVehiculeRepository extends JpaRepository<EnergieVehicule, UUID> {

}

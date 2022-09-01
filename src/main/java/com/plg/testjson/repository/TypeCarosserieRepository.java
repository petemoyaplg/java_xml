package com.plg.testjson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plg.testjson.models.TypeCarosserie;

@Repository
public interface TypeCarosserieRepository extends JpaRepository<TypeCarosserie, UUID> {

}

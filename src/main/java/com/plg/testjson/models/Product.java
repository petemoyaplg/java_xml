package com.plg.testjson.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity(name = "product")
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;


  private String code;
  @Column(name = "nom_codification")
  private String nomCodification;
  private boolean actif;
  @Column(name = "date_modification")
  private LocalDateTime dateModification;
  private String libelle;
}

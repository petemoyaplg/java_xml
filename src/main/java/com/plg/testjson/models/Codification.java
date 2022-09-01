package com.plg.testjson.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "codification")
public class Codification {

  @Id
  private String code;
  @Column(name = "nom_codification")
  private String nomCodification;
  private boolean actif;
  @Column(name = "date_modification")
  private LocalDateTime dateModification;
  private String libelle;
}

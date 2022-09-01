package com.plg.testjson.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "type_carosserie")
@Setter
@Getter
@NoArgsConstructor
public class TypeCarosserie {

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

  public TypeCarosserie(Codification codification) {
    this.setCode(codification.getCode());
    this.setActif(codification.isActif());
    this.setDateModification(codification.getDateModification());
    this.setLibelle(codification.getLibelle());
    this.setNomCodification(codification.getNomCodification());
  }
}

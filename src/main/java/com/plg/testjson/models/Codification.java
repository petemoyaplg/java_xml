package com.plg.testjson.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Codification {

  private String code;
  private String nomCodification;
  private boolean actif;
  private LocalDateTime dateModification;
  private String libelle;
}

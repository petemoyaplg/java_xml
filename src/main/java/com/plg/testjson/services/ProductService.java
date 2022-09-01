package com.plg.testjson.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plg.testjson.models.EnergieVehicule;
import com.plg.testjson.models.Marque;
import com.plg.testjson.models.Modele;
import com.plg.testjson.models.TypeCarosserie;
import com.plg.testjson.models.UsageVehicule;
import com.plg.testjson.repository.EnergieVehiculeRepository;
import com.plg.testjson.repository.MarqueRepository;
import com.plg.testjson.repository.ModeleRepository;
import com.plg.testjson.repository.TypeCarosserieRepository;
import com.plg.testjson.repository.UsageVehiculeRepository;

@Service
public class ProductService {
  @Autowired
  private MarqueRepository marqueRepository;
  @Autowired
  private ModeleRepository modeleRepository;
  @Autowired
  private EnergieVehiculeRepository energieVehiculeRepository;
  @Autowired
  private TypeCarosserieRepository typeCarosserieRepository;
  @Autowired
  private UsageVehiculeRepository usageVehiculeRepository;

  List<Marque> marques = new ArrayList<>();
  List<Modele> modeles = new ArrayList<>();
  List<TypeCarosserie> typeCarosseries = new ArrayList<>();
  List<UsageVehicule> uVehicules = new ArrayList<>();
  List<EnergieVehicule> eVehicules = new ArrayList<>();

  @Transactional
  public int saveAll(Map<String, List<?>> productMap) {
    int nbSave = 0;
    for (Map.Entry<String, List<?>> entry : productMap.entrySet()) {
      String key = entry.getKey();
      switch (key) {
        case "type_carosserie":
          nbSave += this.saveTypeCarosserie((List<TypeCarosserie>) entry.getValue());
          break;
        case "usage_vehicule":
          nbSave += this.saveUsageVehicule((List<UsageVehicule>) entry.getValue());
          break;
        case "voiture_marque":
          nbSave += this.saveMarques((List<Marque>) entry.getValue());
          break;
        case "voiture_modele":
          nbSave += this.saveModeles((List<Modele>) entry.getValue());
          break;
        case "energie_vehicule":
          nbSave += this.saveEnergieVehicule((List<EnergieVehicule>) entry.getValue());
          break;
        default:
          break;
      }
    }
    return nbSave;
  }

  @Transactional
  private int saveModeles(List<Modele> modeles) {
    int nbSave = 0;
    for (Modele modele : modeles) {
      this.modeleRepository.save(modele);
      nbSave++;
    }
    return nbSave;
  }

  @Transactional
  private int saveMarques(List<Marque> marques) {
    int nbSave = 0;
    for (Marque marque : marques) {
      this.marqueRepository.save(marque);
      nbSave++;
    }
    return nbSave;
  }

  @Transactional
  private int saveEnergieVehicule(List<EnergieVehicule> energieVehicules) {
    int nbSave = 0;
    for (EnergieVehicule energieVehicule : energieVehicules) {
      this.energieVehiculeRepository.save(energieVehicule);
      nbSave++;
    }
    return nbSave;
  }

  @Transactional
  private int saveTypeCarosserie(List<TypeCarosserie> typeCarosseries) {
    int nbSave = 0;
    for (TypeCarosserie typeCarosserie : typeCarosseries) {
      this.typeCarosserieRepository.save(typeCarosserie);
      nbSave++;
    }
    return nbSave;
  }

  @Transactional
  private int saveUsageVehicule(List<UsageVehicule> usageVehicules) {
    int nbSave = 0;
    for (UsageVehicule usageVehicule : usageVehicules) {
      this.usageVehiculeRepository.save(usageVehicule);
      nbSave++;
    }
    return nbSave;
  }
}

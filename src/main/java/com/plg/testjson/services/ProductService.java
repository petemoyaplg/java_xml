package com.plg.testjson.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plg.testjson.models.Codification;
import com.plg.testjson.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Transactional
  public int saveAll(Map<String, Codification> productMap) {
    int nbSave = 0;
    for (Map.Entry<String, Codification> entry : productMap.entrySet()) {
      Codification product = entry.getValue();
      // this.productRepository.save(product);
      System.out.println(product);
      nbSave++;
    }
    System.out.println("size = " + productMap.size());
    return nbSave;
  }
}

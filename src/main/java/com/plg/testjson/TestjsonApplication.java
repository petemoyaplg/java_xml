package com.plg.testjson;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.plg.testjson.models.Codification;
import com.plg.testjson.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TestjsonApplication implements CommandLineRunner {

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(TestjsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String student = "students.xml";
		String product = "convertjson.xml";
		String codification = "codifications.xml";
		File xmlFile = new File(codification);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);
		Map<String, Codification> productMap = getAllProductInXmlFile2(doc);
		int nbSave = this.productService.saveAll(productMap);
		// System.out.println("Nombre d'enregistrement : " + nbSave);
		log.info("Serveur run");
	}

	private static Map<String, Codification> getAllProductInXmlFile(Document doc) {
		Map<String, Codification> products = new HashMap<>();
		NodeList row = doc.getElementsByTagName("row");
		for (int i = 0, c = row.getLength(); i < c; i++) {
			Node productNode = row.item(i);
			if (productNode.getNodeType() == Node.ELEMENT_NODE) {

				Element productElement = (Element) productNode;
				String nomCodification = productElement.getElementsByTagName("nomCodification").item(0).getTextContent();
				String actif = productElement.getElementsByTagName("actif").item(0).getTextContent();
				String dateModification = productElement.getElementsByTagName("dateModification").item(0).getTextContent();
				String code = productElement.getElementsByTagName("code").item(0).getTextContent();
				String libelle = productElement.getElementsByTagName("libelle").item(0).getTextContent();

				Codification product = new Codification();
				product.setNomCodification(nomCodification);
				product.setActif(Boolean.parseBoolean(actif));
				product.setDateModification(LocalDateTime.parse(dateModification));
				product.setLibelle(libelle);
				product.setCode(code);
				products.put(code, product);

				NodeList codifications = productElement.getElementsByTagName("codifications");
				for (int j = 0, c1 = codifications.getLength(); j < c1; j++) {
					Node productNode2 = codifications.item(j);
					if (productNode2.getNodeType() == Node.ELEMENT_NODE) {
						Element productElement2 = (Element) productNode2;
						String nomCodification2 = productElement2.getElementsByTagName("nomCodification").item(0).getTextContent();
						String actif2 = productElement2.getElementsByTagName("actif").item(0).getTextContent();
						String dateModification2 = productElement2.getElementsByTagName("dateModification").item(0)
								.getTextContent();
						String code2 = productElement2.getElementsByTagName("code").item(0).getTextContent();
						String libelle2 = productElement2.getElementsByTagName("libelle").item(0).getTextContent();

						Codification product2 = new Codification();
						product2.setNomCodification(nomCodification2);
						product2.setActif(Boolean.parseBoolean(actif2));
						product2.setDateModification(LocalDateTime.parse(dateModification2));
						product2.setLibelle(libelle2);
						product2.setCode(code2);
						products.put(code2, product2);

						NodeList codification = productElement.getElementsByTagName("codification");
						for (int k = 0, c2 = codification.getLength(); k < c2; k++) {
							Node productNode3 = codification.item(k);
							if (productNode3.getNodeType() == Node.ELEMENT_NODE) {
								Element productElement3 = (Element) productNode3;
								String nomCodification3 = productElement3.getElementsByTagName("nomCodification").item(0)
										.getTextContent();
								String actif3 = productElement3.getElementsByTagName("actif").item(0).getTextContent();
								String dateModification3 = productElement3.getElementsByTagName("dateModification").item(0)
										.getTextContent();
								String code3 = productElement3.getElementsByTagName("code").item(0).getTextContent();
								String libelle3 = productElement3.getElementsByTagName("libelle").item(0).getTextContent();

								Codification product3 = new Codification();
								product3.setNomCodification(nomCodification3);
								product3.setActif(Boolean.parseBoolean(actif3));
								product3.setDateModification(LocalDateTime.parse(dateModification3));
								product3.setLibelle(libelle3);
								product3.setCode(code3);
								products.put(code3, product3);
							}
						}
					}
				}
			}
		}
		return products;
	}

	private static Map<String, Codification> getAllProductInXmlFile2(Document doc) {
		Map<String, Codification> products = new HashMap<>();
		NodeList codifications1 = doc.getElementsByTagName("codification");

		for (int i = 0, c = codifications1.getLength(); i < c; i++) {
			Node codificationNode1 = codifications1.item(i);
			if (codificationNode1.getNodeType() == Node.ELEMENT_NODE) {

				Element codificationElement1 = (Element) codificationNode1;
				String nomCodification = codificationElement1.getAttribute("nomCodification");
				String actif = codificationElement1.getAttribute("actif");
				String dateModification = codificationElement1.getElementsByTagName("dateModification").item(0)
						.getTextContent();
				String code = codificationElement1.getElementsByTagName("code").item(0).getTextContent();
				String libelle = codificationElement1.getElementsByTagName("libelle").item(0).getTextContent();

				Codification product = new Codification();
				product.setNomCodification(nomCodification);
				product.setActif(Boolean.parseBoolean(actif));
				product.setDateModification(LocalDateTime.parse(dateModification));
				product.setLibelle(libelle);
				product.setCode(code);
				products.put(code, product);

				NodeList codifications2 = codificationElement1.getElementsByTagName("codification");
				for (int j = 0, c1 = codifications2.getLength(); j < c1; j++) {
					Node productNode2 = codifications2.item(j);
					if (productNode2.getNodeType() == Node.ELEMENT_NODE) {
						Element productElement2 = (Element) productNode2;

						String nomCodification2 = productElement2.getAttribute("nomCodification");
						String actif2 = productElement2.getAttribute("actif");
						String dateModification2 = productElement2.getElementsByTagName("dateModification").item(0)
								.getTextContent();
						String code2 = productElement2.getElementsByTagName("code").item(0).getTextContent();
						String libelle2 = productElement2.getElementsByTagName("libelle").item(0).getTextContent();

						Codification product2 = new Codification();
						product2.setNomCodification(nomCodification2);
						product2.setActif(Boolean.parseBoolean(actif2));
						product2.setDateModification(LocalDateTime.parse(dateModification2));
						product2.setLibelle(libelle2);
						product2.setCode(code2);
						products.put(code2, product2);

						NodeList codification = productElement2.getElementsByTagName("codification");
						for (int k = 0, c2 = codification.getLength(); k < c2; k++) {
							Node productNode3 = codification.item(k);
							if (productNode3.getNodeType() == Node.ELEMENT_NODE) {
								Element productElement3 = (Element) productNode3;
								
								String nomCodification3 = productElement3.getAttribute("nomCodification");
								String actif3 = productElement3.getAttribute("actif");
								String dateModification3 = productElement3.getElementsByTagName("dateModification").item(0)
										.getTextContent();
								String code3 = productElement3.getElementsByTagName("code").item(0).getTextContent();
								String libelle3 = productElement3.getElementsByTagName("libelle").item(0).getTextContent();

								Codification product3 = new Codification();
								product3.setNomCodification(nomCodification3);
								product3.setActif(Boolean.parseBoolean(actif3));
								product3.setDateModification(LocalDateTime.parse(dateModification3));
								product3.setLibelle(libelle3);
								product3.setCode(code3);
								products.put(code3, product3);
							}
						}
					}
				}

			}
		}

		return products;
	}

	private static void getAllStudents(Document doc) {
		NodeList studentNodes = doc.getElementsByTagName("student");
		System.out.println(studentNodes.getLength());
		for (int i = 0; i < studentNodes.getLength(); i++) {
			Node studentNode = studentNodes.item(i);
			if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
				Element studentElement = (Element) studentNode;
				String studentId = studentElement.getElementsByTagName("id").item(0).getTextContent();
				String studentName = studentElement.getElementsByTagName("name").item(0).getTextContent();
				System.out.println("Student Id = " + studentId);
				System.out.println("Student Name = " + studentName);
			}
		}
	}

}

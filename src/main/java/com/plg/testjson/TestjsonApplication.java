package com.plg.testjson;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.plg.testjson.models.EnergieVehicule;
import com.plg.testjson.models.Marque;
import com.plg.testjson.models.Modele;
import com.plg.testjson.models.TypeCarosserie;
import com.plg.testjson.models.UsageVehicule;
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
		// String student = "students.xml";
		// String product = "convertjson.xml";
		String codification = "codifications.xml";
		File xmlFile = new File(codification);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);
		Map<String, List<?>> productMap = getAllProductInXmlFile2(doc);
		int nbSave = this.productService.saveAll(productMap);
		System.out.println("Nombre d'enregistrement : " + nbSave);
		log.info("Serveur run");
	}

	private static Map<String, List<?>> getAllProductInXmlFile2(Document doc) {

		Map<String, List<?>> codifications = new HashMap<>();

		List<Marque> marques = new ArrayList<>();
		List<Modele> modeles = new ArrayList<>();
		List<TypeCarosserie> typeCarosseries = new ArrayList<>();
		List<UsageVehicule> uVehicules = new ArrayList<>();
		List<EnergieVehicule> eVehicules = new ArrayList<>();

		NodeList cNodeList1 = doc.getElementsByTagName("codification");

		for (int i = 0, c = cNodeList1.getLength(); i < c; i++) {
			Node codificationNode1 = cNodeList1.item(i);
			if (codificationNode1.getNodeType() == Node.ELEMENT_NODE) {

				Element codificationElement1 = (Element) codificationNode1;
				String nomCodification = codificationElement1.getAttribute("nomCodification");
				String actif = codificationElement1.getAttribute("actif");
				String dateModification = codificationElement1.getElementsByTagName("dateModification").item(0)
						.getTextContent();
				String code = codificationElement1.getElementsByTagName("code").item(0).getTextContent();
				String libelle = codificationElement1.getElementsByTagName("libelle").item(0).getTextContent();

				Codification codif1 = new Codification();
				codif1.setNomCodification(nomCodification);
				codif1.setActif(Boolean.parseBoolean(actif));
				codif1.setDateModification(LocalDateTime.parse(dateModification));
				codif1.setLibelle(libelle);
				codif1.setCode(code);

				switch (nomCodification) {
					case "type_carosserie":
						typeCarosseries.add(new TypeCarosserie(codif1));
						break;
					case "usage_vehicule":
						uVehicules.add(new UsageVehicule(codif1));
						break;
					case "voiture_marque":
						marques.add(new Marque(codif1));
						break;
					case "voiture_modele":
						modeles.add(new Modele(codif1));
						break;
					case "energie_vehicule":
						eVehicules.add(new EnergieVehicule(codif1));
						break;
					default:
						break;
				}
			}
		}

		codifications.put("type_carosserie", typeCarosseries);
		codifications.put("usage_vehicule", uVehicules);
		codifications.put("voiture_marque", marques);
		codifications.put("voiture_modele", modeles);
		codifications.put("energie_vehicule", eVehicules);

		return codifications;
	}

	private static void getAllStudents(Document doc) {
		NodeList studentNodes = doc.getElementsByTagName("student");
		System.out.println(studentNodes.getLength());
		for (int i = 0; i < studentNodes.getLength(); i++) {
			Node studentNode = studentNodes.item(i);
			if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
				Element studentElement = (Element) studentNode;
				String attribute = studentElement.getAttribute("graduated");
				String studentId = studentElement.getElementsByTagName("id").item(0).getTextContent();
				String studentName = studentElement.getElementsByTagName("name").item(0).getTextContent();
				System.out.println("attribute = " + attribute);
				System.out.println("Student Id = " + studentId);
				System.out.println("Student Name = " + studentName);
			}
		}
	}

}

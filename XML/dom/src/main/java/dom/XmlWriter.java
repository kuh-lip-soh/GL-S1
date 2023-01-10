package dom;

import java.io.File;
import java.io.FileOutputStream;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class XmlWriter {
	public static void main(String[] args) {
 
		ecrireXML();	
	}
	
	private static void ecrireXML(){

		try{	
			Document doc = new Document();
		
			Element theRoot = new Element("Phones");
			doc.setRootElement(theRoot);
			
			Element phone = new Element("Phone");
			phone.setAttribute("note", "4");
			Element marque = new Element("Marque");
			Element modele = new Element("Modele");
			Element date = new Element("Date");
			Element vente = new Element("Vente");
			Element specs = new Element("Specs");
			Element sim = new Element("Sim");

			sim.setAttribute("double","true");
			date.setAttribute("jour","10");
			date.setAttribute("mois","02");
			date.setAttribute("annee","2020");

			specs.addContent(sim);

			marque.addContent(new Text("Samsung"));
			modele.addContent(new Text("S20"));
			vente.addContent(new Text("10"));

			phone.addContent(marque);
			phone.addContent(modele);
			phone.addContent(date);
			phone.addContent(vente);
			phone.addContent(specs);


			Element phone2 = new Element("Phone");
			phone2.setAttribute("note", "5");
			Element marque2 = new Element("Marque");
			Element modele2 = new Element("Modele");
			Element date2 = new Element("Date");
			Element vente2 = new Element("Vente");
			Element specs2 = new Element("Specs");
			Element sim2 = new Element("Sim");

			sim2.setAttribute("double","false");
			date2.setAttribute("jour","20");
			date2.setAttribute("mois","02");
			date2.setAttribute("annee","2022");

			specs2.addContent(sim2);

			marque2.addContent(new Text("Google"));
			modele2.addContent(new Text("Pixel 7"));
			vente2.addContent(new Text("8"));
			
			phone2.addContent(marque2);
			phone2.addContent(modele2);
			phone2.addContent(date2);
			phone2.addContent(vente2);
			phone2.addContent(specs2);


			Element phone3 = new Element("Phone");
			phone3.setAttribute("note", "5");
			Element marque3 = new Element("Marque");
			Element modele3 = new Element("Modele");
			Element date3 = new Element("Date");
			Element vente3 = new Element("Vente");
			Element specs3 = new Element("Specs");
			Element sim3 = new Element("Sim");

			sim3.setAttribute("double","false");
			date3.setAttribute("jour","20");
			date3.setAttribute("mois","02");
			date3.setAttribute("annee","2022");

			specs3.addContent(sim3);

			marque3.addContent(new Text("Google"));
			modele3.addContent(new Text("Pixel 6A"));
			vente3.addContent(new Text("88"));
			
			phone3.addContent(marque3);
			phone3.addContent(modele3);
			phone3.addContent(date3);
			phone3.addContent(vente3);
			phone3.addContent(specs3);

			theRoot.addContent(phone);
			theRoot.addContent(phone2);
			theRoot.addContent(phone3);


			XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileOutputStream(new File("./src/phone.xml")));
		
			System.out.println("fichier XML generé");
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void example(){

	try{	
		Document doc = new Document();
	
		Element theRoot = new Element("livre");
		doc.setRootElement(theRoot);
		theRoot.setAttribute("titre","Mon livre");
		
		
		Element auteurs = new Element("auteurs");
		Element auteur = new Element("auteur");
	
		auteur.setAttribute("nom", "n1");
		auteur.setAttribute("prenom", "p1");
		
		Element auteur2 = new Element("auteur");
		
		auteur2.setAttribute("nom", "n2");
		auteur2.setAttribute("prenom", "p2");
		
		auteurs.addContent(auteur);
		auteurs.addContent(auteur2);
		
		theRoot.addContent(auteurs);
		
		Element sections = new Element("sections");
		
		Element section = new Element("section");
		
		section.setAttribute("titre", "S1");
		
		Element chapitre = new Element("chapitre");
		
		chapitre.setAttribute("titre", "C1");
		
		Element paragraphe = new Element("paragraphe");
		
		paragraphe.addContent(new Text("prmier paragraphe"));
		
		Element paragraphe2 = new Element("paragraphe");
		
		paragraphe2.addContent(new Text("deuxiem paragraphe"));
		
		chapitre.addContent(paragraphe);
		chapitre.addContent(paragraphe2);
		section.addContent(chapitre);
		
		sections.addContent(section);
		
		Element section2 = new Element("section");
		
		section2.setAttribute("titre", "S2");
		
		Element chapitre2 = new Element("chapitre");
		
		chapitre2.setAttribute("titre", "C2");
		
		Element paragraphe3 = new Element("paragraphe");
		
		paragraphe3.addContent(new Text("1 er paragraphe"));
		
		Element paragraphe4 = new Element("paragraphe");
		
		paragraphe4.addContent(new Text("2eme paragraphe"));
		
		Element conclusion = new Element("conclusion");
		
		conclusion.addContent(new Text("Conclusion"));
		
		Element perspective = new Element("perspective");
		
		chapitre2.addContent(paragraphe3);
		chapitre2.addContent(paragraphe4);
		section2.addContent(chapitre2);
		section2.addContent(conclusion);
		section2.addContent(perspective);
		
		sections.addContent(section2);
		
		theRoot.addContent(sections);
		





		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		


		xmlOutput.output(doc, new FileOutputStream(new File("./src/tp4.xml")));
		
		System.out.println("fichier XML generé");
		
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
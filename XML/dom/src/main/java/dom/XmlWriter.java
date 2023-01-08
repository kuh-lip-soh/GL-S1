package dom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class XmlWriter {
	public static void main(String[] args) {
 
		ecrireXML();	
	}
	
	private static void ecrireXML(){

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
		


		xmlOutput.output(doc, new FileOutputStream(new File("./src/GenererUnFichier.xml")));
		
		System.out.println("fichier XML generé");
		
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
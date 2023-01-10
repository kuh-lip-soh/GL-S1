package dom;
import org.xml.sax.*;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;


public class XmlReader {
	public static void main(String[] args) {
		lireXml();
	}
	public static void lireXml(){

				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				try {
					
					DocumentBuilder buidler =factory.newDocumentBuilder();
					Document doc = buidler.parse("src/phone.xml");
					
					Element root = doc.getDocumentElement();
					System.out.println("la racine est: " + root.getNodeName());

					NodeList listPhone = doc.getElementsByTagName("Phone");
			        System.out.println("le nombre de téléphones est : " + listPhone.getLength());

					for(int i =0; i<listPhone.getLength() ;i++){
						Node phoneNode = listPhone.item(i);
						Element phoneElement = (Element) phoneNode;
						String note = phoneElement.getAttribute("note");
						Element marque = getFirstChildElement(phoneNode);
						Element modele = getNextElement(getFirstChildElement(phoneNode));
						String marqueText = marque.getTextContent();
						String modeleText = modele.getTextContent();
						Element date = getNextElement(getNextElement(getFirstChildElement(phoneNode)));
						String jour = date.getAttribute("jour");
						String mois = date.getAttribute("mois");
						String annee = date.getAttribute("annee");
						System.out.println("Téléphone "+(i+1)+": "+marqueText+" "+modeleText+ "   "+ note+"*" + " - Sortie le : "+ jour + "-" + mois + "-" + annee);
                    }

				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	

	public static void example(){

		// API used to convert XML into a DOM object tree
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				try {
					
					DocumentBuilder buidler =factory.newDocumentBuilder();
					Document doc = buidler.parse("src/tp4.xml");
					
					// récupérer la racine
					Element root = doc.getDocumentElement();
					System.out.println("la racine est: " + root.getNodeName());
					
					//Affichage information sur l'auteur
					NodeList listAuteur = doc.getElementsByTagName("auteur");
			        System.out.println("le nombre d'auteur est : " + listAuteur.getLength());

					//parcourir la liste
					for(int i =0; i<listAuteur.getLength() ;i++){
						Node auteurNode = listAuteur.item(i);
						Element auteurElement = (Element) auteurNode ;
						String attrnom = auteurElement.getAttribute("nom");
						String attrprenom = auteurElement.getAttribute("prenom");
					System.out.println("auteur "+(i+1)+": "+attrnom+" "+attrprenom+" .");
                    }

                    NodeList listSections = doc.getElementsByTagName("sections");
					for(int j=0; j<listSections.getLength(); j++){
						Node sections = listSections.item(j);
						
						System.out.println(getFirstChildElement(sections).getTagName());
						System.out.println(getNextElement(getFirstChildElement(sections)).getTagName());
					}
					
					
					//Affichage information sur section/cahpitre/paragraph 
					NodeList listSection = doc.getElementsByTagName("section");
					System.out.println("----------------------------");
					for(int j=0; j<listSection.getLength(); j++){
						Node sections = listSection.item(j);
						Element section =(Element) sections;
						Element cahpitre = getFirstChildElement(sections);
						Element paragraphe = getFirstChildElement(cahpitre);
						String attrSectionTitre = section.getAttribute("titre");
						System.out.println("titre section n"+ (j+1) +" :"+attrSectionTitre);
						String attrChaptitre = cahpitre.getAttribute("titre");
						System.out.println("titre du chapitre n"+(j+1)+" : "+attrChaptitre);
						while (paragraphe != null){
							System.out.print(paragraphe.getNodeName()+": ");
						    System.out.println(paragraphe.getTextContent().trim());
						    paragraphe =getNextElement(paragraphe);
						}
						System.out.println("----------------------------");
						//section = getNextElement(section);
						//NodeList listchapitre = doc.getElementsByTagName("chapitre");
						/*for(int k=0; k<listchapitre.getLength(); k++){
							
							String attrChaptitre = cahpitre.getAttribute("titre");
							System.out.println("titre du chapitre n"+(k+1)+" : "+attrChaptitre);
							NodeList listpagraphe = doc.getElementsByTagName("paragraphe");
							for(int h=0; h<listpagraphe.getLength(); h++){
								Element paragraphe = (Element) listpagraphe.item(h);
								System.out.println(paragraphe.getTextContent());
						}
						}*/
						
						
					}
					
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	//function pour avoir le premiere Element fils
	public static Element getFirstChildElement(Node parent) {
	      NodeList childs = parent.getChildNodes();
	      for (int i = 0; i < childs.getLength(); i++) {
	          Node child = childs.item(i);
	          if (child instanceof Element) {
	              return (Element) child;
	          }
	      }
	      return null;
	  }

	//function pour avoir l’Element frere suivant 

	 public static Element getNextElement(Element el) {
		    Node nd = el.getNextSibling();
		    while (nd != null) {
		        if (nd.getNodeType() == Node.ELEMENT_NODE) {
		            return (Element)nd;
		        }
		        nd = nd.getNextSibling();
		    }
		    return null;
		}

}

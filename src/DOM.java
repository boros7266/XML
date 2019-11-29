import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class DOM {
	
	public static void main(String[] args) {
		Create asd ;
	try {
		
		
			File xmlDoc = new File("Orvos.xml");
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			
			System.out.println("Root Element:" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("Anyakonyv");
			
			for (int i = 0; i < nList.getLength(); i++)
			{
				Node nNode = nList.item(i);
				System.out.println("Anyakönyv szám: " + nNode.getNodeName() + " " + (i+1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					System.out.println("Anyakönyv ID#: " + eElement.getAttribute("anyakonyv_id"));
					System.out.println("Gyermek neve: " +
						eElement.getElementsByTagName("Gyermek_neve").item(0).getTextContent());
					System.out.println("Születési dátum: " +
							eElement.getElementsByTagName("Szul_datum").item(0).getTextContent());
					System.out.println("Oltások: " +
							eElement.getElementsByTagName("Oltasok").item(0).getTextContent());
					System.out.println("Nem: " +
							eElement.getElementsByTagName("Nem").item(0).getTextContent());
					System.out.println("Szülõ ID#: " + eElement.getAttribute("szulo_id"));
					System.out.println("Szülõ név: " +
							eElement.getElementsByTagName("Teljes_nev").item(0).getTextContent());
					System.out.println("Szülõ tel: " +
							eElement.getElementsByTagName("Telefonszam").item(0).getTextContent());
					System.out.println("Szülõ e-mail: " +
							eElement.getElementsByTagName("email_cim").item(0).getTextContent());
					System.out.println("Szülõ info: " +
							eElement.getElementsByTagName("Szulo_info").item(0).getTextContent());
					System.out.println("Szülõ irányítószáma: " +
							eElement.getElementsByTagName("Irszam").item(0).getTextContent());
					System.out.println("Szülõ város: " +
							eElement.getElementsByTagName("Varos").item(0).getTextContent());
					System.out.println("Szülõ utca házszám: " +
							eElement.getElementsByTagName("Utca_hsz").item(0).getTextContent());
					System.out.println("--------------------------------------------");
					}
			}
			NodeList n1List = doc.getElementsByTagName("Termekek");
			
			for (int i = 0; i < n1List.getLength(); i++)
			{
				Node nNode = n1List.item(i);
				System.out.println("Termék szám: " + nNode.getNodeName() + " " + (i+1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					System.out.println("Termék ID#: " + eElement.getAttribute("Termek_id"));
					System.out.println("Raktárkészlet: " +
							eElement.getElementsByTagName("Raktarkeszlet").item(0).getTextContent());
					System.out.println("Termék ár: " +
							eElement.getElementsByTagName("Ar").item(0).getTextContent());
					System.out.println("--------------------------------------------");
					}
			}
			NodeList n2List = doc.getElementsByTagName("Beszallito");
			
			for (int i = 0; i < n2List.getLength(); i++)
			{
				Node nNode = n2List.item(i);
				System.out.println("Beszállitó szám : " + nNode.getNodeName() + " " + (i+1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					System.out.println("Cég ID#: " + eElement.getAttribute("ceg_id"));
					System.out.println("Cég neve: " +
							eElement.getElementsByTagName("Ceg_neve").item(0).getTextContent());
					System.out.println("--------------------------------------------");
					}
			}		
			asd = new Create(doc);
			asd.modosit("1234", "123");
			asd.save();
		}
		catch(Exception e) {}	
	}
}
 
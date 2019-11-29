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
				System.out.println("Anyak�nyv sz�m: " + nNode.getNodeName() + " " + (i+1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					System.out.println("Anyak�nyv ID#: " + eElement.getAttribute("anyakonyv_id"));
					System.out.println("Gyermek neve: " +
						eElement.getElementsByTagName("Gyermek_neve").item(0).getTextContent());
					System.out.println("Sz�let�si d�tum: " +
							eElement.getElementsByTagName("Szul_datum").item(0).getTextContent());
					System.out.println("Olt�sok: " +
							eElement.getElementsByTagName("Oltasok").item(0).getTextContent());
					System.out.println("Nem: " +
							eElement.getElementsByTagName("Nem").item(0).getTextContent());
					System.out.println("Sz�l� ID#: " + eElement.getAttribute("szulo_id"));
					System.out.println("Sz�l� n�v: " +
							eElement.getElementsByTagName("Teljes_nev").item(0).getTextContent());
					System.out.println("Sz�l� tel: " +
							eElement.getElementsByTagName("Telefonszam").item(0).getTextContent());
					System.out.println("Sz�l� e-mail: " +
							eElement.getElementsByTagName("email_cim").item(0).getTextContent());
					System.out.println("Sz�l� info: " +
							eElement.getElementsByTagName("Szulo_info").item(0).getTextContent());
					System.out.println("Sz�l� ir�ny�t�sz�ma: " +
							eElement.getElementsByTagName("Irszam").item(0).getTextContent());
					System.out.println("Sz�l� v�ros: " +
							eElement.getElementsByTagName("Varos").item(0).getTextContent());
					System.out.println("Sz�l� utca h�zsz�m: " +
							eElement.getElementsByTagName("Utca_hsz").item(0).getTextContent());
					System.out.println("--------------------------------------------");
					}
			}
			NodeList n1List = doc.getElementsByTagName("Termekek");
			
			for (int i = 0; i < n1List.getLength(); i++)
			{
				Node nNode = n1List.item(i);
				System.out.println("Term�k sz�m: " + nNode.getNodeName() + " " + (i+1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					System.out.println("Term�k ID#: " + eElement.getAttribute("Termek_id"));
					System.out.println("Rakt�rk�szlet: " +
							eElement.getElementsByTagName("Raktarkeszlet").item(0).getTextContent());
					System.out.println("Term�k �r: " +
							eElement.getElementsByTagName("Ar").item(0).getTextContent());
					System.out.println("--------------------------------------------");
					}
			}
			NodeList n2List = doc.getElementsByTagName("Beszallito");
			
			for (int i = 0; i < n2List.getLength(); i++)
			{
				Node nNode = n2List.item(i);
				System.out.println("Besz�llit� sz�m : " + nNode.getNodeName() + " " + (i+1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					System.out.println("C�g ID#: " + eElement.getAttribute("ceg_id"));
					System.out.println("C�g neve: " +
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
 
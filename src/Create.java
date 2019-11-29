import java.io.File;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Create {
	
	private Document doc;
	
	public Create(Document doc) {
		this.doc = doc;
	}
	
	public void modosit(String alk, String term) {
		NodeList list = doc.getElementsByTagName("Anyakonyv");
		for (int i=0; i<list.getLength(); i++) {
			
			Node d = list.item(i);
			
			NamedNodeMap nnm = d.getAttributes();
			Node id = nnm.getNamedItem("anyakonyv_id");
			
			if(id.getTextContent().compareTo(alk) == 0) {
				
				NodeList nodes = d.getChildNodes();
				id.setTextContent(term);
			//	System.out.println("ezitt:" + nodes);
				for (int j=0; j<nodes.getLength(); j++) {
					Node n = nodes.item(j);
					if(n.getNodeName().compareTo("szulo_id") == 0) {
						n.setTextContent(term);
						System.out.println("ezitt:" + n.getTextContent());
					}
					
				}
			}
			
		}
	}
	public void save() {
		DOMSource source = new DOMSource(doc);
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			StringWriter writer = new StringWriter();	
			StreamResult result = new StreamResult(new File("Orvos.xml"));
			//StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
			System.out.println(writer.toString());
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

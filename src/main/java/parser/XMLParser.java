package parser;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLParser {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLParser app = new XMLParser();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		String fileName = "test.xml";
		
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(app.getInputStreamFromResourceFile(fileName));
			Element element = document.getDocumentElement();
			System.out.println(element.hasChildNodes());
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
	
	private InputStream getInputStreamFromResourceFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream in = classLoader.getResourceAsStream(fileName);
		
		if (in == null) {
			throw new IllegalArgumentException(String.format("The file %s is not found.", fileName));
		}
		
		return in;
	}

}

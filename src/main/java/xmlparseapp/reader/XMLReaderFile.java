package xmlparseapp.reader;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLReaderFile {
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder = null;
	private Document document = null;
	
	public Document getDocumentFromFile(String fileName) throws SAXException, IOException, ParserConfigurationException {
		builder = factory.newDocumentBuilder();
		document = builder.parse(fileName);
		
		return document;
	}
	
	public Document getDocumentFromResourceFile(String fileName) throws SAXException, IOException, ParserConfigurationException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream(fileName);
		
		if (is == null) {
			throw new IllegalArgumentException(String.format("The file %s is not found.", fileName));
		}
		
		builder = factory.newDocumentBuilder();
		document = builder.parse(is);
		is.close();
		
		return document;
	}
	
	 
}

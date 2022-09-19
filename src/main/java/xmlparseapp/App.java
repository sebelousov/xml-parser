package xmlparseapp;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import xmlparseapp.entity.Job;
import xmlparseapp.parser.XMLParser;
import xmlparseapp.parser.XMLParserDOM;
import xmlparseapp.reader.XMLReaderFile;

public class App {
	private static String fileName;
	
	public App(String fileName) {
		super();
		this.fileName = fileName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App("test.xml");
		
		XMLReaderFile reader = new XMLReaderFile(fileName);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(reader.getIn());
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
		
		XMLParser parser = new XMLParserDOM(document);
		List<Job> jobs = parser.parseAllJobsFromXML();
		
		for (Job j : jobs) {
			System.out.println(j);
		}
	}

}

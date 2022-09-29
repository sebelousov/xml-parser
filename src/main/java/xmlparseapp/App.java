package xmlparseapp;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import xmlparseapp.entity.Job;
import xmlparseapp.parser.XMLParser;
import xmlparseapp.parser.XMLParserDOM;
import xmlparseapp.reader.XMLReaderFile;

public class App {
	private XMLReaderFile reader; 
	private XMLParser parser;
	
	public App(XMLReaderFile reader, XMLParser parser) {
		super();
		this.reader = reader;
		this.parser = parser;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = args.length == 0 ? "test.xml" : args[0];
		
		if (!fileName.endsWith(".xml")) {
			return;
		}
		
		App app = new App(new XMLReaderFile(), new XMLParserDOM());
		
		List<Job> jobs = null;
		
		try {
			Document document = app.getDocument(fileName);
			jobs = app.parseAllJobs(document);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (jobs != null) {
			for (Job j : jobs) {
				System.out.println(j);
			}
		}
	}
	
	private Document getDocument(String fileName) throws SAXException, IOException, ParserConfigurationException {
		return reader.getDocumentFromFile(fileName);
	}
	
	private List<Job> parseAllJobs(Document document) {
		return parser.parseAllJobsFromXML(document);
	}
}

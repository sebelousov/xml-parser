package xmlparseapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import xmlparseapp.entity.Job;
import xmlparseapp.parser.XMLParser;
import xmlparseapp.parser.XMLParserDOM;
import xmlparseapp.reader.XMLReaderFile;

public class App {
	private static XMLReaderFile reader = new XMLReaderFile(); 
	private static XMLParser parser = new XMLParserDOM(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = args.length == 0 ? "test.xml" : args[0];
		
		Document document = null;
		List<Job> jobs = null;
		
		try {
			document = reader.getDocumentFromResourceFile(fileName);
			jobs = parser.parseAllJobsFromXML(document);
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

}

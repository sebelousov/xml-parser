package xmlparseapp;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import xmlparseapp.entity.Job;
import xmlparseapp.helper.ExcelWriter;
import xmlparseapp.helper.XLSExcelWriter;
import xmlparseapp.parser.XMLParser;
import xmlparseapp.parser.XMLParserDOM;
import xmlparseapp.reader.XMLReaderFile;

public class App {
	private XMLReaderFile reader; 
	private XMLParser parser;
	private ExcelWriter writer;
	
	public App(XMLReaderFile reader, XMLParser parser, ExcelWriter writer) {
		super();
		this.reader = reader;
		this.parser = parser;
		this.writer = writer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = args.length == 0 ? "test.xml" : args[0];
		
		if (!fileName.endsWith(".xml")) {
			return;
		}
		
		App app = new App(new XMLReaderFile(), new XMLParserDOM(), new XLSExcelWriter());
		
		List<Job> jobs = null;
		
		try {
			Document document = app.getDocument(fileName);
			jobs = app.parseAllJobs(document);
			app.write(jobs);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private Document getDocument(String fileName) throws SAXException, IOException, ParserConfigurationException {
		return reader.getDocumentFromFile(fileName);
	}
	
	private List<Job> parseAllJobs(Document document) {
		return parser.parseAllJobsFromXML(document);
	}
	
	private void write(List<Job> jobs) {
		writer.write(jobs);
	}
}

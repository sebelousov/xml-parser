package xmlparseapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import xmlparseapp.entity.Job;
import xmlparseapp.parser.XMLParser;
import xmlparseapp.parser.XMLParserDOM;
import xmlparseapp.retriever.XMLFileRetriever;
import xmlparseapp.retriever.XMLRetriever;
import xmlparseapp.writer.ExcelWriter;
import xmlparseapp.writer.XLSExcelWriter;

public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	
	private XMLRetriever retriever; 
	private XMLParser parser;
	private ExcelWriter writer;
	
	public App(XMLRetriever retriever, XMLParser parser, ExcelWriter writer) {
		super();
		this.retriever = retriever;
		this.parser = parser;
		this.writer = writer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		
		LOGGER.info("Test");
		
		String fileName = args.length == 0 ? "test.xml" : args[0];
		
		if (!fileName.endsWith(".xml")) {
			return;
		}
		
		new App(new XMLFileRetriever(), new XMLParserDOM(), new XLSExcelWriter()).start(fileName);
	}
	
	private void start(String fileName) {
		List<Job> jobs = null;

		try (InputStream is = retriever.retrieve(fileName)) {
			jobs = parser.parse(is);
			writer.write(jobs);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

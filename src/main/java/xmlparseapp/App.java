package xmlparseapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import xmlparseapp.entity.Job;
import xmlparseapp.parser.XMLParser;
import xmlparseapp.parser.XMLParserDOM;
import xmlparseapp.retriever.XMLFileRetriever;
import xmlparseapp.retriever.XMLRetriever;
import xmlparseapp.writer.ExcelWriter;
import xmlparseapp.writer.XLSExcelWriter;

public class App {
	private static final Logger LOGGER = Logger.getLogger(App.class);
	
	private XMLRetriever retriever; 
	private XMLParser parser;
	private ExcelWriter writer;
	
	private String fileNameSource;
	
	public App(String fileName, XMLRetriever retriever, XMLParser parser, ExcelWriter writer) {
		super();
		this.fileNameSource = fileName;
		this.retriever = retriever;
		this.parser = parser;
		this.writer = writer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Run app...");
		
//		String fileName = args.length == 0 ? "test.xml" : args[0];
		
		if (args == null && !args[0].endsWith(".xml")) {
			LOGGER.info("The source file is not found or the file is not in xml-format.");
			return;
		}
		
		LOGGER.info("Create App...");
		
		new App(args[0], new XMLFileRetriever(), new XMLParserDOM(), new XLSExcelWriter()).start();
		
		LOGGER.info("End app...");
	}
	
	private void start() {
		List<Job> jobs = null;

		try (InputStream is = retriever.retrieve(fileNameSource)) {
			jobs = parser.parse(is);
			writer.write(jobs);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

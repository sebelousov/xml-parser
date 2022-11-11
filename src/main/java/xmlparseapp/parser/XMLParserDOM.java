package xmlparseapp.parser;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xmlparseapp.entity.Job;

public class XMLParserDOM implements XMLParser {
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder = null;
	private Document document = null;
	
	private String template = "EEE MMM d hh:mm:ss z yyyy";
	private DateFormat formatter = new SimpleDateFormat(template, Locale.ENGLISH);
	
	@Override
	public List<Job> parse(InputStream is) {
		// TODO Auto-generated method stub
		List<Job> jobs = new ArrayList<>();
		
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(is);
			
			Element element = document.getDocumentElement();
			
			NodeList nodeList = element.getElementsByTagName("entry");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Job job = parseJobFromEntry(nodeList.item(i));
				jobs.add(job);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobs;
	}
	
	private Job parseJobFromEntry(Node entry) throws ParseException {
		Job job = new Job();
		
		for (int i = 0; i < entry.getChildNodes().getLength(); i++) {
			
			Node node = entry.getChildNodes().item(i);
			
			if (node instanceof Element) {
				String value = node.getTextContent();
				switch (node.getNodeName()) {
				case "id":
					String[] pairs = value.split(":");
					
					job.setUrl(pairs[1]);
					job.setOrder(Integer.parseInt(pairs[3]));
					job.setJobId(Integer.parseInt(pairs[5]));
					
					break;
				case "author":
					job.setAuthor(value);
					break;
				case "theme":
					job.setTheme(value);
					break;
				case "title":
					job.setTitle(value);
					break;
				case "published":
					job.setPublishedDate(formatter.parse(value));
					break;
				case "content":
					job.setContent(value);
					break;
				}
			}
		}
		
		return job;
	}
}

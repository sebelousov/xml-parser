package xmlparseapp.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		}
		
		return jobs;
	}
	
	private Job parseJobFromEntry(Node entry) {
		Job job = new Job();
		
		for (int i = 0; i < entry.getChildNodes().getLength(); i++) {
			
			Node node = entry.getChildNodes().item(i);
			
			if (node instanceof Element) {
				String value = node.getTextContent();
				switch (node.getNodeName()) {
				case "id":
					Map<String, String> map = parseId(value);
					job.setUrl(map.get("urn"));
					job.setOrder(map.get("order"));
					job.setJobId(map.get("jobs"));
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
					job.setPublishedDate(new Date(value));
					break;
				case "content":
					job.setContent(value);
					break;
				}
			}
		}
		
		return job;
	}
	
	private Map<String, String> parseId(String content) {
		// urn:advego.ru:order:32268444:jobs:231042157
		
		String[] pairs = content.split(":");

		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < pairs.length; i++) {
			if (i % 2 == 0) {
				map.put(pairs[i], pairs[i + 1]);
			}
		}
		
		return map;
	}
}

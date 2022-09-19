package xmlparseapp.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xmlparseapp.entity.Job;

public class XMLParserDOM implements XMLParser {
	private Document document;
	
	public XMLParserDOM(Document document) {
		super();
		this.document = document;
	}

	@Override
	public List<Job> parseAllJobsFromXML() {
		// TODO Auto-generated method stub
		List<Job> jobs = new ArrayList<>();
		Element element = document.getDocumentElement();
		
		NodeList nodeList = element.getElementsByTagName("entry");
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Job job = parseJobFromEntry(nodeList.item(i));
			jobs.add(job);
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
					job.setOrder(Integer.parseInt(map.get("order")));
					job.setId(Integer.parseInt(map.get("jobs")));
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

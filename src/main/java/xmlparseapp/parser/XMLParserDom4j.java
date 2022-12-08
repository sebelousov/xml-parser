package xmlparseapp.parser;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import xmlparseapp.App;
import xmlparseapp.entity.Job;

public class XMLParserDom4j implements XMLParser {

	private static final Logger LOGGER = Logger.getLogger(XMLParserDom4j.class);
	
	private String template = "EEE MMM d hh:mm:ss z yyyy";
	private DateFormat formatter = new SimpleDateFormat(template, Locale.ENGLISH);
	
	@Override
	public List<Job> parse(InputStream is) {
		// TODO Auto-generated method stub
		LOGGER.info("Start method parse.");
		
		SAXReader saxReader = new SAXReader();
    	List<Job> jobs = new ArrayList<>();
    	
		try (InputStream in = is) {
			Document document = saxReader.read(in);
			Element root = document.getRootElement();
			
			for (Iterator<Element> it = root.elementIterator("entry"); it.hasNext();) {
		        Element entry = it.next();
		        Job job = new Job();
		        
		        String id = entry.element("id").getStringValue().trim();
		        String[] pairs = id.split(":");
				
		        job.setJobId(Integer.parseInt(pairs[5]));
		        job.setOrder(Integer.parseInt(pairs[3]));
				job.setUrl(pairs[1]);
				job.setAuthor(entry.element("author").getStringValue().trim());
		        job.setTheme(entry.element("theme").getStringValue());
		        job.setTitle(entry.element("title").getStringValue());
		        job.setPublishedDate(formatter.parse(entry.element("published").getStringValue()));
		        job.setContent(entry.element("content").getStringValue());
		        
		        jobs.add(job);
		    }
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			LOGGER.info("DocumentException.");
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			LOGGER.info("IOException.");
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.info("ParseException.");
			e.printStackTrace();
		}
		
		LOGGER.info("End method parse.");
		
		return jobs;
	}

}

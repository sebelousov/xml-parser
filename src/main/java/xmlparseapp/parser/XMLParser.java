package xmlparseapp.parser;

import java.util.List;

import org.w3c.dom.Document;
import xmlparseapp.entity.Job;

public interface XMLParser {
	List<Job> parseAllJobsFromXML(Document document);
}

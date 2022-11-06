package xmlparseapp.parser;

import java.io.InputStream;
import java.util.List;

import org.w3c.dom.Document;
import xmlparseapp.entity.Job;

public interface XMLParser {
	List<Job> parse(InputStream is);
}

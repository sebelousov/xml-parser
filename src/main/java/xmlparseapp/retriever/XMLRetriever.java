package xmlparseapp.retriever;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface XMLRetriever {
	public InputStream retrieve(String fileName) throws SAXException, IOException, ParserConfigurationException;
}

package xmlparseapp.retriever;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import xmlparseapp.App;

public class XMLFileRetriever implements XMLRetriever {
	
	private static final Logger LOGGER = Logger.getLogger(XMLFileRetriever.class);
	
	public InputStream retrieve(String fileNameSource) {
		
		LOGGER.info(String.format("Start method retrieve with file %s.", fileNameSource));
		
		InputStream is = null;
		
		try {
			is = new FileInputStream(fileNameSource);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.info(String.format("FileNotFoundException - file %s.", fileNameSource));
			e.printStackTrace();
		}
		
		LOGGER.info(String.format("End retrieve with file %s.", fileNameSource));
		
		return is;
	}
}

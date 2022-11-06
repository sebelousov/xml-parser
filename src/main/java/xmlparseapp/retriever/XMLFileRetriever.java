package xmlparseapp.retriever;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XMLFileRetriever implements XMLRetriever {
	
	public InputStream retrieve(String fileName) {
		
		InputStream is = null;
		
		try {
			is = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is;
	}
}

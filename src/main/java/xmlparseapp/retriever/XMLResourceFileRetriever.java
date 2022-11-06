package xmlparseapp.retriever;

import java.io.IOException;
import java.io.InputStream;

public class XMLResourceFileRetriever implements XMLRetriever {

	@Override
	public InputStream retrieve(String fileName) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream(fileName);
		
		if (is == null) {
			throw new IllegalArgumentException(String.format("The file %s is not found.", fileName));
		}
		
		return is;
	}

}

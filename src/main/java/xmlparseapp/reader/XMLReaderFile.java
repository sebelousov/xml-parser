package xmlparseapp.reader;

import java.io.InputStream;

public class XMLReaderFile {
	private String fileName;
	private InputStream in = null;
	
	public XMLReaderFile(String fileName) {
		super();
		this.fileName = fileName;
		this.in = getInputStreamFromResourceFile(this.fileName);
	}

	private InputStream getInputStreamFromResourceFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream in = classLoader.getResourceAsStream(fileName);
		
		if (in == null) {
			throw new IllegalArgumentException(String.format("The file %s is not found.", fileName));
		}
		
		return in;
	}

	public InputStream getIn() {
		return in;
	}
}

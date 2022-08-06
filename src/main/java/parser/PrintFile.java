package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PrintFile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		PrintFile app = new PrintFile();
		String fileName = "test.xml";
		
		InputStream is = app.getInputStreamFromResourceFile(fileName);
		app.printFromInputStream(is);
		
	}

	private InputStream getInputStreamFromResourceFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream(fileName);
		
		if (is == null) {
			throw new IllegalArgumentException(String.format("The file %s is not found.", fileName));
		}
		
		return is;
	}
	
	private void printFromInputStream(InputStream is) {
		try (
				InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader buffer = new BufferedReader(reader);) {
			
			String line = null;
			
			while ((line = buffer.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

package module4;

import java.net.*;
import java.io.*;

public class ExampleURLRead {

	public static void main(String[] args) throws IOException {

		try{
		URL u = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt");
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		String line;
		while ((line=b.readLine()) != null) {
			System.out.println(line);
		}
		}
		
		catch(Exception e){
			System.out.println("Failed to locate a remote (WWW) file");
		}


	}
}

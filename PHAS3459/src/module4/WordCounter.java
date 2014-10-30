package module4;

import java.io.*;
import java.net.*;
import java.util.*;

public class WordCounter {
	
	public static void main(String[] args){

		try{
			// Passing the value of url into a variable
			String url=getStringFromKeyboard();
			//Passing this variable into the method defined above
			countWordsInResource(url);
		}
		catch (IOException e){
			System.out.println("A error has occured: " +e.getMessage());
		}

	}

	//We will test a word counter on http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt

	public static String getStringFromKeyboard() throws IOException{
		//Creating object r, that reads bytes and decodes them into characters. by wrapping System.in
		InputStreamReader r = new InputStreamReader(System.in);
		//Wrapping r into a buffer (which is now an object called b)
		BufferedReader b=new BufferedReader(r);
		System.out.println("Please type the URL here: ");

		// use the readLine method on the BufferedReader to read one line at a time.    
		// the readLine method returns null when there is nothing else to read.
		return b.readLine();

	}

	public static int countWordsInResource(String urlName) throws IOException{

		//creating a new URL object
		URL u=new URL(urlName);

		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		// To look for words we will use Scanner, which is
		// a simple text scanner which can parse primitive types and strings using regular expressions.
		
		Scanner s = new Scanner(b);
		
		// Here delimiter on the scanner is defined to look for words
		s.useDelimiter("[ ,!?.]+");

		int words=0; //Variable to store total number of words

		//Here we will use our scanner

		while (s.hasNext()) {
			s.next();
			words +=1;
		}
		//Closing the stream used by scanner
		s.close();
		System.out.println("Total number of words="+words);
		return words;

	}
	
}

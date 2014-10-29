package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	public static String getStringFromKeyboard(){
		//Creating object r, that reads bytes and decodes them into characters. by wrapping System.in
		InputStreamReader r = new InputStreamReader(System.in);
		//Wrapping r into a buffer (which is now an object called b)
		BufferedReader b=new BufferedReader(r);
		System.out.println("Please type something!");
		try{
			// use the readLine method on the BufferedReader to read one line at a time.    
			// the readLine method returns null when there is nothing else to read.
			String s=b.readLine();
			System.out.println("You typed: "+s);
		}
		catch (IOException e){
			System.out.println("There was a problem: "+e.getMessage());
		}
	}
	
	
	public static int countWordsInResource(String urlName){
		try{
			//creating a new URL object
			URL u=new URL("urlName");
			
			//Opening an input stream to read some number of bytes and wrapping it into a buffer
			InputStream is=u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader b = new BufferedReader(isr);
			
			// To look for words we will use Scanner, which:
			// a simple text scanner which can parse primitive types and strings using regular expressions.
			Scanner s = new Scanner(b);
			
			double words=0; //Variable to store total number of words
			double nWords=0; // "Safety Check" variable
			while (s.hasNext()) {
				String token = s.next();
				try {
					double x = Double.parseDouble(token);
					words = words +1;
				} catch (NumberFormatException e) {
					//Counting how many times the exception is throw, when something
					//other than a word is detected 
					nWords=nWords+1;
				}
			}
			System.out.println("Total number of words="+words);
			System.out.println("Total number of non-numbers="+nWords);
			s.close();

		}

		catch(Exception e){
			System.out.println("Failed to locate a remote (WWW) address");
		}
	}
	
	public static void main(String[] args){
		//String urlName="http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt";

		


		



	}
}

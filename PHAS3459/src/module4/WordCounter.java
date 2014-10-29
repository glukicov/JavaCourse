package module4;

import java.io.*;
import java.net.*;

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
			URL u=new URL("urlName");
			
		}
	}
	
	

	public static void main(String[] args){

	}




}

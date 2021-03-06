package aaaSHORTCUTS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class implements and extends on methods, defined in the Interface, to be used in the Main class.
 * @author Gleb
 * 
 *	@version 1.3 (10/12/2014)
 */

public class Methods implements Interface {

	/**
	 * A method....  
	 * @param url
	 * @return data
	 * @throws IOException
	 */
	
	
	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it in a collection object - ArrayList (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object (ArrayList)
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<DataFormat> readData(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		
		//Creating an empty collection object to hold the data
		ArrayList<DataFormat> data = new  ArrayList<DataFormat>();
		//Creating an empty string to temporarily hold a line at a time
		String line;
		
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line if the data title is irrelevant)
		scanner.nextLine();
		
		//using a specific delimiter "," in this case
		//scanner.useDelimiter(",");
		
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			//Consume to whole line
			line = scanner.nextLine();
			//System.out.println("line=" +line);
			
			//Trim for whitesapces if appropriate 
			line.trim();
			//Opening a new scanner for this line
			Scanner scan = new Scanner(line);
			scan.useDelimiter(",");
			
			//Storing data in temporarily variables 
			String name=scan.next(); 
			//System.out.println("name=" +name);
			int year=scan.nextInt();
			//System.out.println("year= "+year);
			String method=scan.next(); 
			//System.out.println("method ="+method);
			double mass=scan.nextDouble(); 
			//System.out.println("mass= "+mass);
			double separation=scan.nextDouble(); 
			//System.out.println("separation "+separation);

			//If no distance column move on...
			double distance = 0;
			//System.out.println(distance);
			if (scan.hasNextDouble()) {
				distance =  scan.nextDouble();
			//	System.out.println("distance ="+distance);
			//	add this variables to the collection object as a data point (defined by DataFormat class)
				data.add(new DataFormat(name, year, method, mass, separation));
			}
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}
	
}

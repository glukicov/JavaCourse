package exam2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * 
 * @author Gleb
 * This class implements and extends on methods defined in SelectMethods interface to be used in Main
 */
public class Methods implements Interface {

	
	
	public String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}
	
	
	/**
	 * A method....  
	 * @param url
	 * @return data
	 * @throws IOException
	 */
	public HashMap<String,String> readNames(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		HashMap<String,String> dataMap = new  HashMap<String,String>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);

		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			line.trim();
			Scanner scan = new Scanner(line);
			String key=scan.next(); 

			String value=scan.nextLine(); 


			dataMap.put(key,value);

			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return dataMap;
	}




	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<Readings> readTMAXData(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<Readings> dataArray = new  ArrayList<Readings>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);

		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();

			Scanner scan = new Scanner(line);

			String code=scan.next(); 

			int year=scan.nextInt();

			int month=scan.nextInt();

			String type=scan.next(); 

			String data=scan.nextLine(); 


			//If not TMAX don't add
			if (type.equals("TMAX")) {
				dataArray.add(new Readings(code, year, month, type, data));
			}
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return dataArray;
	}


	public ArrayList<Integer> getYears(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<Integer> dataArray = new  ArrayList<Integer>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);

		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();

			Scanner scan = new Scanner(line);

			String code=scan.next(); 

			int year=scan.nextInt();

			int month=scan.nextInt();

			String type=scan.next(); 

			String data=scan.nextLine(); 


			//If not TMAX don't add
			if (type.equals("TMAX")) {
				dataArray.add(year);
			}
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return dataArray;
	}

}

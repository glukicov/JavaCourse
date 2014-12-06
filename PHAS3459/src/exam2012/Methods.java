package exam2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author Gleb
 * This class implements and extends on methods defined in SelectMethods interface to be used in Main
 */
public class Methods implements Interface {

	/**
	 * A method....  
	 * @param url
	 * @return data
	 * @throws IOException
	 */

	/**
	 * A method....  
	 * @param y-predicted, n-measured
	 * @return log-likelihood
	 * 
	 */
	public double logL(ArrayList<Background> y,ArrayList<Background> n){
		double sum=0;
		for (int i=0; i<y.size();i++){
		sum=sum+(y.get(i).getEvents()-n.get(i).getEvents()+((n.get(i).getEvents())*Math.log((n.get(i).getEvents()/y.get(i).getEvents()))));	
		}
		return sum;
	}
	
	
	

	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<Background> readBackground(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<Background> data = new  ArrayList<Background>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line) to skip the title line
		scanner.nextLine();

		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();

			Scanner scan = new Scanner(line);
			int lowBin=scan.nextInt(); 

			int highBin=scan.nextInt();

			double events=scan.nextDouble(); 

			//	add these variables to the collection object
			data.add(new Background(lowBin, highBin, events));
			//Explicitly closing and flushing the scanner
			scan.close();	
		}
	
	//Explicitly closing and flushing the scanner
	scanner.close();
	return data;
}

	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<Higgs> readHiggs(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<Higgs> data = new  ArrayList<Higgs>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line) to skip the title line
		scanner.nextLine();

		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();

			Scanner scan = new Scanner(line);
			String eventID=scan.next(); 

			double eventEnergy=scan.nextDouble();


			//	add these variables to the collection object
			data.add(new Higgs(eventID, eventEnergy));
			//Explicitly closing and flushing the scanner
			scan.close();	
		}
	
	//Explicitly closing and flushing the scanner
	scanner.close();
	return data;
}
	
}

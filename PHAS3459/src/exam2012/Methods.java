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
	public ArrayList<Background> retrunHiggsEvents(int signals, int normalisation, int width, ArrayList<Background> bins) {
	//Do this for each mass in the increment of 1 for number of signals provided
		// for each of mass of higgs in increment of 1
		// for each of the energy bins
		for (int i = 0; i <= signals; i++){
		for (double massHiggs = 110.5; massHiggs <= 189.5; massHiggs=massHiggs+1) {
		for (Background item: bins){
			double highE = item.getHighBin();
			double lowE = item.getLowBin();
			double lowF = (normalisation)/(width*Math.sqrt(2*Math.PI))*Math.exp(-((highE-massHiggs)*(highE-massHiggs))/2*width*width);
			double highF = (normalisation)/(width*Math.sqrt(2*Math.PI))*Math.exp(-((lowE-massHiggs)*(lowE-massHiggs))/2*width*width);
			double events = 0.5*(highF+lowF)*(highE-lowE);
			item.addEvents(events);
		}
		}
	}
	return bins;
	}

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
	
	public double logLMIN(ArrayList<Background> y,ArrayList<Background> n){
		double sum=0;
		double lowestLL=Double.MAX_VALUE;
		for (int i=0; i<y.size();i++){
		sum=sum+(y.get(i).getEvents()-n.get(i).getEvents()+((n.get(i).getEvents())*Math.log((n.get(i).getEvents()/y.get(i).getEvents()))));	
		if (sum<lowestLL){
			lowestLL=sum;
		}
		}
		return lowestLL;
	}
	
	public int logLID(ArrayList<Background> y,ArrayList<Background> n){
		double sum=0;
		double lowestLL=Double.MAX_VALUE;
		int channelID=0;
		for (int i=0; i<y.size();i++){
		sum=sum+(y.get(i).getEvents()-n.get(i).getEvents()+((n.get(i).getEvents())*Math.log((n.get(i).getEvents()/y.get(i).getEvents()))));	
		if (sum<lowestLL){
			lowestLL=sum;
			channelID=i;
		}
		}
		return channelID;
	}
	
	
	
	
	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<Background> readBins(String url) throws IOException {
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

			double events=0; 

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

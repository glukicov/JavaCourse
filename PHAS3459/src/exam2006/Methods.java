package exam2006;

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
 * T * This class implements and extends on methods defined in the Interface, to be used in Main class
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
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<BackgroundFormat> readBackground(String url, ArrayList<DataFormat> data) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<DataFormat> result = new  ArrayList<DataFormat>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line)
		//scanner.nextLine();
		//scanner.useDelimiter(",");
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			//Trim for whitesapces if appropriate 
			line.trim();

			Scanner scan = new Scanner(line);

			String name=scan.next(); 
	//		System.out.println("name=" +name);

			double startTime=scan.nextDouble();
	//		System.out.println("startTime= "+startTime);

			double dt=scan.nextDouble(); 
	//		System.out.println("dt ="+dt);

			if (scan.hasNextDouble()) {

				String textline = scan.nextLine();
				Scanner scandouble= new Scanner(textline);
		//		System.out.println("testline="+textline);
				double sum=0;
				double counter=0;
				double pn=0;
				while (scandouble.hasNextDouble()){
					pn=scandouble.nextDouble();
					sum=sum+pn;
					counter=counter+1;

				}
				double mean = sum/counter;
//				System.out.println(mean);

				result.add(new DataFormat(name, startTime,dt, pn, mean));
			}
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		
		
		System.out.println(result);
		
		ArrayList<BackgroundFormat> finalResult = new  ArrayList<BackgroundFormat>();
		double pnSig=0;
		double sumPN=0;
		double sumMean=0;
		double counter=0;
		for (DataFormat item : result){
		String name = item.getName();
		for(DataFormat dataPoint : data){
			String nameData = dataPoint.getName();
			if(name.equals(nameData)){
				sumPN=sumPN+dataPoint.getPn();
				sumMean=sumMean+dataPoint.getMean();
				counter=counter+1;
			}
			
		}
		sumPN=sumPN/counter;
		sumMean=sumMean/counter;
		pnSig=(sumPN-sumMean);
		finalResult.add(new BackgroundFormat(name, 1,1, 1, 1, pnSig));
		}
		
		
		
		
		return finalResult;
	}

	

	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
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
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line)
		//scanner.nextLine();
		//scanner.useDelimiter(",");
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			//Trim for whitesapces if appropriate 
			line.trim();

			Scanner scan = new Scanner(line);

			String name=scan.next(); 
	//		System.out.println("name=" +name);

			double startTime=scan.nextDouble();
	//		System.out.println("startTime= "+startTime);

			double dt=scan.nextDouble(); 
	//		System.out.println("dt ="+dt);

			if (scan.hasNextDouble()) {

				String textline = scan.nextLine();
				Scanner scandouble= new Scanner(textline);
		//		System.out.println("testline="+textline);
				double sum=0;
				double counter=0;
				double pn=0;
				while (scandouble.hasNextDouble()){
					pn=scandouble.nextDouble();
					sum=sum+pn;
					counter=counter+1;

				}
				double mean = sum/counter;
//				System.out.println(mean);

				data.add(new DataFormat(name, startTime,dt, pn, mean));
			}
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}

}

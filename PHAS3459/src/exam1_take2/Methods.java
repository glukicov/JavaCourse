package exam1_take2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import exam2012.Higgs;

/**
 * 
 * @author Gleb
 * This class implements and extends on methods defined in SelectMethods interface to be used in Main
 */

public class Methods implements Interface {



	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<DataFormatDistance> readPlanetsWithDistance(String url) throws IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<DataFormatDistance> data = new  ArrayList<DataFormatDistance>();
		String line;
		Scanner scanner = new Scanner(br);
		//Move to next line
		scanner.nextLine();
		//scanner.useDelimiter(",");
		//consume the whole line

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			Scanner scan = new Scanner(line);
			scan.useDelimiter(",");
			String name=scan.next(); 
			//System.out.println("name=" +name);
			int year=scan.nextInt();
			//System.out.println("year= "+year);
			String method=scan.next(); 
			//System.out.println("method ="+method);
			double mass=scan.nextDouble(); 
		//	System.out.println("mass= "+mass);
			double separation=scan.nextDouble(); 
			//System.out.println("separation "+separation);

			//If no distance column move on...
			double distance = 0;
			//System.out.println(distance);
			if (scan.hasNextDouble()) {
				distance =  scan.nextDouble();
			//	System.out.println("distance ="+distance);
				data.add(new DataFormatDistance(name, year, method, mass, separation, distance));
			}
			scan.close();
		}
		scanner.close();
		return data;
	}


	/**
	 * A method....  
	 * @param url
	 * @return data
	 * @throws IOException
	 */
	public ArrayList<DataFormat> readPlanets(String url) throws IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<DataFormat> data = new  ArrayList<DataFormat>();
		String line;
		Scanner scanner = new Scanner(br);
		//Move to next line
		scanner.nextLine();
		//scanner.useDelimiter(",");
		//consume the whole line

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			line= line.trim();
			//System.out.println("line=" +line);

			Scanner scan = new Scanner(line);
			scan.useDelimiter(",");
			 
			String name=scan.next(); 
			//System.out.println("name=" +name);
			int year=scan.nextInt();
			//System.out.println("year= "+year);
			String method=scan.next(); 
			//System.out.println("method ="+method);
			double mass=scan.nextDouble(); 
		//	System.out.println("mass= "+mass);
			double separation=scan.nextDouble(); 
			//System.out.println("separation "+separation);
	
			data.add(new DataFormat(name, year, method, mass, separation));
			scan.close();
		}
		scanner.close();
		return data;
	}


	@Override
	public ArrayList<Higgs> readHiggs(String url) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}





}

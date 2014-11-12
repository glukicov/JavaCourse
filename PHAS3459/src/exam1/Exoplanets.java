package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exoplanets {

	//This is the main class that:
	// 1) Reads the data from the URL (http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt)
	// 2) Stores the data in ArrayList collection object
	// 3) Finds the closest exoplanet to Earth (ignoring planets with no indicated distance)
	// 4) For each of the methods of discovery: 
	//							*	the number of exoplanets discovered using that method;
	// 							*   the earliest year that an exoplanet was discovered using that method;
	// 						    *	full details of the lightest exoplanet discovered using that method;

	// The data storage class for ArrayList is PlanetData.java



	public static void main(String[] args) {

		//Exoplanet Data url (name, year, method [of discovery], mass [units of Jup. mass], separation [from parents strar /a.u.], 
		// distance [/parsec] ): 
		String dataURL="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt";

		//Initialising ArrayList
		ArrayList<PlanetData> data = new ArrayList<PlanetData>();

	
		try{

			//storing the planet data in the ArrayList
			data=dataFromURL(dataURL);
			System.out.println("Data: "+data);			

			//Collections.sort(samples);	


			//This comparator method is used for sorting out array list for distance in ascending order to get the closest planet to Earth
			Collections.sort(data, new Comparator<PlanetData>() {
				@Override
				public int compare(PlanetData c1, PlanetData c2) {
					return Double.compare(c1.getDistance(), c2.getDistance());
				}
			});

		}
		catch (IOException e){
			System.out.println("An error has occured: " +e.getMessage());
		}

		finally{

			System.out.println("Tasks to analyse Exoplanets Data have been succesfully executed!");

		}
		

	System.out.println("The planet closest to Earth is= "+data.get(0).getName()+ ", mass= "+data.get(0).getMass()+" year discovered= "+data.get(0).getYear());
	

		
	}


	// This method retrieves the data from the webpage, and outputs and an ArrayList<PlanetData>
	static ArrayList<PlanetData> dataFromURL(String someURL) throws MalformedURLException, IOException{
		ArrayList<PlanetData> arrayList=new ArrayList<PlanetData>(); 
		URL u=new URL(someURL);
		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//Using a scanner to conveniently look through the data
		Scanner s=new Scanner(br);
		s.useDelimiter(",");

		s.nextLine();

		s.useDelimiter(",");

		while(s.hasNextLine()) try{
			double distance=0; //extending variable scope 

			String name = s.next();
			Integer year = s.nextInt();
			String method =s.next();
			Double mass = s.nextDouble();
			Double separation = s.nextDouble();
			// IOException to handle if no distance is provided:
			try{
				distance = s.nextDouble();
				System.out.println("distance="+distance);
			}
			catch (Exception e)
			{
				break;	
			}

			arrayList.add(new PlanetData(name, year, method, mass, separation, distance));
			s.close();

		}	
		finally{
		}


		//s.close();
		return arrayList;
	}



}


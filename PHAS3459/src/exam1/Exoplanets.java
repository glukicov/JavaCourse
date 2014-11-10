package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import example_1.Particle;

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
		String dataURL=("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt");

		//Initialising ArrayList
		ArrayList<PlanetData> data = new ArrayList<PlanetData>();

		//Initialising variables:
		//double minMass=Double.MAX_VALUE;
		//double maxMass=Double.MIN_VALUE;
		//int minID=0;
		//int maxID=0;

		try{

			//storing the planet data in the ArrayList
			data=dataFromURL(dataURL);
			System.out.println("Data: "+data);			

			//Collections.sort(samples);	


			//This method works for sorting out array list for doubles (mass) 
			/*	Collections.sort(samples, new Comparator<Samples>() {
			    @Override
			    public int compare(Samples c1, Samples c2) {
			        return Double.compare(c1.getMass(), c2.getMass());
			    }
			});*/








		}
		catch (IOException e){
			System.out.println("An error has occured: " +e.getMessage());
		}

		finally{

			//ADD SOMETHING 

		}
		/*System.out.println("Samples: "+samples.toString()+"\n");
	System.out.println("Locations: "+locations+"\n");



	System.out.println("Samples after sorting: "+samples.toString()+"\n");
	//System.out.println("Samples after sorting: "+samples+"\n");

	System.out.println("The length of array"+ samples.size());		
	System.out.println("The lightest element:" +samples.get(0).getMass());	
	Object lightest=samples.get(0);
//	System.out.println("The lightest mass:"+lightest.);

	int maxID=samples.get(528).getCode();
	int minID=samples.get(0).getCode();*/

		// /g, location="+locations.get(maxID)+"\n"
		//  /g, location="+locations.get(minID)+"\n"


		//Implementing search though locations list array to find a specific location


		/*
	 int x = maxID;
	 System.out.println("x"+x);
	 int index2=locations.indexOf(x);
	 System.out.println("index 2=" +index2);
	// int index=Collections.binarySearch(locations, x);

	   int liVal = -1;
	   for(int i=0; i<locations.size();i++)
	       if(x < locations.get(i).getCode()) // if we met a value > x
	       {
	          if(liVal==-1) // if we could not find any largest value smaller than x
	              liVal = locations.get(i).getCode(); // return the value > x
	          break;
	       }
	       else if(x > locations.get(i).getCode()) // find the largest value smaller than x, 
	       {
	           if(liVal < locations.get(i).getCode())
	               liVal = locations.get(i).getCode();
	       }

	System.out.println(liVal);*/











		/*System.out.println("Largest mass of a sample: ID= "+samples.get(528).getCode()+ ", mass= "+samples.get(528).getMass());
	System.out.println("Smallest mass of a sample: ID= "+samples.get(0).getCode()+ ", mass= "+samples.get(0).getMass());

		 */









		//	int index = locations.indexOf(28);
		//	System.out.println("index="+index);

		//TO-DO later: Combining Hashmas into 1 with 3 objects is it possible
		//or use other collection like:
		/*		HashMap<Integer, Double, String>combined = new HashMap();
		combined.putAll(samples);
		combined.putAll(locations)
		 */

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

		while (s.hasNextLine()){
			//Definition of data handling:
			// Ignoring first line
			String firstLine=s.nextLine();
			// New scanner to look through data
			Scanner scann=new Scanner(firstLine);
			
			//Looping over each line:
			for (int i=0; i<events; i++){
				String dataLine=scann.nextLine();
				Scanner datascann=new Scanner(dataLine);

				String name = datascann.next("[a-zA-Z]*");
				Integer year = Integer.parseInt(datascann.next());
				String method = datascann.next("[a-zA-Z]*");
				Double mass = Double.parseDouble(datascann.next());
				Double separation = Double.parseDouble(datascann.next());
				Double distance = Double.parseDouble(datascann.next());
				
				arrayList.add(new PlanetData(name, year, method, mass, separation, distance));
			}

		}
		/*while(s.hasNext()){
			String location =s.next("[a-zA-Z]*") ;
			arrayList.add(new PlanetData(location, 
					s.nextInt()));
		}
		 */



		//Closing scanner explicitly to flush all data
		s.close();
		return arrayList;
	}

}


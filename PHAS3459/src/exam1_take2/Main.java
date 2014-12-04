package exam1_take2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;


/** Main class for displaying results of the survey: 
 * <p>
 *  Read the data from survey-plants.txt and species-plants.txt and store it in one or more
 *   appropriate data structures.
 * <p>
 *  
 *
 * @author Gleb
 * @version 1.3 (17/11/14)
 * @
 * */

public class Main {
	//Stroing URL variables 
	private static final String url ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt";

	public static void main(String[] args) {        
		try {
			//Creating an instance of this class, which implements interface, to use its non-static methods
			//for data analysis (see Methods.java for the definitions of the methods used)
			Methods method = new Methods();

			//Storing data in appropriate collection objects
			ArrayList<DataFormatDistance> planetsWithDistance = method.readPlanetsWithDistance(url);


			/**
			 * using a custom comparator to sort out the plantes by distance
			 */
			Collections.sort(planetsWithDistance, new Comparator<DataFormatDistance>() {
				@Override
				public int compare(DataFormatDistance c1, DataFormatDistance c2) {
					return Double.compare(c1.getDistance(), c2.getDistance());
				}
			});

			//The closest planet
			System.out.println("The closest planet: "+planetsWithDistance.get(0));

			//Storing data in appropriate collection objects
			ArrayList<DataFormat> planets = method.readPlanets(url);
			System.out.println("planets: "+planets);

			//Counting for discovery method 
			//store discovery methods in unique collection object
			HashSet<String> methods = new HashSet<String>();	
			for(DataFormat item : planets){
				String name = item.getMethod();
				methods.add(name);
			}




			//Now for each method create a temp collection object with planets
			//and print out its size, samllest year, full details of the lightest exoplnet
			ArrayList<DataFormat> arrayTiming = new ArrayList<DataFormat>();
		//	ArrayList<DataFormat> arrayRV = new ArrayList<DataFormat>();
		//	ArrayList<DataFormat> arrayMicrolensing = new ArrayList<DataFormat>();
		//	ArrayList<DataFormat> arrayTransit = new ArrayList<DataFormat>();
		//	ArrayList<DataFormat> arrayImaging = new ArrayList<DataFormat>();
			
			
			for(DataFormat item : planets){
			if (item.getMethod().equals("Timing")){
						arrayTiming.add(item);
					}
				}
		
			System.out.println("Number of planets: "+arrayTiming.size());
			
			/**
			 * using a custom comparator to sort out the plantes by year
			 */
			Collections.sort(arrayTiming, new Comparator<DataFormat>() {
				@Override
				public int compare(DataFormat c1, DataFormat c2) {
					return Integer.compare(c1.getYear(), c2.getYear());
				}
			});
			System.out.println("Earliest year a planet was disc."+arrayTiming.get(0).getYear());
			
			Collections.sort(arrayTiming, new Comparator<DataFormat>() {
				@Override
				public int compare(DataFormat c1, DataFormat c2) {
					return Double.compare(c1.getMass(), c2.getMass());
				}
			});
			System.out.println("Lightest planet was disc."+arrayTiming.get(0));


		} catch (IOException e) {
			System.out.println("Error has occured "+e.getMessage());
		}
	}



}



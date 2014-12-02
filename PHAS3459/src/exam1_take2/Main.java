package exam1_take2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import revision.Samples;

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
		//	planetsWithDistance.sort();
			
			
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
			System.out.println("The closest planet:"+planetsWithDistance.get(0));

			
			
			
		
		} catch (IOException e) {
			System.out.println("Error has occured "+e.getMessage());
		}
	}
	
	
	
}



package exam2013;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
	private static final String urlSurveyPlants =
			"http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt";
	private static final String urlSpeciesPlants =
			"http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt";
	private static final String urlSurveyAnimals =
			"http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-animals.txt";
	private static final String urlSpeciesAnimals =
			"http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt";


	public static void main(String[] args) {        
		try {
			//Creating an instance of this class, which implements interface, to use its non-static methods
			//for data analysis (see Methods.java for the definitions of the methods used)
			Methods method = new Methods();

			//Storing data in appropriate collection objects
			ArrayList<DataFormat> survey = method.readSurveyPlants(urlSurveyPlants);
			HashMap<String, String> species = method.readSpeciesPlants(urlSpeciesPlants);

			//Printing the scientific name along with the number of specimens found:

			//mean height -store means in a new mean HashMap with names
			Map<Double,String> means = new  TreeMap<Double,String> ();
			//Use Iterator to loop through collection elements
			for (Map.Entry<String, String>entry : species.entrySet()) {
				/**
				 * @param counter to count the number of species
				 * @param totalHeight to recored the total height
				 */
				int counter = 0;
				int totalHeight=0;
				String code = entry.getKey();
				String name = entry.getValue();
				System.out.println(name);
				for(DataFormat item : survey){
					//For each species record total number found and mean
					if(item.getCode().equalsIgnoreCase(code)){
						totalHeight=totalHeight+item.getHeight();
						counter++;
					}
				}
				///For each species print out total number found and mean
				System.out.println("Total number of species found= "+counter);
				double meanHeight=totalHeight/counter;
				System.out.println("Mean height of the species= "+meanHeight+" cm \n");
				//store these means into new object to work on later
				means.put(meanHeight, name);

			}

			//Now the first and last elements of TreeMap are smallest and largest by default
			double samllest = ((TreeMap<Double, String>) means).firstKey();
			double largest = ((TreeMap<Double, String>) means).lastKey();
			//Printing out the results
			System.out.println("Lowest mean height name" +means.get(samllest));
			System.out.println("Largest mean height name" +means.get(largest));

			//Stroing all plants of right latitude in array:			
			ArrayList<DataFormat> north = method.SelectNorthOfLatitude(survey, -30.0);

			// Now finding ket (code) of Urtica dioica
			String name="Urtica dioica";
			//using a custom method
			String Scode = method.getTheKey(species, name);

			//Storing the right species (of right latitude)
			ArrayList<DataFormat> rightSpecies = method.SelectSpecimen(north, Scode);
			//and finding mean
			double northsp = method.findMeanHeight(rightSpecies);
			System.out.format("Total of "+rightSpecies.size()+"fond north: \n");
			System.out.format("Mean height N = %.3f", northsp);
			System.out.format(" cm \n");

			//Same process for south latitudes
			ArrayList<DataFormat> south = method.SelectSouthOfLatitude(survey, -30.0);
			ArrayList<DataFormat> rightSSpecies = method.SelectSpecimen(south, Scode);
			double southsp = method.findMeanHeight(rightSSpecies);
			System.out.format("Total of "+rightSSpecies.size()+"fond south:\n");
			System.out.format("Mean height S = %.3f", southsp);
			System.out.format(" cm \n");

			// Distance selection
			// First select specimen of SC: 
			String name2="Solanum carolinense";
			//using a custom method
			String Scode2 = method.getTheKey(species, name2);
			ArrayList<DataFormat> sc = method.SelectSpecimen(survey, Scode2);
			//Now selecting by distance
			ArrayList<DataFormat> rightdist = method.SelectDistance(sc, -30.967, 75.430, 50);

			//Finding mean and printing results 
			double mean = method.findMeanHeight(rightdist);
			System.out.format("Mean height S = %.3f", mean);
			System.out.format(" cm \n");
			
			
			// Animals:
			ArrayList<DataFormat> surveyA = method.readSurveyPlants(urlSurveyAnimals);
			HashMap<String, String> speciesA = method.readSpeciesPlants(urlSpeciesAnimals);
		//	System.out.println(surveyA);
		//	System.out.println(speciesA);
			ArrayList<DataFormat> rightdistA = method.SelectDistance(surveyA, -30.967, 75.430, 100);
		//	System.out.println(rightdistA);
		
			//Prinintg out the scientific names of animals present (in rightdistA) i.e. within 100km
			Set<String> rightAnimals = new LinkedHashSet<String>();
			for(DataFormat item : rightdistA){
				//For each recored animal get their code
				//check if the code already been put
				rightAnimals.add(item.getCode());
				
			}
			
			System.out.println("Total number of species found within 100km of mountain= "+rightAnimals.size());
			System.out.println("Name of all animals found:");
			for(String item : rightAnimals){
			    String nameA=method.getTheValue(speciesA,item);
				System.out.println(nameA);							
			}
		
			
			
			
			
			
			
		} catch (IOException e) {
			System.out.println("Error has occured "+e.getMessage());
		}
	}
}



package exam2_2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/** A class that: 
 * Read the data from survey-plants.txt and species-plants.txt and store it in one or more
appropriate data structures.

 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * @
 * */

public class Main {
	//Stroing url variables
	private static final String urlSurveyPlants =
			"http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt";
	private static final String urlSpeciesPlants =
			"http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt";

	//Fining the scientific names of the species with the highest and lowest mean height.
	public static void main(String[] args) {        
		try {
			ArrayList<DataFormat> survey = readSurveyPlants(urlSurveyPlants);
			//System.out.println("survey: "+survey);

			HashMap<String, String> species = readSpeciesPlants(urlSpeciesPlants);
			//System.out.println("species: "+species);

			//print the scientific name along with the number of specimens found and
			//their mean height -store means in a mean HashMap with names
			Map<Double,String> means = new  TreeMap<Double,String> ();
			for (Map.Entry<String, String>entry : species.entrySet()) {
				int counter = 0;
				int totalHeight=0;
				String code = entry.getKey();
				String name = entry.getValue();
				System.out.println(name);
				//	System.out.println(code);
				for(DataFormat item : survey){

					if(item.getCode().equalsIgnoreCase(code)){
						totalHeight=totalHeight+item.getHeight();
						//System.out.println(item.getHeight());
						counter++;
					}
				}

				System.out.println("Total number of species found= "+counter);
				double meanHeight=totalHeight/counter;
				System.out.println("Mean height of the species= "+meanHeight+" cm \n");

				means.put(meanHeight, name);

			}

			//Now the first and last elements of TreeMap are samllest and largest by default

			double samllest = ((TreeMap<Double, String>) means).firstKey();
			double largest = ((TreeMap<Double, String>) means).lastKey();

			System.out.println("Lowest mean height name" +means.get(samllest));
			System.out.println("Largest mean height name" +means.get(largest));

			// Creating an object select to use methods from that class
			// First selecting the right latitude (storing in north array)
			SelectMethods select = new SelectMethods();
			ArrayList<DataFormat> north = select.SelectNorthOfLatitude(survey, -30.0);
			// Now finding ket (code) of Urtica dioica
			String name="Urtica dioica";
			//using a custom method
			String Scode = getTheKey(species, name);
			//Stroing the right species 
			ArrayList<DataFormat> rightSpecies = select.SelectSpecimen(north, Scode);
			//System.out.println("rightSpecies= "+rightSpecies);
			double northsp = findMeanHeight(rightSpecies);
			System.out.format("Total of "+rightSpecies.size()+"fond north: \n");
			System.out.format("Mean height N = %.3f", northsp);
			System.out.format(" cm \n");

			ArrayList<DataFormat> south = select.SelectSouthOfLatitude(survey, -30.0);
			ArrayList<DataFormat> rightSSpecies = select.SelectSpecimen(south, Scode);
			double southsp = findMeanHeight(rightSSpecies);
			System.out.format("Total of "+rightSSpecies.size()+"fond south:\n");
			System.out.format("Mean height S = %.3f", southsp);
			System.out.format(" cm \n");
			
			// Distance selection
			// First select specimen of SC: 
			String name2="Solanum carolinense";
			//using a custom method
			String Scode2 = getTheKey(species, name2);
			ArrayList<DataFormat> sc = select.SelectSpecimen(survey, Scode2);
		    //System.out.println("Right plans="+sc);
			ArrayList<DataFormat> rightdist = select.SelectDistance(sc, -30.967, 75.430, 50);
			// System.out.println("Right distance ="+rightdist);
			
			double mean = findMeanHeight(rightdist);
			System.out.format("Mean height S = %.3f", mean);
			System.out.format(" cm");

		} catch (IOException e) {
			System.out.println("Error has occured "+e.getMessage());
		}
	}



	/**
	 * A method....  
	 * @param url
	 * @return data
	 * @throws IOException
	 */
	private static ArrayList<DataFormat>  readSurveyPlants(String url) throws IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<DataFormat> data = new  ArrayList<DataFormat>();
		String line;
		while ((line = br.readLine()) != null) {
			Scanner scanner = new Scanner(line);
			double latitude=scanner.nextDouble();
			double longitude=scanner.nextDouble();
			String code=scanner.next();
			int height=scanner.nextInt();
			data.add(new DataFormat(latitude,longitude,code,height));
			scanner.close();
		}
		return data;
	}

	/**
	 * 
	 * @param url
	 * @return names
	 * @throws IOException
	 */
	private static HashMap<String, String> readSpeciesPlants(String url) throws IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		HashMap<String, String> names = new HashMap<String, String>();
		String line;
		while ((line = br.readLine()) != null) {
			Scanner scanner = new Scanner(line);
			String code = scanner.next().trim();
			String name = scanner.nextLine().trim();
			names.put(code, name);
			scanner.close();
		}
		return names;
	}
	/**
	 * A method returning the key based on the specieman name 
	 * @param map
	 * @param name
	 * @return
	 */
	static String getTheKey(HashMap<String,String> map, String name){
		String theKey=null;
		for (Map.Entry<String, String>entry : map.entrySet()) {

			String code = entry.getKey();
			String Sname = entry.getValue();
			if ((Sname).equals(name)){
				theKey=code;
			}

		}
		return theKey;
	}

	/**
	 * A method...
	 * @param data
	 * @return
	 */
	static double findMeanHeight(ArrayList<DataFormat> data){
		double totalHeight=0;
		int counter=0;
		for(DataFormat item : data){
			totalHeight=totalHeight+item.getHeight();
			counter++;
		}
		return totalHeight/counter;
	}
	
	
	



}

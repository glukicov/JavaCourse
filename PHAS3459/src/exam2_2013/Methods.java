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
	public ArrayList<DataFormat> readSurveyPlants(String url) throws IOException {
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
			
			//If no 4th column move on...
			int height = 0;
            if (scanner.hasNext()) {
                height = Integer.parseInt(scanner.next());
            }
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
	public HashMap<String, String> readSpeciesPlants(String url) throws IOException {
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
	public String getTheKey(HashMap<String,String> map, String name){
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
	 * A method returning the value based on the key 
	 * @param map
	 * @param key
	 * @return
	 */
	public String getTheValue(HashMap<String,String> map, String key){
		String theValue=null;
		for (Map.Entry<String, String>entry : map.entrySet()) {

			String code = entry.getKey();
			String Sname = entry.getValue();
			if ((code).equals(key)){
				theValue=Sname;
			}
		}
		return theValue;
	}
	
	
	/**
	 * A method...
	 * @param data
	 * @return
	 */
	public double findMeanHeight(ArrayList<DataFormat> data){
		double totalHeight=0;
		int counter=0;
		for(DataFormat item : data){
			totalHeight=totalHeight+item.getHeight();
			counter++;
		}
		return totalHeight/counter;
	}
	
	
	
	

	final double r=6371; //in km 

	/**
	 * method...
	 */
	public ArrayList<DataFormat> SelectSouthOfLatitude(ArrayList<DataFormat> data, double latitude) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();

		// Loop over input data
		for (DataFormat specimen : data) {

			double specimenLatitude = specimen.getLatitude();
			// If it matches lat conditions, add to new array
			if (specimenLatitude >= latitude) {
				selected.add(specimen);
			}
		}

		return selected;
	}

	/**
	 * method...
	 */	
	public ArrayList<DataFormat> SelectNorthOfLatitude(ArrayList<DataFormat> data, double latitude) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();

		// Loop over input data
		for (DataFormat specimen : data) {

			double specimenLatitude = specimen.getLatitude();
			// If it matches lat conditions, add to new array
			if (specimenLatitude <= latitude) {
				selected.add(specimen);
			}

		}

		return selected;
	}


	/**
	 * method...
	 */
	public ArrayList<DataFormat> SelectSpecimen(ArrayList<DataFormat> data, String code) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();

		// Loop over input data
		for (DataFormat specimen : data) {

			String specimenCode = specimen.getCode();
			// If it code matches store the specimen
			if (specimenCode.equals(code)) {
				selected.add(specimen);
			}

		}

		return selected;
	}


	public double Haversine(double x){
	//	double hav=(1-Math.cos(radAngle2-radAngle1))/2;
	//	double hav=1/2*(1-Math.cos(radAngle2-radAngle1));
		  return 0.5*(1-Math.cos(x));
	//	System.out.println("hav=" +hav);
		//return hav;
	}

	/**
	 * method...
	 */
	public ArrayList<DataFormat> SelectDistance(ArrayList<DataFormat> data, double distance, double latitude, double longitude) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();
		//Those are constants:
		double radLatitude=Math.toRadians(latitude);
		//System.out.println("radLatitude= "+radLatitude);
		double radLongitude=Math.toRadians(longitude);
		//System.out.println("radLongitude= "+radLongitude);
		//System.out.println("r= "+r);
		// Loop over input data
		for (DataFormat specimen : data) {

			double specimenRadLatitude = Math.toRadians(specimen.getLatitude());
			//System.out.println("specimenRadLatitude= "+specimenRadLatitude);
			double specimenRadLongitude = Math.toRadians(specimen.getLongitude());
			//System.out.println("specimenRadLongitude= "+specimenRadLongitude);
			// If within given distance (in km!) - store it

			double h=Haversine(radLatitude - specimenRadLatitude)+((Math.cos(specimenRadLatitude))*(Math.cos(radLatitude))*(Haversine(radLongitude - specimenRadLongitude)));
			//System.out.println("h="+h);
			double d=2*r*Math.asin(Math.sqrt(h)); //h in radians
			//System.out.println("d=" +d);
			boolean test = d >= distance ;
			//System.out.println("test=" +test);
			if (test) {
				selected.add(specimen);
			}

		}

		return selected;
	}




}

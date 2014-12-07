package exam2011;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/** Main class for displaying the results:
 *
 * 
 * <p>
 *  
 * <p>
 *  
 * <p>
 *
 *
 * @author Gleb
 * @version 1.3 (17/11/14)
 * @
 * */
public class Main {

	//Storing URL variable
	private static final String urlReadings ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/readings.txt";
	private static final String urlStations ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/stations.txt";
	private static final String urlCountries ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/countries.txt";

	//Initialisin' bloody counter variables 
	

	public static void main(String[] args) {

		try {
			//Creating an instance of Methods class, which implements an interface (Interface) 
			//to use its non-static methods for data analysis and data input, etc. 
			// (see Methods.java for the definitions of the custom methods and functions used)
			Methods m = new Methods();

			//Storing the TMAX data only in the array list collection
			ArrayList<Readings> dataTMAX = m.readTMAXData(urlReadings);
			//	System.out.println("Data:");
			//	System.out.println(dataTMAX);
			//	System.out.println(dataTMAX.size());

			HashMap<String,String> countries =m.readNames(urlCountries);
			HashMap<String,String> stations = m.readNames(urlStations);

			//	System.out.println(countries+"\n");
			//	System.out.println(stations);
			//		System.out.println(countries.size());
			//	    System.out.println(stations.size());

			//Now we gonna devise a clever and painful method to extract the bloody Max T. value from
			// the bloody arrayList which has temperatures stored as a string
			// oh and, be ware of -9999!!!!
			// FFS
			// Should have done History of Art! 

			// Create an empty array to hold 669 max temp for each line
			ArrayList<Integer> maxTempdata = new ArrayList<Integer>();
			//For each line of dataTMAX
			for (Readings item: dataTMAX){
				//extract the data string
				String line=item.getData();
				//put into scanner
				Scanner scan = new Scanner(line);
				// new array list to old the numbers for line
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				while (scan.hasNextInt()) {
					numbers.add(scan.nextInt());
				}
				//Find the largest in array
				int maxTemp = Integer.MIN_VALUE;
				for (Integer number : numbers) {
					
					if (number > maxTemp && number != -9999) {
						maxTemp = number;
					}
					
				}
				maxTempdata.add(maxTemp);	
			}
			//Finding the ID (position) of the highest T element
			int maxID=0;
			//System.out.println(maxTempdata);
			//System.out.println(maxTempdata.size());
			int maxTemp = Integer.MIN_VALUE;
			for (int i=0;i<maxTempdata.size(); i++){
				if (maxTempdata.get(i) > maxTemp) {
					maxTemp = maxTempdata.get(i);
					maxID=i;
				}
				
			}
			//System.out.println(maxTemp);
			//System.out.println(maxID);
			//Fining other details 
			String code =dataTMAX.get(maxID).getCode();
			int year =dataTMAX.get(maxID).getYear();
			int monthID =dataTMAX.get(maxID).getMonth();
			String month = m.getMonth(monthID);
			String nameOfStation=stations.get(code);

			
			StringBuilder sb = new StringBuilder();
			String cCode;
			Scanner scan = new Scanner(code);
			
			scan.useDelimiter("(?<=.)");  
		//	while (scan.hasNext()){ 
			int countC=0;
			while (countC<2){
				countC=countC+1;
				String letter = scan.next();
				//System.out.println("character: [" + letter+ "]");  
			    sb.append(letter);
			}
			cCode = sb.toString();
			String nameOfCountry=countries.get(cCode);
			//System.out.println("cCode="+cCode);
			
			
			
			System.out.println("The highest temp recorded was "+maxTemp/10+".0 +/- 0.1 C");
			System.out.println("recored on "+ month +" of " +year);
			System.out.println("by"+nameOfStation);
			System.out.println("in "+nameOfCountry+"\n");
			

			// Fining the lowest mean
			
			ArrayList<Double> meansArray = new ArrayList<Double>();
			
			//For each line of dataTMAX
			for (Readings item: dataTMAX){
				int counterDay=0;
				double mean=0;
				double sum=0;
				//extract the data string
				String line=item.getData();
				//put into scanner
				Scanner scanner = new Scanner(line);
				// new array list to hold the numbers for line
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				
				while (scanner.hasNextInt()) {
					numbers.add(scanner.nextInt());
				}
				//Find the mean
				for (Integer number : numbers) {
					if (number !=-9999){
						sum=sum+number;
						counterDay=counterDay+1;
					}
					mean=sum/counterDay;
					
				}
				meansArray.add(mean);	
			}
		//	System.out.println(meansArray);
		//	System.out.println(meansArray.size());
			
			//Get the stations Array:
			ArrayList<String> stationCode = new ArrayList<String>();
			
			//Scan first two letters of each station to create station-code array
			for (Readings item : dataTMAX){
			String code2 = item.getCode();
			StringBuilder sbCO = new StringBuilder();
			Scanner scanCO = new Scanner(code2);
			scanCO.useDelimiter("(?<=.)");
			
			int countletter=0;
			while (countletter<2){
				countletter=countletter+1;
				String letter = scanCO.next();
				sbCO.append(letter);
			}
			cCode = sbCO.toString();
			stationCode.add(cCode);
			}
			
			
			//System.out.println(stationCode);
			
			//Now create a new array of unique countries:
			Set<String> rightCounties = new LinkedHashSet<String>();
			for(String item : stationCode){
				//For each recored animal get their code
				//check if the code already been put
				rightCounties.add(item);
				
			}
			
			
			//System.out.println(meansArray);
			//System.out.println(stationCode);
			
			//Combine the Country(code) - Means array into one to loop over the 
			// rightCounties (5 countries) to find the average for each country ..
			ArrayList<Means> countryMeans= new ArrayList<Means>();
					
			for (int i=0; i<meansArray.size();i++){
				String codeMean=stationCode.get(i);
				double meanMean=meansArray.get(i);
				countryMeans.get(i).setCode(codeMean);
				countryMeans.get(i).setMean(meanMean);
				}
			
			System.out.println(countryMeans);
			  
		//	while (scan.hasNext()){ 
			
			//System.out.println("cCode="+cCode);
			
			//////////////////

			/*int minID=0;			
			double minMean = Double.MIN_VALUE;
			for (int i=0;i<meansArray.size(); i++){
				if (meansArray.get(i) < minMean) {
					minMean = meansArray.get(i);
					minID=i;
				}
							
			}
			System.out.println(minMean);
			System.out.println(minID);
			*/
			
			
		/*	
			//Fining other details 
			String codeMIN =dataTMAX.get(minID).getCode();
			int yearMIN =dataTMAX.get(minID).getYear();
			int monthIDMIN =dataTMAX.get(minID).getMonth();
			String monthMIN = m.getMonth(monthIDMIN);
			String nameOfStationMIN=stations.get(codeMIN);

			
			StringBuilder sb2 = new StringBuilder();
			String cCode2;
			Scanner scan2 = new Scanner(code);
			
			scan.useDelimiter("(?<=.)");  
		//	while (scan.hasNext()){ 
			int countC2=0;
			while (countC2<2){
				countC2=countC2+1;
				String letter2 = scan.next();
				//System.out.println("character: [" + letter+ "]");  
			    sb.append(letter2);
			}
			cCode2 = sb.toString();
			String nameOfCountryMIN=countries.get(cCode2);
			//System.out.println("cCode="+cCode);
			
			
			
			System.out.println("The lowest mean was "+maxTemp/10+".0 +/- 0.1 C");
			System.out.println("recored on "+ month +" of " +year);
			System.out.println("by"+nameOfStation);
			System.out.println("in "+nameOfCountry+"\n");
			
	*/		
		} 

		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}

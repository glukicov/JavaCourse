package exam2006;

import java.io.IOException;
import java.util.ArrayList;

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
	private static final String url ="http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2006-07/final/hd_data.dat";
	private static final String urlB="http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2006-07/final/hd_bgd.dat";
	public static void main(String[] args) {

		try {
			//Creating an instance of Methods class, which implements an interface (Interface) 
			//to use its non-static methods for data analysis and data input, etc. 
			// (see Methods.java for the definitions of the custom methods and functions used)
			Methods m = new Methods();
			
			//Storing the data in the array list collection
			ArrayList<DataFormat> data = m.readData(url);
//			System.out.println(data.toString().replace(",", "").replace("[", "").replace("]", ""));
			
			ArrayList<BackgroundFormat> background=m.readBackground(urlB, data);
			System.out.println(background);
			
			/*
			//Using collection Iterator to loop though all items 
			for(DataFormat item : planets){
				if (item.getMethod().equals("Timing")){
							arrayTiming.add(item);
						}
					}
			*/
			
/*
			//Using a custom comparator to sort in acceding order the collection 
			// object by  
			Collections.sort(arrayTiming, new Comparator<DataFormat>() {
				@Override
				public int compare(DataFormat c1, DataFormat c2) {
					return Double.compare(c1.getMass(), c2.getMass());
				}
			});

*/


		} 
		
		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}

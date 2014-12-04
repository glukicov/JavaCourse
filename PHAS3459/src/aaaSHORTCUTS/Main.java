package aaaSHORTCUTS;

import java.io.IOException;

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
	private static final String url ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt";

	public static void main(String[] args) {

		try {
			//Creating an instance of Methods class, which implements an interface (Interface) 
			//to use its non-static methods for data analysis and data input, etc. 
			// (see Methods.java for the definitions of the custom methods and functions used)
			Methods m = new Methods();

			
			
/*
			//Using a custom comparator to sort out the collection object by 
			Collections.sort(arrayTiming, new Comparator<DataFormat>() {
				@Override
				public int compare(DataFormat c1, DataFormat c2) {
					return Double.compare(c1.getMass(), c2.getMass());
				}
			});

*/


		} 
		
//		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}

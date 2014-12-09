package exam2013_exam1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
	private static final String url ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/particles.txt";

	public static void main(String[] args) {

		try {
			//Creating an instance of Methods class, which implements an interface (Interface) 
			//to use its non-static methods for data analysis and data input, etc. 
			// (see Methods.java for the definitions of the custom methods and functions used)
			Methods m = new Methods();
			
			//Getting info on events only:
			ArrayList<Events> eventLines = m.readTriggers(url);
			
			//Finding the total number of unique triggers and their IDs
			Set<String> triggers = new LinkedHashSet<String>();
			for (Events item : eventLines){
				triggers.add(item.getTrigger());
			}
			System.out.println("Total of "+triggers.size()+" unique triggers:\n");
			System.out.println(triggers.toString().replace(",", "").replace("[", "").replace("]", "")+"\n");
			
			//Finding the total number of particles
			int totalParticles=0;
			for (Events item: eventLines){
				totalParticles=totalParticles+item.getTracks();
			}
			System.out.println("Total number of tracks detected: "+ totalParticles+"\n");
			
			//This array give the comibend data for each particle detected (its four vector + id of trigger, etc.)
			ArrayList<EventsParticles> events = m.readPairsEvents(url);
		//	System.out.println(events.toString().replace(",", "").replace("[", "").replace("]", ""));
			
			// Give the invariant mass of each pair
			ArrayList<EventsMass> mass =m.pairs(events);
			//System.out.println(mass);
		//	System.out.println(mass.size());
			
			//Combined ratio for each trigger (the method print out the total numbers using counters)
			m.ratio(mass, triggers);
			
			
			
			
			
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

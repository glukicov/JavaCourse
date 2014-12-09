package exam2013_exam1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Defining an interface to be used by the Main classes (to link non-static methods from the Methods class)
 *
 * 
 *    
 */
public interface Interface {

	// See Methods.java for methods and functions definitions
	
	
	public ArrayList<Events> readTriggers(String url) throws IOException;
	
	public ArrayList<EventsParticles> readPairsEvents(String url) throws IOException;
	
	public ArrayList<EventsMass> pairs(ArrayList<EventsParticles> data);
	
	public void ratio(ArrayList<EventsMass> data, Set<String> triggers);
		}


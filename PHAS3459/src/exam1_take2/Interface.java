package exam1_take2;

import java.io.IOException;
import java.util.ArrayList;

import exam2012.Higgs;

/**
 * Defining an interface to be used by the main classes (to link non-static methods from Methods class)
 */


public interface Interface {
	
	/**
     * See Methods.java for method definition
     */
	public ArrayList<DataFormatDistance> readPlanetsWithDistance(String url) throws IOException;
    
	public ArrayList<Higgs> readHiggs(String url) throws IOException;



}

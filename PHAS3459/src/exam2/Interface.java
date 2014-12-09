package exam2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Defining an interface to be used by the Main classes (to link non-static methods from the Methods class)
 *
 * 
 *  @version 1.3 (10/12/2014)
 */
public interface Interface {

	// See Methods.java for methods and functions definitions
	
	
	public ArrayList<DataFormat> readData(String url) throws IOException;

	
	
		}


package exam2010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Defining an interface to be used by the Main classes (to link non-static methods from the Methods class)
 *
 * 
 *    
 */
public interface Interface {

	// See Methods.java for methods and functions definitions
	
	
	public ArrayList<Readings> readTMAXData(String url) throws IOException;
	
	public HashMap<String,String> readNames(String url) throws IOException;

	public String getMonth(int month);
	
	public ArrayList<Integer> getYears(String url) throws IOException;
	
	
	
		}


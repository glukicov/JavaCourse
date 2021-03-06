package exam2012;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Defining an interface to be used by the Main classes (to link non-static methods from the Methods class)
 *
 * 
 *    
 */
public interface Interface {

	// See Methods.java for methods and functions definitions
	
	
	public ArrayList<Background> readBackground(String url) throws IOException;

	public double logL(ArrayList<Background> y,ArrayList<Background> n);
	
	public ArrayList<Background> retrunHiggsEvents(int signals, int normalisation, int width, ArrayList<Background> bins);
	
	public double logLMIN(ArrayList<Background> y,ArrayList<Background> n);
	
	public int logLID(ArrayList<Background> y,ArrayList<Background> n);
	
		}


package exam2011;

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
	
	
	public ArrayList<AB> readAB(String url) throws IOException;
	
	public ArrayList<XYZ> readXYZ(String url) throws IOException;

	public ArrayList<Reg> readRegions(String url) throws IOException;
	
	public ArrayList<Pop> readPopulations(String url) throws IOException;
	
	public ArrayList<Result> poisson(ArrayList<AB> data, ArrayList<Pop> population, ArrayList<Reg> regions) throws IOException;
	
	public ArrayList<Result> poissonALLA(ArrayList<AB> data, ArrayList<Pop> population, ArrayList<Reg> regions) throws IOException;
	
	public double meanA(ArrayList<AB> data);
	
	public double meanB(ArrayList<AB> data);

	
	public double stdA(ArrayList<AB> data, double meanA);
	
	public double stdB(ArrayList<AB> data, double meanB);
	
	public double correlationAB(ArrayList<AB> data, double meanA, double meanB, double stdA, double stdB);

	public ArrayList<AB> filter (ArrayList<AB> data, double meanA);

	public ArrayList<String> select (ArrayList<AB> data, int number, ArrayList<Reg> regions);
}


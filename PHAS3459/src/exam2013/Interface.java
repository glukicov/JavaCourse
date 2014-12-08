package exam2013;

/**
 * Defining an interface to be used by the main classes (to link non-static methods from Methods class)
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Interface {
	
	/**
     * See Methods.java for method definition
     */
    public ArrayList<DataFormat> SelectNorthOfLatitude(ArrayList<DataFormat> data, double latitude);
    
    public ArrayList<DataFormat> SelectSouthOfLatitude(ArrayList<DataFormat> data, double latitude);

    public ArrayList<DataFormat> SelectSpecimen(ArrayList<DataFormat> data, String code);
    
    public double Haversine(double x);
    
    public ArrayList<DataFormat> SelectDistance(ArrayList<DataFormat> data, double distance, double latitude, double longitude);

    public ArrayList<DataFormat> readSurveyPlants(String url) throws IOException;
    
    public HashMap<String, String> readSpeciesPlants(String url) throws IOException;
    
    public String getTheKey(HashMap<String,String> map, String name);
    
    public double findMeanHeight(ArrayList<DataFormat> data);
    
    public String getTheValue(HashMap<String,String> map, String key);
    
    



}

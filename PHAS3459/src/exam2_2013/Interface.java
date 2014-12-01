package exam2_2013;

/**
 * Defining an interface to be used by other classes (to link methods from classes)
 */

import java.util.ArrayList;

public interface Interface {
	
	/**
     * Select N/S of Latitude
     */
    public ArrayList<DataFormat> SelectNorthOfLatitude(ArrayList<DataFormat> data, double latitude);
    
    public ArrayList<DataFormat> SelectSouthOfLatitude(ArrayList<DataFormat> data, double latitude);

    public ArrayList<DataFormat> SelectSpecimen(ArrayList<DataFormat> data, String code);
    
    public double Haversine(double x);
    
    public ArrayList<DataFormat> SelectDistance(ArrayList<DataFormat> data, double distance, double latitude, double longitude);
}

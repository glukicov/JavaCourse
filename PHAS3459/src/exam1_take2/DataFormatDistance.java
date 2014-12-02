package exam1_take2;


/** This class stores the data in appropriate format to be used by a collection object in Main
 * FOR PLANETS WITH DISTANCE 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * @
 * */
public class DataFormatDistance extends DataFormat {

	//Initialising variables
	private double distance; 


	/**
	 * // Construct data point for PLANETS WITH DISTANCE 
	 * @param latitude
	 * @param longitude
	 * @param code
	 * @param height
	 */
	public DataFormatDistance(String name, int year, String method, double mass, double separation, double distance){
		super(name, year, method, mass, separation); this.distance=distance;
	}
	//Getter methods

	public double getDistance() {
		return this.distance;
	}

	//Method to output values as a string
	public String toString() {
		return super.toString() + " distance="+this.distance+"\n";
	}

	
}


package exam2011;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class Cap {

	//Initialising variables
	private String code; 
	private double population; 
			
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public Cap(String code, double population){
				 this.code=code; this.population=population;
		    }
				 
			//Getter methods
			public String getCode() {
				return this.code;
			}
			public double getPopulation() {
				return this.population;
			}
			
			
			
		  //Method to output values as a string
			public String toString() {
				return "Code: "+this.code+", population: "+this.population+"\n";
			}
	
}

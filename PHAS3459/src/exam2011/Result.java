package exam2011;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class Result {

	//Initialising variables
			private String code; 
			private double x; 
			private double y; 
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public Result(String code, double x, double y){
				 this.code=code; this.x=x; this.y=y;
			}
			//Getter methods
			public String getCode() {
				return this.code;
			}
			public double getX() {
				return this.x;
			}
			public double getY() {
				return this.y;
			}
			
			
		  //Method to output values as a string
			public String toString() {
				return "Name of the region: "+this.code+", Number of occurences: "+this.x+", Stat sig.: "+this.y+"\n";
			}
	
}

package exam2008;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class DataFormat {

	//Initialising variables
			private String name; 
			private double x;
			private double y; 
			private double z; 
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public DataFormat(String name, double x, double y, double z){
		    	this.name=name; this.x=x; this.y=y; this.z=z;
			}
			/// Return particle position (Getter methods)
			double getX() {
				return this.x;
			}
			
			double getY() {
				return this.y;
			}
			
			double getZ() {
				return this.z;
			}
			
			String getName() {
				return this.name;
			}

			
		
			 //Method to output values as a string
			@Override
			public String toString() {
				return (""+this.x+" "+this.y+" "+this.z+" "+this.name+"\r\n");
			}
}
package exam2008;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class RMS {

	//Initialising variables
			private String name; 
			private double rms; 
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public RMS(String name, double rms){
		    	this.name=name; this.rms=rms;
		    	}
			/// Return particle position (Getter methods)
			double getRMS() {
				return this.rms;
			}
			
			String getName() {
				return this.name;
			}
			
			void setRMS(double value) {
				this.rms=value;
			}
			
			void setName(String value) {
				this.name=value;
			}

			
		
			 //Method to output values as a string
			@Override
			public String toString() {
				return (""+this.rms+" "+this.name+"\r\n");
			}
}
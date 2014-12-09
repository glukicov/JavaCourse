package exam2006;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class BackgroundFormat extends DataFormat{

	//Initialising variables
		
			private double pnSig;
		

			
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public BackgroundFormat(String name, double startTime, double dt, double pn, double mean, double pnSig){
				 super(name, startTime, dt, pn, mean); this.pnSig=pnSig;
			}
			//Getter methods
			public double getPnSig() {
				return this.pnSig;
			}
		    

			
		  //Method to output values as a string
			public String toString() {
				return super.toString()+"pnSig"+this.pnSig+"\n";
			}
	
}

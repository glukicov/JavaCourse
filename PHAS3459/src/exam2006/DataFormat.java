package exam2006;

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
			private double startTime; 
			private double dt; 
			private double pn;
			private double mean; 

			
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public DataFormat(String name, double startTime, double dt, double pn, double mean){
				 this.name=name; this.startTime=startTime; this.dt=dt; this.pn=pn; this.mean=mean;
			}
			//Getter methods
			public String getName() {
				return this.name;
			}
			public double getStartTime() {
				return this.startTime;
			}
			public double getDt() {
				return this.dt;
			}
			
			public double getPn() {
				return this.pn;
			}
			public double getMean() {
				return this.mean;
			}
			
		  //Method to output values as a string
			public String toString() {
				return "Name: "+this.name+", startTime: "+this.startTime+", dt: "+this.dt+", pn "+this.pn+", mean "+this.mean+"\n";
			}
	
}

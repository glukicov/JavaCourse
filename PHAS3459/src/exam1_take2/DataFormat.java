package exam1_take2;

/** This class stores the data in appropriate format to be used by a collection object in Main
 * FOR PLANETS WITHOUT DISTANCE 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * @
 * */
public class DataFormat {

	//Initialising variables
		private String name; 
		private int year; 
		private String method; 
		private double mass; 
		private double separation; 
	
	    	    
	    /**
	     * // Construct data point for PLANETS WITHOUT DISTANCE 
	     * @param latitude
	     * @param longitude
	     * @param code
	     * @param height
	     */
	    public DataFormat(String name, int year, String method, double mass, double separation){
			 this.name=name; this.year=year; this.method=method; this.mass=mass; this.separation=separation;
		}
		//Getter methods
		public String getName() {
			return this.name;
		}
		public int getYear() {
			return this.year;
		}
		public String getMethod() {
			return this.method;
		}
		public double getMass() {
			return this.mass;
		}
		public double getSeparation() {
			return this.separation;
		}
		
	  //Method to output values as a string
		public String toString() {
			return "Name: "+this.name+", Discovered: "+this.year+", Method: "+this.method+", Mass "+this.mass+", Jup.Mass., Separation "+this.separation+"\n";
		}
	    
	}
	

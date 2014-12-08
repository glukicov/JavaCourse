package exam2011;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class Reg {

	//Initialising variables
	private String code; 
	private String name; 
			
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public Reg(String code, String name){
				 this.code=code; this.name=name;
		    }
				 
			//Getter methods
			public String getCode() {
				return this.code;
			}
			public String getName() {
				return this.name;
			}
			
			
			
		  //Method to output values as a string
			public String toString() {
				return "Code: "+this.code+", A: "+this.name+"\n";
			}
	
}

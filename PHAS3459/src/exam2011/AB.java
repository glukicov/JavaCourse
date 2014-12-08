package exam2011;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class AB {

	//Initialising variables
			private String code; 
			private int a; 
			private int b; 
		
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public AB(String code, int a, int b){
				 this.code=code; this.a=a; this.b=b;
			}
			//Getter methods
			public String getCode() {
				return this.code;
			}
			public int getA() {
				return this.a;
			}
			public int getB() {
				return this.b;
			}
			
			
		  //Method to output values as a string
			public String toString() {
				return "Code: "+this.code+", A: "+this.a+", B: "+this.b+"\n";
			}
	
}

package exam2011;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class XYZ {

	//Initialising variables
			private String code; 
			private int x; 
			private int y; 
			private int z;
		    	    
		    /**
		     * // Construct data point for PLANETS WITHOUT DISTANCE 
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public XYZ(String code, int x, int y, int z){
				 this.code=code; this.x=x; this.y=y; this.z=z;
			}
			//Getter methods
			public String getCode() {
				return this.code;
			}
			public int getX() {
				return this.x;
			}
			public int getY() {
				return this.y;
			}
			public int getZ() {
				return this.z;
			}			
			
		  //Method to output values as a string
			public String toString() {
				return "Code: "+this.code+", X: "+this.x+", Y: "+this.y+" Z: "+this.z+"\n";
			}
	
}

package exam2011;

/** This class stores the READINGS.txt data in appropriate format to be used by a collection objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class Readings {

	//Initialising variables
			private String code; 
			private int year; 
			private int month; 
			private String type; 
			private String data; //consists of 31 data points to be extracted later
		
		    	    
		    /**
		     * // Construct data point for readings
		     * @param latitude
		     * @param longitude
		     * @param code
		     * @param height
		     */
		    public Readings(String code, int year, int month, String type, String data){
				 this.code=code; this.year=year; this.month=month; this.type=type; this.data=data;
			}
			//Getter methods
			public String getCode() {
				return this.code;
			}
			public int getYear() {
				return this.year;
			}
			public int getMonth() {
				return this.month;
			}
			public String getType() {
				return this.type;
			}
			public String getData() {
				return this.data;
			}
			
		  //Method to output values as a string
			public String toString() {
				return "code: "+this.code+", year: "+this.year+", month: "+this.month+", type "+this.type+", Data: "+this.data+"\n";
			}
	
}

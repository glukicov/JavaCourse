package exam2013;

/** This class stores the data in appropriate format to be used by a collection object in Main
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * @
 * */
public class DataFormat {

	    private double latitude;
	    private double longitude;
	    private String code;
	    private int height=0;

	    
	    //Example of Overloading:
	   /**
	    * Construct data point for animals 
	    * @param latitude
	    * @param longitude
	    * @param code
	    */
	    public DataFormat(double latitude, double longitude, String code) {
	        this.latitude = latitude;
	        this.longitude = longitude;
	        this.code=code;
	        }
	    
	    /**
	     * // Construct data point for plants
	     * @param latitude
	     * @param longitude
	     * @param code
	     * @param height
	     */
	    public DataFormat(double latitude, double longitude, String code, int height) {
	        this.latitude = latitude;
	        this.longitude = longitude;
	        this.code=code;
	        this.height = height;
	    }

	    // Returns x value of point
	    public double getLatitude() {
	        return latitude;
	    }

	    // Returns y value of point
	    public double getLongitude() {
	        return longitude;
	    }
	    
	    // Returns y value of point
	    public String getCode() {
	        return code;
	    }

	    // Returns error on y
	    public int getHeight() {
	        return height;
	    }
	  //Method to output values as a string
		public String toString() 
		{
			if (this.height != 0) {
			return "latitude= "+this.latitude+" longitude= "+this.longitude+" code="+this.code+" height="+this.height+"\n";
		
			}
			return "latitude= "+this.latitude+" longitude= "+this.longitude+" code="+this.code+"\n";
		}
	    
	}
	

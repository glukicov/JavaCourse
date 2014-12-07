package exam2011;

public class Means{

	//Initialising variables
	private String code; 
	private double mean;//consists of 31 data points to be extracted later

    	    
    /**
     * // Construct data point for readings
     * @param latitude
     * @param longitude
     * @param code
     * @param height
     */
    public Means(String code, double mean){
		 this.code=code; this.mean=mean;
	}
	//Getter methods
	public String getCode() {
		return this.code;
	}
	public double getMean() {
		return this.mean;
	}
	
	//Setter methods
		public void setCode(String value1) {
			this.code=value1;
		}
		public void setMean(double value2) {
			this.mean=value2;
		}
		
  //Method to output values as a string
	public String toString() {
		return "code: "+this.code+", mean: "+this.mean+"\n";
	}
	
}

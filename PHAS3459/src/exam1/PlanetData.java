package exam1;

//This class defines our data type handling to be used in the array list 

public class PlanetData {

	//Initialising variables
	private String name; 
	private int year; 
	private String method; 
	private double mass; 
	private double separation; 
	private double distance;

	//Method for setting the values:
	public PlanetData(String name, int year, String method, double mass, double separation, double distance){
		 this.name=name; this.year=year; this.method=method; this.mass=mass; this.separation=separation;this.distance=distance;
	}
	//Getter methods
	public String getLocation() {
		return this.location;
	}
	public int getCode() {
		return this.code;
	
	}
	//Method to output values as a string
		public String toString() {
			return "("+this.location+", "+this.code+")";
		}

}


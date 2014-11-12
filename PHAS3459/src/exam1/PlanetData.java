package exam1;

//This class defines our data type handling to be used in the array list 
//Using comparable implementation to create a custom sort for the ListArray

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
	public double getDistance() {
		return this.distance;
	}
	
	//Method to output values as a string
		public String toString() {
			return "("+this.name+", "+this.year+", "+this.method+", "+this.mass+", "+this.separation+", "+this.distance+",)";
		}

}


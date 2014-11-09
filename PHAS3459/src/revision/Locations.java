package revision;

//This class defines our data type to be used in the array list 

public class Locations {

	private String location;
	private int code;

	public Locations(String location, int code){
		this.location=location; this.code=code;
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


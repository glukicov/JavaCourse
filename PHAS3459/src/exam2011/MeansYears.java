package exam2011;

public class MeansYears extends Means {

	//Initialising variables
		private int year; 

	
	public MeansYears(String code, double mean, int year){
		super(code, mean); this.year=year;
	}
	//Getter methods
	public int getYear() {
		return this.year;
	}
	
		
 //Method to output values as a string
	public String toString() {
		return super.toString() + " year:"+this.year+"\n";
	}

}

package revision;

import java.util.Comparator;

//This class defines our data type to be used in the array list 
public class Samples implements Comparable<Samples> {

	private int code;
	private double mass;

	public Samples(int code, double mass){
		super();
		this.code=code; this.mass=mass;
	}
	//Getter methods
	public int getCode() {
		return this.code;
	}
	public double getMass() {
		return this.mass;
	}
	//Method to output values as a string
	public String toString() {
		return "("+this.code+", "+this.mass+")";
	}

	public static class OrderByAmount implements Comparator<Samples> {

		@Override
		public int compare(Samples o1, Samples o2) {
			return o1.mass > o2.mass ? 1 : (o1.mass < o2.mass ? -1 : 0);
		}
	}
}

// Overriding the compare method to sort the age 
//   public int compare(Samples d, Samples d1){
///     return d.code - d1.code;
//	   }

//@Override
//	public int compareTo(Samples compareSample) {

//		int compareCode = ((Samples) compareSample).getCode(); 

//ascending order
//		return this.code - compareCode;

//descending order
//return compareQuantity - this.quantity;

//	}


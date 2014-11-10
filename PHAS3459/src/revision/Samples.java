package revision;



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

	
	
							//This code works with Comparable for sorting by int (id)
	public int compareTo(Samples compareId) {
		int compareCode = ((Samples) compareId).getCode(); 

//ascending order
		return this.code - compareCode;
		}
	
	
		
	
/*	public static class OrderByAmount implements Comparator<Samples> {

		@Override
		public int compare(Samples o1, Samples o2) {
			return o1.mass > o2.mass ? 1 : (o1.mass < o2.mass ? -1 : 0);
		}
//	}
//}
*/
/*// Overriding the compare method to sort the age 
   public int compare(Samples d, Samples d1){
     return d.code - d1.code;
	   }
	   
	  

/*public double compare(Samples compareMass) {
	double compare = ((Samples) compareMass).getMass(); 

//ascending order
	return this.mass - compare;
	}*/


//descending order
//return compareQuantity - this.quantity;

	}


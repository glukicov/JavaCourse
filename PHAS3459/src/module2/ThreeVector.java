package module2;

/*This class: 1)defines the data needed to stores a 3-vector object (Cartesian coordinates) 
 				2) defines methods that can manipulate those vector objects 
 */

public class ThreeVector {

	//Initialising the variables (vector components) that only belong to this class
	private double x1;
	private double y1;
	private double z1;

	//Creating an empty constructor
	//public ThreeVector(){}

	//Constructor to define an object representing a three vector
	public ThreeVector(double x1, double y1, double z1){
		// Member variable initialisation
		this.x1=x1;
		this.y1=y1;
		this.z1=z1;
	}

	public double dotProduct (double x1, double y1, double z1, double x2, double y2, double z2){
		return x1*x2+y1*y2+z1*z2;
	
	public double magnitude (double x1, double y1, double z1){  // Defining function magnitude with double as return type and inputs as x, y and z
		return Math.sqrt(dotProduct(x1,y1,z1,x1,y1,z1));		// Defining the return of the function magnitude in terms of x, y an z 	



	}

/* This is Function/Methods assignment 
 * 
 * This script: 1) Calculates the magnitude of a vector with components x, y, z (as defined in the script)
 * 				2) Calculates the dotProduct of two vectors with components a1, a2, a3 and b1, b2, b3
 *				3) Calculates the angle of two vectors with components a1, a2, a3 and b1, b2, b3
 * */

package module1;

public class VectorMethods {

	public VectorMethods(){}						// Creating an empty constructor 

	public double magnitude (double x, double y, double z){  // Defining function magnitude with double as return type and inputs as x, y and z
		return Math.sqrt(x*x+y*y+z*z);		// Defining the return of the function magnitude in terms of x, y an z 								
	}

	public double dotProduct (double a1, double a2, double a3, double b1, double b2, double b3){
		return a1*b1+a2*b2+a3*b3;

		public double angle ((double a1, double a2, double a3, double b1, double b2, double b3){

		}
	}

	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods(); // Creating vm object of VectorMethods class 
		double x=4; 
		double y=7; 
		double z=3;

		double a1=6; 
		double a2=5; 
		double a3=1;
		double b1=2; 
		double b2=4; 
		double b3=3;


		double scalarProduct=vm.dotProduct(a1,a2,a3,b1,b2,b3);
		System.out.println("Scalar product of two vectors= "+scalarProduct+ " (With components: a1= "+a1+ " a2= "+a2+ " a3= "+a3+ " and " 
				+ "b1= " +b1+ " b2= "+b2+ " b3= "+b3+ ")");

		double mag = vm.magnitude(x,y,z); // Creating a double variable magnitude which calls the function "magnitude" and returns the magnitude
		// of a vector with components as variables x, y and z
		System.out.println("Vector Magnitude= "+mag+ " (With components: x= "+x+ " y= "+y+ " and z= "+z+")");

		double theta=vm.angle(a1,a2,a3,b1,b2,b3);
		System.out.println("The angle between two vectors= "+theta+ " (With components: x= "+x+ " y= "+y+ " and z= "+z+")");

	}

}

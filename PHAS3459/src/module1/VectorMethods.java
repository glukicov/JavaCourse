/* This is Function/Methods assignment. This script: 1) Calculates the magnitude of a vector with components x, y, z (as defined in the script)
2) Calculates the dotProduct of two vectors with components a1, a2, a3 and b1, b2, b3
3) Calculates the angle between two vectors with components a1, a2, a3 and b1, b2, b3
4) Investigates what happends when angle between a vector and 0 vector are calculated
 */
package module1;

public class VectorMethods {

	public VectorMethods(){}						// Creating an empty constructor 

	public double magnitude (double x1, double y1, double z1){  // Defining function magnitude with double as return type and inputs as x, y and z
		return Math.sqrt(dotProduct(x1,y1,z1,x1,y1,z1));		// Defining the return of the function magnitude in terms of x, y an z 								
	}

	public double dotProduct (double x1, double y1, double z1, double x2, double y2, double z2){
		return x1*x2+y1*y2+z1*z2;
	}
	public double angle (double x1, double y1, double z1, double x2, double y2, double z2){			//Creating angle function which uses the outputs of functions 
																									//dotProduct and magnitude
		return Math.toDegrees(Math.acos((dotProduct(x1,y1,z1,x2,y2,z2)/(magnitude(x1,y1,z1)*magnitude(x2,y2,z2)))));
	}


	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods(); // Creating vm object of VectorMethods class 
	
		double a1=6; 
		double a2=5; 
		double a3=1;
		double b1=2; 
		double b2=4; 
		double b3=3;


		double scalarProduct=vm.dotProduct(a1,a2,a3,b1,b2,b3);
		System.out.println("Scalar product of two vectors= "+scalarProduct+ " (With components: a1= "+a1+ " a2= "+a2+ " a3= "+a3+ " and " 
				+ "b1= " +b1+ " b2= "+b2+ " b3= "+b3+ ")");
		System.out.println(""); // Empty print out statement to improve to readability on console output

		double mag = vm.magnitude(a1,a2,a3); // Creating a double variable magnitude which calls the function "magnitude" and returns the magnitude
										// of a vector with components as variables a1, a2 and a3
		System.out.println("Vector Magnitude= "+mag+ " (With components: a1= "+a1+ " a2= "+a2+ " a3= "+a3+ " )");
		System.out.println("");
		double theta=vm.angle(a1,a2,a3,b1,b2,b3);  //Passing on the values a1, a2...as defined above to the angle function
		System.out.println("The angle between two vectors= "+theta+ " (degrees) (With components: a1= "+a1+ " a2= "+a2+ " a3= "+a3+ " and " 
				+ "b1= " +b1+ " b2= "+b2+ " b3= "+b3+ ")");
		System.out.println("The result is as expected: a number in degrees which indicates the angle between the two vectors");
		System.out.println("");
		double c1=0;
		double c2=0;
		double c3=0;		
		
		double theta2=vm.angle(a1,a2,a3,c1,c2,c3);  //Now calcualting the scalar product with 0 vector..
		System.out.println("The angle between two vectors= "+theta2+ " (With components: a1= "+a1+ " a2= "+a2+ " a3= "+a3+ " and " 
				+ "c1= " +c1+ " c2= "+c2+ " c3= "+c3+ ")");
		System.out.println("The result is NOT as expected: scalar prodcut with zero vector gives NaN (Not a number) output, because of the  divison by 0.0 which is arithmetically undefined (!):");
		double mag2 = vm.magnitude(c1,c2,c3); // Creating a double variable magnitude which calls the function "magnitude" and returns the magnitude
		System.out.println("Magnitude of 'zero' vector ="+mag2);
		double scalarProduct2=vm.dotProduct(a1,a2,a3,c1,c2,c3);
		System.out.println("Dot product with 'zero' vector ="+scalarProduct2);
		System.out.println("And the input of the angle fucntions takes the following undefined input 0.0/0.0 (!)");
		double theta3=Math.toDegrees(Math.acos(0.0/0.0));
		System.out.println("The output= "+theta3);
		System.out.println("However, IF the INTEGER was used for components of vector (int), then the devison woud look like 0/0 - whcih is NOT allowed (different than NaN) (!)");
		// double theta4=Math.toDegrees(Math.acos(0/0)); The integer input, however triggers the explicit division by zero error (!)
		
		}

}

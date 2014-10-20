package module3;

/*This class: 1)defines the data needed to stores a 3-vector object (Cartesian coordinates) 
 				2) defines methods that can manipulate those vector objects. 
 */

public class ThreeVector {

	//Initialising the (instance) variables (vector components) that only belong to this class
	private double x;
	private double y;
	private double z;

	//Creating an empty constructor is not necessary in our case!
	//public ThreeVector(){}

	//Constructor to define an object representing a three vector
	public ThreeVector(double x, double y, double z){
		//the instance variable x1 (on the left) of this object gets assigned the value 
		//of the local variable x1(the one passed into the constructor)
		this.x=x;   
		this.y=y;
		this.z=z;
	}

	/* Methods that are declared as public can be accessed from outside this class
	 static methods belongs to the class and not an instance of that class(object of the class)
	 non-static methods require an object
	 */

	// Converting object (vector) to a string for print out
	public  String toString() { 
		return "(" +x+ "," +y+ "," +z+ ")";
	}

	// Defining the input of function magnitude with double as return type
	double magnitude (){  
		// Defining the return of the function 
		return Math.sqrt(x*x+y*y+z*z);
	}

	//Creating a unit vector method
	ThreeVector unitVector(){
		double unit_x=x/magnitude();
		double unit_y=y/magnitude();
		double unit_z=z/magnitude();
		return new ThreeVector(unit_x,unit_y,unit_z);
	}

	// Scalar Product between two vector objects(A, B)
	static double scalarProduct (ThreeVector A, ThreeVector B){
		return A.x*B.x+A.y*B.y+A.z*B.z;
	}

	// Vector Product methods with return type as ThreeVector object
	static ThreeVector vectorProduct (ThreeVector A, ThreeVector B){
		double i=(A.y*B.z)-(B.y*A.z);
		double j=(A.z*B.x)-(B.z*A.x);
		double k=(A.x*B.y)-(B.x*A.y);
		return new ThreeVector(i,j,k);
	}
	//Adding two vectors
	static ThreeVector add (ThreeVector A, ThreeVector B){
		return new ThreeVector(A.x+B.x,A.y+B.y,A.z+B.z);
	}

	//Getting angle (in rad) between two vectors through scalar product
	static double angle (ThreeVector A, ThreeVector B){
		double scalar_product=scalarProduct(A,B);
		double magnitude=A.magnitude()*B.magnitude();
		return Math.acos(scalar_product/magnitude);
	}

	//Non static (require object) versions of above methods:
	// We can even assign the same name to the non-static methods as static ones ! (overloading)

	double scalarProduct(ThreeVector B){
		return ThreeVector.scalarProduct(this, B);
	}

	ThreeVector vectorProduct(ThreeVector B){
		return ThreeVector.vectorProduct(this, B);
	}

	ThreeVector add(ThreeVector B){
		return ThreeVector.add(this, B);
	}

	double angle(ThreeVector B){
		return angle(this, B);
	}



}

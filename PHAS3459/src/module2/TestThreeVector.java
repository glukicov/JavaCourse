package module2;

/* This class will test ThreeVector class by calling on the constructor
 * of ThreeVector class to create a new instance of that class, which
 * will initialise the new object.
 */
public class TestThreeVector {
	//Test

	public static void main(String[] args) {
		//Creating v1,v2,v3 objects by declaring that they belong to
		//the ThreeVector class, instantiating and then doing initialisation
		//on those objects by explicitly passing arguments in braces ()
		ThreeVector v1=new ThreeVector(3,4,1);
		ThreeVector v2=new ThreeVector(5,3,2);
		ThreeVector v3=new ThreeVector(0,0,0);

		//Printing vectors and unit vectors (by calling unitVector method 
		//on respective v1, v2, v3 object
		System.out.println("Working in Cartesian Coordinate System");
		System.out.println("v1= "+v1);
		System.out.println("Unit vector of v1= "+v1.unitVector());
		System.out.println("v2= "+v2);
		System.out.println("Unit vector of v2= "+v2.unitVector());
		System.out.println("v3= "+v3);
		System.out.println("Unit vector of v3= "+v3.unitVector());
		System.out.println("Unit vector of zero vector return Not a Number as expected: undefined input 0.0/0.0 (!)\n");

		//Printing dot product by calling dotProduct method from ThreeVector class on the objects
		System.out.println("v1.v2= "+ThreeVector.scalarProduct(v1,v2));
		System.out.println("v1.v3= "+ThreeVector.scalarProduct(v1,v3));
		System.out.println("v1xv2= "+ThreeVector.vectorProduct(v1,v2));
		System.out.println("v1xv3= "+ThreeVector.vectorProduct(v1,v3)+ "\n");

		//Printing angles in radians
		System.out.println("Angle between v1 and v2= "+ThreeVector.angle(v1,v2)+" /rad");
		System.out.println("Angle between v1 and v3= "+ThreeVector.angle(v1,v3));
		System.out.println("Angle between v1 and zero vector return Not a Number as expected...\n");

		// Leaving toString() method commented out:
		System.out.println("When toString() method is commented out, any print out result that involves ");
		System.out.println("an object has the following form: e.g. 'module2.ThreeVector@1461c98'. ");
		System.out.println("This is a default method to display the object's class name representation, then '@' followed by its hashcode (numbers).\n");


		// Testing the static version of add  method:
		System.out.println("v1+v2= "+ThreeVector.add(v1,v2)+"\n");

		System.out.println("Testing non-staic methods:");
		//// Testing the non-static version of scalarProduct  method:
		System.out.println("v1.v2= "+v1.scalarProduct(v2));

		// Testing the non-static version of vectorProduct  method:
		System.out.println("v1xv2= "+v1.vectorProduct(v2));

		// Testing the non-static version of angle  method:
		System.out.println("v1xv2= "+v1.angle(v2));

		// Testing the static version of add  method:
		System.out.println("v1+v2= "+v1.add(v2));
		System.out.println("Same results as above!");

	}
}

package module2;

/* This class will test ThreeVector class by calling on the constructor
 * of ThreeVector class to create a new instance of that class, which
 * will initialise the new object.
 */
public class TestThreeVector {

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
		System.out.println("Unit vector of v1= "+v1.unitVector()+"/n");
		System.out.println("v2= "+v2);
		System.out.println("Unit vector of v2= "+v2.unitVector()+"/n");
		System.out.println("v3= "+v3);
		System.out.println("Unit vector of v3= "+v3.unitVector()+"/n");
		
		//Printing dot product by calling dotProduct method on th
		System.out.println("v1.v2= "+v3.unitVector()+"/n")
		
	}
}

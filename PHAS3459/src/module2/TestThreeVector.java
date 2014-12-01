package module2;

public class TestThreeVector {

	public static void main(String[] args) {

		// Instantiate ThreeVector objects
		ThreeVector v1 = new ThreeVector(3,4,1);
		ThreeVector v2 = new ThreeVector(5,3,2);
		ThreeVector v3 = new ThreeVector(0,0,0);

		// Return values of each ThreeVector object (testing toString method)
		System.out.println("ThreeVector v1: "+v1);
		System.out.println("ThreeVector v2: "+v2);
		System.out.println("ThreeVector v3: "+v3);
		System.out.println();
		System.out.println("If a toString() method isn't defined, the memory location is printed rather than any useful information;");
		System.out.println("something that resembles module2.ThreeVector@1a2b3c4d");
		System.out.println();

		// Return magnitudes of each ThreeVector object
		System.out.println("Magnitude of ThreeVector v1: "+v1.magnitude());
		System.out.println("Magnitude of ThreeVector v2: "+v2.magnitude());
		System.out.println("Magnitude of ThreeVector v3: "+v3.magnitude());
		System.out.println();

		// Calculate unit vectors for each ThreeVector object
		System.out.println("ThreeVector v1 unit vector: "+v1.unitVector());
		System.out.println("ThreeVector v2 unit vector: "+v2.unitVector());
		System.out.println("ThreeVector v3 unit vector: "+v3.unitVector());
		System.out.println();

		// Calculate scalar products using static and non-static methods
		System.out.println("Scalar product v1.v2: "+ThreeVector.scalarProduct(v1, v2));
		System.out.println("Scalar product v1.v3: "+ThreeVector.scalarProduct(v1, v3));
		//System.out.println("Non-static scalar product v1.v2: "+v1.scalarProduct(v2));
		//System.out.println("Non-static scalar product v1.v3: "+v1.scalarProduct(v3));
		System.out.println();

		// Calculate vector products using static and non-static methods
		System.out.println("Vector product v1 x v2: "+ThreeVector.vectorProduct(v1, v2));
		System.out.println("Vector product v1 x v3: "+ThreeVector.vectorProduct(v1, v3));
		//System.out.println("Non-static vector product v1 x v2: "+v1.vectorProduct(v2));
		//System.out.println("Non-static vector product v1 x v3: "+v1.vectorProduct(v3));
		System.out.println();

		// Calculate angles between vectors using static and non-static methods
		System.out.println("Angle between v1 & v2: "+ThreeVector.angle(v1, v2)+" rads");
		System.out.println("Angle between v1 & v3: "+ThreeVector.angle(v1, v3)+" rads");
		//System.out.println("Non-static angle between v1 & v2: "+v1.angle(v2)+" rads");
		//System.out.println("Non-static angle between v1 & v3: "+v1.angle(v3)+" rads");

	}

}
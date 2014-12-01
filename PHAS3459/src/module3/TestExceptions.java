package module3;

public class TestExceptions {

	public static void main(String[] args) {

		// Test Complex Exceptions
		System.out.println("Testing Exceptions for Complex class...");
		System.out.println();

		// Display values of static class variables
		System.out.println("ONE: "+Complex.ONE);
		System.out.println("I: "+Complex.I);
		System.out.println("-I: "+Complex.I.conjugate());
		System.out.println();

		// Insantiate Complex objects and display values
		Complex c1 = new Complex(-1,2);
		Complex c2 = new Complex(2,-1);
		System.out.println("c1: "+c1);
		System.out.println("c2: "+c2);
		System.out.println();

		// Return various properties of Complex object c1
		try {
			System.out.println("c1 modulus: "+c1.modulus());
			System.out.println("c1 angle: "+c1.angle()+" rads");
			System.out.println("c1 conjugate: "+c1.conjugate());
			System.out.println("c1 normalised: "+c1.normalised());
			System.out.println("c1 normalised modulus: "+c1.normalised().modulus());
			System.out.println("Complex ZERO normalised: "+Complex.ZERO.normalised());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println();
		}

		// Check multiplication and division of Complex objects
		try {
			System.out.println("c1*c2: "+Complex.multiply(c1, c2));
			System.out.println("c1/c2: "+Complex.divide(c1, c2));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println();
		}

		// Check multiplication and division with static Complex objects
		try {
			System.out.println("c1*I: "+Complex.multiply(c1, Complex.I));
			System.out.println("c1/ZERO: "+Complex.divide(c1, Complex.ZERO));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println();
		}


		// Test ThreeVector Exceptions
		System.out.println("Testing Exceptions for ThreeVector class...");
		System.out.println();
		// Instantiate ThreeVector objects
		ThreeVector v1 = new ThreeVector(3,4,1);
		ThreeVector v2 = new ThreeVector(5,3,2);
		ThreeVector v3 = new ThreeVector(0,0,0);

		// Calculate unit vectors for each ThreeVector object
		try {
			System.out.println("ThreeVector v1 unit vector: "+v1.unitVector());
			System.out.println("ThreeVector v2 unit vector: "+v2.unitVector());
			System.out.println("ThreeVector v3 unit vector: "+v3.unitVector());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println();
		}

		// Calculate angles between vectors using static and non-static methods
		try {
			System.out.println("Angle between v1 & v2: "+ThreeVector.angle(v1, v2)+" rads");
			System.out.println("Angle between v1 & v3: "+ThreeVector.angle(v1, v3)+" rads");
			//System.out.println("Non-static angle between v1 & v2: "+v1.angle(v2)+" rads");
			//System.out.println("Non-static angle between v1 & v3: "+v1.angle(v3)+" rads");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println();
		}

		// Test FallingParticle Exceptions
		System.out.println("Testing Exceptions for FallingParticle class...");
		System.out.println();
		// Instantiate null FallingParticle object
		FallingParticle dropPart = new FallingParticle();

		// Instantiate FallingParticle object with zero mass
		try {
			dropPart = new FallingParticle(0, 2.1);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println();
		}

		// Instantiate FallingParticle object with negative drag coefficient
		try {
			dropPart = new FallingParticle(5.3, -1);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println();
		}

		// Instantiate correct FallingParticle object
		try {
			dropPart = new FallingParticle(5.3, 2.1);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println();
		}

		// Set initial drop height to be negative
		try {
			dropPart.setZ(-1);
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println();
		}

		// Drop particle:
		// Reset drop height to be positive but use negative timestep
		try {
			dropPart.setZ(10);
			dropPart.drop(-1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println();
		}

	}

}
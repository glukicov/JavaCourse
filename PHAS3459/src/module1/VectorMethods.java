package module1;

public class VectorMethods {

	// VectorMethods class constructor
	public VectorMethods() { }

	// Dot product of 2 vectors = x1*x2 + y1*y2 + z1*z2
	public double dotProduct (double x1, double y1, double z1, double x2, double y2, double z2) {

		double dotout = x1*x2 + y1*y2 + z1*z2;
		System.out.println("The dot product of vectors ("+x1+", "+y1+", "+z1+") and "+
				"("+x2+", "+y2+", "+z2+") is "+dotout);
		return dotout;
	
	}

	// Magnitude of vector = sqrt(x^2 + y^2 + z^2)
	public double magnitude (double x, double y, double z) {

		double mag = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		System.out.println("The magnitude of vector ("+x+", "+y+", "+z+") is "+mag);
		return mag;
	
	}

	// Angle between 2 vectors = acos((a.b)/(|a|*|b|))
	public double angle (double x1, double y1, double z1, double x2, double y2, double z2) {

		// Calculate magnitude of each vector
		double mag1 = this.magnitude(x1, y1, z1);
		double mag2 = this.magnitude(x2, y2, z2);

		// Calculate dot product between vectors
		double dotprod = this.dotProduct(x1,  y1, z1, x2, y2, z2);

		//Calculate angle from dot product and magnitudes
		double angout = Math.acos(dotprod/(mag1*mag2));

		System.out.println("The angle between vectors ("+x1+", "+y1+", "+z1+") and "+
				"("+x2+", "+y2+", "+z2+") is "+angout+" radians");
		System.out.println("The angle between vectors ("+x1+", "+y1+", "+z1+") and "+
				"("+x2+", "+y2+", "+z2+") is "+Math.toDegrees(angout)+" degrees");

		// Return angle in radians
		return angout;
	
	}

	// Suppress "unused" warnings coming from output variables of angle method
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Instantiate VectorMethods object vm
		VectorMethods vm = new VectorMethods();

		// Define values for vector 1
		double x1 = 6;
		double y1 = 5;
		double z1 = 1;

		//Define values for vector 2
		double x2 = 2;
		double y2 = 4;
		double z2 = 3;

		// Calculate angle between vectors 1 and 2
		double angle = vm.angle(x1, y1, z1, x2, y2, z2);
		System.out.println();

		// Define values for vector 3
		double x3 = 1;
		double y3 = 4;
		double z3 = 1;

		//Define values for vector 2
		double x4 = 0;
		double y4 = 0;
		double z4 = 0;

		// Calculate angle between vectors 3 and 4
		double angle2 = vm.angle(x3, y3, z3, x4, y4, z4);
		System.out.println("Returns several NaN's as magnitude of second vector is zero, "+
				"hence dot product is zero, giving 0/0 in angle calculation");

	}

}
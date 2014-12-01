package module2;

public class ThreeVector {

	// Initialise variables
	// Private to avoid modifying vector data after instantiation
	private double x = 0;
	private double y = 0;
	private double z = 0;

	// Constructors
	public ThreeVector() {}

	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Vector magnitude = sqrt(x^2 + y^2 + z^2)
	double magnitude() {
		double mag = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
		return mag;
	}

	// Unit vector = [x/mag, y/mag, z/mag]
	ThreeVector unitVector() {

		// Check for null vector to prevent returning NaN's
		if ( this.magnitude() == 0 ) {
			// Return null unit vector if vector is null
			ThreeVector unitVec  = new ThreeVector();
			return unitVec;
		}
		else {
			// Return correctly calculated unit vector
			ThreeVector unitVec  = new ThreeVector(this.x/this.magnitude(), this.y/this.magnitude(), this.z/this.magnitude());
			return unitVec;
		}
	}

	// Nicely formatted output string for displaying vector data
	public String toString() {
		String vecString = "["+this.x+" "+this.y+" "+this.z+"]" ;
		return vecString;
	}

	// Dot product = x1.x2 + y1.y2 + z1.z2
	static double scalarProduct(ThreeVector v1, ThreeVector v2) {
		double dotProduct = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
		return dotProduct;
	}

	// Vector product = (y1*z2 - z1*y2)i + (z1*x2 - x1*z2)i + (x1*y2 - y1*x2)k
	static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {

		// Initialise double array for new vector data
		double[] crossProduct = new double[3];

		// Calculate individual (i,j,k) elements of vector product
		crossProduct[0] = v1.y*v2.z - v1.z*v2.y;
		crossProduct[1] = v1.z*v2.x - v1.x*v2.z;
		crossProduct[2] = v1.x*v2.y - v1.y*v2.x;

		// Instantiate new ThreeVector object with vector product components
		ThreeVector v3 = new ThreeVector(crossProduct[0],crossProduct[1],crossProduct[2]);
		return v3;
	}

	// Vector addition = (x1 + x2)i + (y1 + y2)j + (z1 + z2)k
	static ThreeVector add(ThreeVector v1, ThreeVector v2) {

		// Initialise double array for new vector data
		double[] vectorAdd = new double[3];

		// Add individual components for new vector
		vectorAdd[0] = v1.x + v2.x;
		vectorAdd[1] = v1.y + v2.y;
		vectorAdd[2] = v1.z + v2.z;

		// Instantiate new ThreeVector object with new vector components
		ThreeVector v3 = new ThreeVector(vectorAdd[0],vectorAdd[1],vectorAdd[2]);
		return v3;
	}

	// Angle between two vectors = arccos(v1.v2)/(|v1|*|v2|)
	static double angle(ThreeVector v1, ThreeVector v2) {

		// Initialise vectorAngle variable now in case of zero magnitudes
		double vectorAngle = 0;

		// Calculate dot product between vectors
		double dotProd = ThreeVector.scalarProduct(v1, v2);

		// Only calculate angle if magnitude of both vectors > 0
		if (v1.magnitude() != 0 && v2.magnitude() != 0) {
			vectorAngle = Math.acos(dotProd/(v1.magnitude()*v2.magnitude()));
		}
		return vectorAngle;
	}

	// Non-static versions of methods
	double scalarProduct(ThreeVector v1) {
		return scalarProduct(this, v1);
	}

	ThreeVector vectorProduct(ThreeVector v1) {
		return vectorProduct(this, v1);
	}

	ThreeVector add(ThreeVector v1) {
		return add(this, v1);
	}

	double angle(ThreeVector v1) {
		return angle(this, v1);
	}

}
package module3;

public class Complex {

	// Initialise variables
	// Private to avoid modifying vector data after instantiation
	private double real = 0;
	private double imag = 0;
	private double angle = 0;
	private double modulus = 0;

	// Static variables for standard Complex objects
	public static final Complex ONE = new Complex(1,0);
	public static final Complex ZERO = new Complex(0,0);
	public static final Complex I = new Complex(0,1);

	// Class constructors
	public Complex() {}

	public Complex(double real, double imag) {

		this.real = real;
		this.imag = imag;

		// Set modulus and angle from real and imaginary values
		this.modulus = Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
		this.angle = Math.atan2(imag, real);

	}

	// Return real part of Complex number
	double real() {
		return this.real;
	}

	// Return imaginary part of Complex number
	double imag() {
		return this.imag;
	}

	// Return Complex modulus = sqrt(R^2 + I^2)
	double modulus() {
		return this.modulus;
	}

	// Return Argand plane angle = arcctan(I/R)
	double angle() {
		return this.angle;
	}

	// Return Complex object for conjugate = (R - I)
	Complex conjugate() {
		Complex c2 = new Complex(this.real, -this.imag);
		return c2;
	}

	// Return Complex object for normalised Complex number (modulus = 1)
	Complex normalised() throws Exception {
		// Throw Exception if modulus = 0
		if (this.modulus == 0) {
			throw new Exception("Unable to normalise complex number: modulus = 0.");
		}
		Complex c2 = new Complex(this.real/this.modulus, this.imag/this.modulus);
		return c2;
	}

	// Check equality of two Complex numbers
	boolean equals(Complex c1) {

		// Boolean variables for real and imaginary parts
		boolean realgood = false;
		boolean imaggood = false;
		boolean allgood = false;

		// Compare real part
		if (this.real == c1.real) {
			realgood = true;
		}

		// Compare imaginary part
		if (this.imag == c1.imag) {
			imaggood = true;
		}

		// If both real and imaginary parts match, numbers are equal
		if (realgood && imaggood) {
			allgood = true;
		}
		return allgood;

	}

	// Construct pretty formatting for toString method
	public String toString() {

		// Initialise String objects
		String realString = "( ";
		String imagString = ")";

		// Construct real string if real part non-zero 
		if ( this.real != 0 ) {
			realString = realString+this.real+" ";
		}

		// Construct imaginary string if imaginary part non-zero 
		if ( this.imag > 0 ) {
			imagString = this.imag+"i "+imagString;
			if ( this.real != 0 ) {
				imagString = "+ "+imagString;
			}
		} else if ( this.imag < 0 ) {
			// Get spacing right if imaginary part is negative
			if ( this.real != 0 ) {
				imagString = "- "+(-this.imag)+"i "+imagString;
			} else {
				imagString = this.imag+"i "+imagString;				
			}
		}

		// Construct complete output string with real and imaginary parts correctly formatted
		String compString = realString+imagString ;
		return compString;

	}

	// Define Complex number from modulus and angle on Argand plane
	void setFromModulusAngle(double mag, double ang) {
		this.real = mag*Math.cos(ang);
		this.imag = mag*Math.sin(ang);
		this.angle = ang;
		this.modulus = mag;
	}

	// Static method for Complex addition
	static Complex add(Complex c1, Complex c2) {
		Complex c3 = new Complex(c1.real+c2.real, c1.imag+c2.imag);
		return c3;
	}

	// Static method for Complex subtraction
	static Complex subtract(Complex c1, Complex c2) {
		Complex c3 = new Complex(c1.real-c2.real, c1.imag-c2.imag);
		return c3;
	}

	// Static method for Complex multiplication
	static Complex multiply(Complex c1, Complex c2) {
		Complex c3 = new Complex((c1.real*c2.real)-(c1.imag*c2.imag), 
				(c1.imag*c2.real)+(c1.real*c2.imag));
		return c3;
	}

	// Static method for Complex division
	static Complex divide(Complex c1, Complex c2) throws Exception {
		// Throw exception if modulus = 0 for either Complex object
		if (c1.modulus == 0) {
			throw new Exception("Unable to divide complex number: modulus of c1 = 0.");
		}
		if (c2.modulus == 0) {
			throw new Exception("Unable to divide complex number: modulus of c2 = 0.");
		}
		Complex c3 = new Complex( (c1.real*c2.real + c1.imag*c2.imag)/(c2.real*c2.real + c2.imag*c2.imag), 
				(c1.imag*c2.real - c1.real*c2.imag)/(c2.real*c2.real + c2.imag*c2.imag));
		// Division using magnitudes and phases
		//Complex c3 = new Complex((c1.modulus/c2.modulus)*Math.cos(c1.angle - c2.angle), 
		//		(c1.modulus/c2.modulus)*Math.sin(c1.angle - c2.angle));
		return c3;
	}

}
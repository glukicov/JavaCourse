package module3;

// ***ADDED EXCEPTION HANDLING****

public class Complex {

	//Private instance variables: r=Real Part, i=Imag. part
	private double r;
	private double i;

	//Creating a constructor to represent a complex number
	public Complex(double r, double i){
		this.r=r;
		this.i=i;
	}

	//Creating non-static methods to return real, imag., modulus, etc of a complex number object
	// Non-verbose commenting

	double real(){
		return r;
	}

	double imag(){
		return i;
	}

	double modulus(){
		return Math.sqrt(r*r+i*i);
	}

	// Returning angle in rad, taking care of the phasor direction
	double angle(){
		//Math.atan2 The method Converts rectangular coordinates (x, y) 
		//to polar coordinate (r, theta) and returns theta.
		return Math.atan2(i,r);
	}

	static Complex conjuagate(Complex A){
		double n_i=-A.i;
		return new Complex(A.r,n_i);
	}

	Complex normalised() throws Exception {
		if (modulus()==0){
			throw new Exception("Cannot normalise the complex number - division by zero(!)");		
		}
		double unit_r=r/modulus();
		double unit_i=i/modulus();
		return new Complex(unit_r, unit_i);

	}
	//Comparing current Complex number = the the arguments	
	boolean equals(Complex C){
		if(this.r==C.r && this.i==C.i){
			return true;
		}
		else{
			return false;
		}
	}

	// Converting object (complex number) to a string for print out
	public  String toString() { 
		if(i>=0){
			return r+" + "+i+"i";
		}
		else{
			return r+" - "+-i+"i";
		}
	}

	//A void method which will set the values of r and i from mag and angle (in rad) of phasor
	void setFromModulusAngle(double mag, double ang){
		r = mag*Math.cos(ang);
		i = mag*Math.sin(ang);
	}

	//static add method
	static Complex add(Complex A, Complex B){
		double s_r=A.r+B.r;
		double s_i=A.i+B.i;
		return new Complex(s_r, s_i);
	}

	//static subtract method
	static Complex subtract(Complex A, Complex B){
		double s_r=A.r-B.r;
		double s_i=A.i-B.i;
		return new Complex(s_r, s_i);
	}

	//static multiply method
	static Complex multiply(Complex A, Complex B){
		double s_r=A.r*B.r-A.i*B.i;
		double s_i=A.r*B.i+A.i*B.r;
		return new Complex(s_r, s_i);
	}

	//static divide method + Exception handling 
	static Complex divide(Complex A, Complex B) throws Exception {
		double denominator = B.r*B.r +B.i*B.i;
		if(denominator==0) {
			throw new Exception("Cannot divide the two complex numbers - division by zero(!)");	
		}

		double s_r = (A.r*B.r + A.i*B.i)/denominator;
		double s_i = (B.r*A.i - A.r*B.i)/denominator;
		return new Complex(s_r, s_i);
	}

	// Defining Static Complex variables:

	static Complex ONE=new Complex(1,0);
	static Complex ZERO=new Complex(0,0);
	static Complex I=new Complex(0,1);

}

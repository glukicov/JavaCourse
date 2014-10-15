package module2;

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
		if(r>=0 && i>=0){
			return Math.atan(i/r);
		}
		if(r<0 && i>0){
			return Math.PI- Math.atan(i/r);
		}
		if(r<0 && i<0){
			return Math.PI+ Math.atan(i/r);
		}
		else{
			return Math.PI*2+ Math.atan(i/r);
		}
	}

	Complex conjuagate(Complex A){
		return new Complex(r, -i);

	}

	Complex normalised(Complex A){
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
			return r+" - "+i+"i";
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
		double s_r=A.r*B.r;
		double s_i=A.i*B.i;
		return new Complex(s_r, s_i);
	}

	//static divide method
	static Complex divide(Complex A, Complex B){
		double s_r=A.r/B.r;
		double s_i=A.i/B.i;
		return new Complex(s_r, s_i);
	}

	// Defining Static Complex variables:

	static Complex ONE=new Complex(1,0);
	static Complex ZERO=new Complex(0,0);
	static Complex I=new Complex(0,1);

}

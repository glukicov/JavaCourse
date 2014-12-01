package module2;

public class TestComplex {

	public static void main(String[] args) {

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
		System.out.println("c1 modulus: "+c1.modulus());
		System.out.println("c1 angle: "+c1.angle()+" rads");
		System.out.println("c1 conjugate: "+c1.conjugate());
		System.out.println("c1 normalised: "+c1.normalised());
		System.out.println("c1 normalised modulus: "+c1.normalised().modulus());
		System.out.println();

		// Check multiplication and division of Complex objects
		System.out.println("c1*c2: "+Complex.multiply(c1, c2));
		System.out.println("c1/c2: "+Complex.divide(c1, c2));
		System.out.println();

		// Check multiplication and division with static Complex objects
		System.out.println("c1*I: "+Complex.multiply(c1, Complex.I));
		System.out.println("c1/ZERO: "+Complex.divide(c1, Complex.ZERO));
		System.out.println("c1/ZERO gives NaN because of dividing by zero in division method from ZERO vector");
		System.out.println();

		// Check multiplcation of each Complex number with its conjugate
		System.out.println("c1: "+c1);
		System.out.println("c1_conj: "+c1.conjugate());
		System.out.println("c1*c1_conj: "+Complex.multiply(c1, c1.conjugate()));
		System.out.println();
		System.out.println("c2: "+c2);
		System.out.println("c2_conj: "+c2.conjugate());
		System.out.println("c2*c2_conj: "+Complex.multiply(c2, c2.conjugate()));

	}

}
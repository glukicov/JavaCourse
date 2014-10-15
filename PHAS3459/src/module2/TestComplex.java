package module2;

public class TestComplex {

	public static void main(String[] args) {
		//Creating the complex number objects
		Complex c1=new Complex(-1, 2);
		Complex c2=new Complex(2, -1);

		//Testing the Complex class methods:
		System.out.println("Working in Cartesian Coordinate System");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("c1xc2= "+Complex.multiply(c1, c2));
		System.out.println("Leaving zero explcitly for real part");
		System.out.println("c1/c2= "+Complex.divide(c1, c2));
		System.out.println("c1xI= "+Complex.multiply(c1, Complex.I));
		System.out.println("c1/0= "+Complex.divide(c1, Complex.ZERO));
		System.out.println("Division by zero gives Not a number answer: mathematically undefiend");
		// This calls on a static method within a static method of Complex class
		System.out.println("c1x(c2)*= "+Complex.multiply(c1, Complex.conjuagate(c2)));
		System.out.println("c2x(c2)*= "+Complex.multiply(c2, Complex.conjuagate(c2)));
		
	}

}

package module4;

public class ExampleFormating {

	public static void main(String[] args) {
		System.out.println("pi = "+Math.PI); 
		System.out.format("pi = %f%n", Math.PI); 
		System.out.format("pi = %e%n", Math.PI);
		System.out.format("pi = %10.3f%n", Math.PI);
		System.out.format("pi = %.3f; e = %.3f", Math.PI, Math.E);
		System.out.format("; each is stored using %d bits%n", Double.SIZE);
	}

}

package module5;

public class ExampleStrings {

	public static void main(String[] args) {
		String x = "Hello";
		System.out.println(System.identityHashCode(x));
		x = x + " world"; // creates a new object
		System.out.println(System.identityHashCode(x));
		
		StringBuilder z = new StringBuilder("Hello");
		System.out.println(System.identityHashCode(z));
		z.append(" world"); // adds data to existing object
		System.out.println(System.identityHashCode(z));
	}

}

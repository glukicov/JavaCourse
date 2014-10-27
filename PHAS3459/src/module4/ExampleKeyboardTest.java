package module4;

public class ExampleKeyboardTest {
	public static void main(String[] args) {
		int CARRIAGE_RETURN = 10;
		int av;
		System.out.println("Type something please!");
		try {
			do {
				av = System.in.read();
				char avc = (char) av;
				System.out.println(av+": "+avc);
			}
			while (av != CARRIAGE_RETURN);
		}
		catch (java.io.IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
		System.out.println("Thank you!"); 
	}
}

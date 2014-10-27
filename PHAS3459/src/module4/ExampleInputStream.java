package module4;

import java.io.*;

public class ExampleInputStream {

	public static void main(String[] args) {
	InputStreamReader r = new InputStreamReader(System.in);
	BufferedReader b = new BufferedReader(r);
	System.out.println("Please type something!");
	try {
	String s = b.readLine();
	System.out.println("You typed: "+s);
	}
	catch (IOException e) {
	System.out.println("Problem: "+e.getMessage());
	}
	}
}

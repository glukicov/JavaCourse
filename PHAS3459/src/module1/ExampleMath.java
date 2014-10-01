package module1;										// We are currently in module 1 dir
import java.lang.Math;									// Importing Math module

public class ExampleMath {                               // !To be explained in Module 2 (constructor)

	public ExampleMath() {}                           // !To be explained in Module 2 (constructor) 
	
	public double sin2Theta (double theta){           // Declaring Function Sin2Theta returning and accepting doubles 
		double y;									 //  declaring variable y as double
		double arad=Math.toRadians(theta);			// ---
		
		y=2.0*Math.sin(arad)*Math.cos(arad);      // y is a function...
		
		return y;                               // explicit declaration of result output as y  
	}
	
	public static void main(String[] args) {    // starting main function
		ExampleMath ss=new ExampleMath();      // !To be explained in Module 2
		double angle=45.0;                     // ----
		
		double sin2t = ss.sin2Theta(angle);    // Calling our function 
		System.out.println(sin2t);
	}

}

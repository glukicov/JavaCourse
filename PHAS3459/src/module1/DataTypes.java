/* This is Built-in Data Types and Operators assignment */

package module1;

public class DataTypes {

	public static void main(String[] args) {
		
		// Declaring and printing out variables: 
		
		double doubVar=10.0; // Declaring doubVar as double as assigning it value of 10.0
		System.out.println("doubVar= "+doubVar);

		float floatVar=10; 
		System.out.println("floatVar= "+floatVar);
		
		int intVar=10; 
		System.out.println("intVar= "+intVar);
		
		long longVar=10; 
		System.out.println("longVar= "+longVar);
		
		byte byteVar=10; 
		System.out.println("byteVar= "+byteVar);
		
		
		// Multiplying and printing out variables:
		
		System.out.println("doubVar*doubVar= "+doubVar*doubVar);
		System.out.println("floatVar*floatVar= "+floatVar*floatVar);
		System.out.println("intVar*intVar= "+intVar*intVar);
		System.out.println("longVar*longVar= "+longVar*longVar);
		System.out.println("byteVar*longVar= "+byteVar*longVar);
		
	
		// Investigating mixing types in 3 Examples:
		//Example 1 character:
		
		char charVar='a';
		System.out.println("charVar= " +charVar); //Prints out charVar single character variable
		charVar='a'+10;
		System.out.println("charVar= " +charVar);
		System.out.println("As expected, CharVar remanined a singel character. "
				+ "The action of addition of 10 moved a up the Java character set by 10 postions");
		charVar='a'-4;
		System.out.println("charVar= " +charVar);
		System.out.println("CharVar now represents a bracket ']' ");
		
		//Example 2 boolean:
		
		boolean cond=true;
		System.out.println("cond = "+cond);
		// cond= (byte) 0;
		// Boolean cannot be assigned a byte value!
		
		// Example 3 integer:
		int num=3;
		double dob=2.0;
		System.out.println("num= "+num);
		System.out.println("dob= "+dob);
		System.out.println("num*dob= "+num*dob); // Multiplying an integer by a double gives a double output
		
		// Investigating uninitialised variable:
		
		int j=1; // Declaring j as integer and setting initial value to 1
		System.out.println("j= "+j);
		int i;  /* Declaring i as integer WITHOUT setting initial value - this is useful for some memory conserving processes,
				where value for i can be set later */
		
		// System.out.println("i= "+i); - Cannot print i as i has no value (just the variable type)
		//j=i+1; -Operation cannot be performed: i not have been initialised
		//System.out.println("j= "+j);
		
		// Investigating casting:

		double double_var=4.99;  // Assigning a value of 4.99 to a double variable
		System.out.println("double_var= "+double_var);
		int int_var  = (int) double_var; // Casting a value of double_var into an integer variable int_var
		System.out.println("int_var= "+int_var); // Creating integer variable using cast ignores all the values after the decimal point
		System.out.println("Creating integer variable using cast ignores all the values after the decimal point");
		int_var = (int)Math.round(double_var);  // If we want to get the NEAREST integer we should use: 
		System.out.println("int_var= "+int_var); // Now the value of double variable is casted to int_var as integer approximated to the nearest whole number
		System.out.println("Now the value of double variable is casted to int_var as integer approximated to the nearest whole number");		
	}

}

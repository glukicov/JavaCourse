package module3;

import java.util.Random;

public class Alphabet {

	// randomCharacter method to generate random alphanumeric characters
	// Note: using both the two cases implemented in the switch is NOT necessary:
	// only one of these need be used in the submitted answers.
	// They are both included to demonstrate different ways of generating random numbers.
	static char randomCharacter(int type) throws Exception {

		// Initialise necessary variables
		char randChar;
		double randDoub;
		int randInt;

		// Switch structure to select method of random character generation
		switch (type) {

			// Use Math.random
			case 1:
				randDoub = 128*Math.random();	// Generate random double between 1-128
				randInt = (int)randDoub - 1;	// Cast to integer and shift to range 0-127
				randChar = (char)randInt;		// Cast to character
				break;

			// Use java.util.Random
			case 2:
				Random randomObj = new Random();	// Instantiate Random object
				randInt = randomObj.nextInt(127);	// Generate random Integer in range 0-127
				randChar = (char) randInt;			// Cast to character
				break;

			// Throw Exception if neither case 1 or 2 selected 
			default:
				throw new Exception("'Type' input variable can only be 1 or 2.");
		}
		return randChar;
	}

	public static void main(String[] args) {

		// Initialise variables
		int numChars = 1000;	// Total number of characters
		int numCharExcepts = 0;	// Number of Exceptions thrown
		int intChar = 0;		// Integer converted from character
		int sumInts = 0;		// Sum of all integers

		char randChar = 0;		// Randomly generated character 

		// Instantiate StringBuilder objects
		// Note: only the first one is necessary
		// The others are for keeping track of letters and numbers
		// in the first object to make the results more verbose
		StringBuilder allSBChars = new StringBuilder(numChars);	// All characters
		StringBuilder intSBChars = new StringBuilder();			// Integer characters
		StringBuilder nonIntSBChars = new StringBuilder();		// Non-integer characters

		// Generate numChar characters and attempt conversion
		for ( int i = 1 ; i <= numChars ; i++){

			// Generate random character
			// try-catch block only necessary because of switch block in Alphabet.randomCharacter
			try {
				randChar = Alphabet.randomCharacter(2);	// 1 = Math.random; 2 = Random object
			}
			catch (Exception e) {
				System.out.println(e);
				break;
			}

			// Check if randChar is letter or digit
			if (Character.isLetterOrDigit(randChar)) {

				// Add to StringBuilder object
				allSBChars.append(randChar);

				// Try to convert character to integer
				try {

					// Integer.parseInt needs String
					intChar = Integer.parseInt(Character.toString(randChar));

					// If conversion successful, add to sum of all integers
					sumInts += intChar;

					// Append integer to StringBuilder object of integer characters
					intSBChars.append(randChar);

				}
				catch (Exception e) {

					// Increment number of Exceptions from Integer.parseInt
					numCharExcepts++;

					// Append non-integer to StringBuilder object of non-integer characters
					nonIntSBChars.append(randChar);

				}

			}

		}

		// Display all results
		// Print out contents of various StringBuilder objects
		System.out.println("All characters in StringBuilder object:");
		System.out.println(allSBChars);
		System.out.println();
		System.out.println("All letters in StringBuilder object:");
		System.out.println(nonIntSBChars);
		System.out.println();
		System.out.println("All integers in StringBuilder object:");
		System.out.println(intSBChars);
		System.out.println();

		// Print out sizes of StringBuilder objects
		System.out.println("Total number of characters in StringBuilder object: "+allSBChars.length());
		System.out.println("Total number of letters in StringBuilder object: "+nonIntSBChars.length());
		System.out.println("Total number of integers in StringBuilder object: "+intSBChars.length());
		System.out.println();

		// Print out integer sum and number of Exceptions thrown
		System.out.println("Sum of all integers in StringBuilder object: "+sumInts);
		System.out.println("Total number of exceptions thrown by Integer.parseInt: "+numCharExcepts);

	}

}
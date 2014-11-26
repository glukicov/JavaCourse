package module8;

import java.util.ArrayList;

/** A class performing a prime number finding
// * 
// * @author Gleb
// * @version 1.2 (26/11/14)
// * @
 **/
public class PrimeNumberTask implements Runnable {

	//Initialising the array to store prime numbers
	static ArrayList<Integer> primes = new ArrayList<Integer>();	
	//Initialising the array to store integer numbers that have been checked
	static ArrayList<Integer> integers = new ArrayList<Integer>();	

	//Testing number 
	private int num = 2;

	public void run() {
		// run until interrupted
		while (true) { 
			if (Thread.currentThread().isInterrupted()) return;

			 private static boolean isPrime(int num) {
			        if (num % 2 == 0)
			            return false;
			        for (int i = 3; i * i <= num; i += 2)
			            if (num % i == 0) return false;
			        return true;
			  } 

		}

	}

	// Defining a new if prime method 
/*	private boolean ifPrime(int test) {

		// For all previous primes
		for (Integer i : primes) {
			// Check if divisible
			if (test % i == 0)
				return false;
		}
		return true;

	}*/




}


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
	private int num = 2; // 1 is not prime

	public void run() {

		//Need to have a non-empty array (we know that 1 is not a prime) 
		integers.add(1);
		//primes.add(2);

		// run until interrupted
		while (true) { 
			if (Thread.currentThread().isInterrupted()) return;{

				//Checking if the number is prime by a defined method below
				if (isPrime(num))
					// Add to array of primes and checked
					primes.add(num);
				integers.add(num);
				num += 1; 
			}
			//If it is NOT prime, just add to integers array 
			integers.add(num);
			num += 1; }


	}



	/**
	 * This method is testing prime numbers by dividing the test number by all elements in
	 * array in turn, if one of this yields zero -> we have an integer
	 * @param test (integer to be tested for being prime)
	 * @return true is it is a prime, false otherwise
	 */
	private boolean isPrime(int test) {
		//testing for all the integers checked so far
		for (Integer i : integers) {
			//if it is a multiple of that integer -> not prime
			if (test % i == 0)
				return false;

		}
		return true;



	}

}


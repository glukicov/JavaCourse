package module8;
/** A class utilising 2 threads:
// * 			Thread 1: To set a counter for a countdown, which will control (interrupt when time is up)
 //* 			Thread 2: Which is finding the prime numbers
// * 
// * Printing out the largest prime number found, largest integer checked, 
// * total number of prime numbers found
//* 
//* @author Gleb
//* @version 1.3 (16/12/14)
//* @
 */
public class ThreadMain {

	public static void main(String[] args) {

		//Initialising the threads defined by the respective classes
		CountdownTask ct = new CountdownTask(10);
		PrimeNumberTask pn = new PrimeNumberTask();
		Thread counter = new Thread(ct);
		Thread prime = new Thread(pn);

		//Starting the threads

		counter.start();
		prime.start();
		try{

			counter.join();
		} 
		catch (InterruptedException e) 
		{
			counter.interrupt();
			prime.interrupt();
		}

		// Stop prime thread
		prime.interrupt();	


		//Using an array property size to find the largest elements
		// it works because we use a consecutive method to add elements to array
		// so the last element is the largest!

		System.out.println("Total number of prime numbers found: "+PrimeNumberTask.primes.size());
		System.out.println("Largest prime number found: "+PrimeNumberTask.primes.get(PrimeNumberTask.primes.size()-1));
		System.out.println("Total number of integers checked: "+PrimeNumberTask.integers.size());

	}

}

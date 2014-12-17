package module8;

import java.util.ArrayList;

/** A class performing a prime number finding
// * 
// * @author Gleb
// * @version 1.2 (16/12/14)
// * @
 **/
public class PrimeNumberTask implements Runnable {

	//Initialising the array to store prime numbers
	static ArrayList<Integer> primes = new ArrayList<Integer>();	
	//Initialising the array to store integer numbers that have been checked
	static ArrayList<Integer> integers = new ArrayList<Integer>();

	private int num;


	@Override
	public void run() {
		while(true){
			if(Thread.currentThread().isInterrupted()) return;
			int counter = num -1;
			boolean test = true;
			while (counter>1){
				if(num % counter == 0){
					test=false;
					integers.add(counter);
				}
				counter=counter-1;
			}
			if(test){
				primes.add(num);
			}
			num=num+1;
		}	

	}
}

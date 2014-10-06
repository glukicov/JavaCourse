/* This is Algorithm control assignment */


package module1;

public class AlgorithmControl {

	public AlgorithmControl(){}						// Creating an empty constructor 

	public static void loop() { //Creating a void method loop() as defined below:
		int i;
		int f=20;
		for (i=1; i<=f; i++){   // Creating a for loop with logical condition i<=f
			System.out.println("i= "+i); //Whcih prints an incriment of x until x reaches 20
		}
	}

	public static void decrement(){ //Creating a void method decrement() as defined below:
		int x=5;
		while (x>-11){  // Creating a while loop which prints value of x until x reaches -11
			System.out.println("x= "+x); // For last print out x is still -10
			x--;  
		}			
	}

	public static void increment(){ //Creating a void method increment to print out values from
		// 2.4 to 14.9 in steps of 0.5
		double inc_val;
		double finish=14.9;
		double step=0.5;
		for(inc_val=2.4; inc_val<=finish; inc_val=inc_val+step){
			System.out.println("inc_val= "+inc_val);
		}

	}

	public static int timer(long maxTime, int loopSteps){  
		int counter=0;
		int remainder;
		long finish_time=System.currentTimeMillis()+maxTime*1000;  //Max time in seconds * 1000 = XXXX ms

		while (System.currentTimeMillis()<=finish_time){  // The logical condition is to run for 4000 ms

			counter++;										// Every time a while loop is executed counter is incremented by 1
			remainder=counter % loopSteps;						
			if (remainder == 0) {							// When the remainder is 0 - it is the 100th loop!
				System.out.println("Number of loops run so far= "+counter);  // Prints after every 100 loops
			}
		}
		System.out.println(""); // Empty print out statement to improve to readability on console output
		System.out.println("The toal Number of loops run= "+counter);
		System.out.println("");
		System.out.println("For big time period of while loop (e.g. maxTime= 4000 ms) and loopSteps=100 Number of loops run so far = Total number of loops (multiple of 100)...(interesting)");
		System.out.println("However, for small time period (e.g. 2 ms) it as expected, NOT necessarily equal. This is due to the println statement embedded into the while-if loop..");
		System.out.println("When we change the loopSteps=50000, the println statement appears 500 less often on the screen and slow down the while loop execution less significantly,");
		System.out.println("as a result, the total number of loops executed increased by a factor of ~20 (e.g. from 16702600 to 303290839, respectively)");
		return counter;

	}


	public static void main(String[] args) {

		loop(); //Calling on the loop method

		System.out.println(""); // Empty print out statement to improve to readability on console output

		decrement();  //Calling on the decrement method

		System.out.println("");

		increment(); //Calling on the increment method

		System.out.println("");
		// timer();  When amount of time was hard-coded no method arguments were necessary

		// timer(4, 100); (e.g The total Number of loops run= 16702600)

		timer(4, 50000); // (e.g. The total Number of loops run= 303290839) 
	}
}


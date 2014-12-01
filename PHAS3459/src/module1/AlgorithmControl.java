package module1;

public class AlgorithmControl {

	// AlgorithmControl class constructor
	public AlgorithmControl() { }

	// Count up in integer steps using for loop
	public void loop(int startVal, int endVal) {

		int i;
		System.out.println("Counting up from "+startVal+" to "+endVal+" in integer steps:");

		for ( i = startVal ; i <= endVal ; i++) {
			// Print out iterator at each step
			System.out.println("Iterator i = "+i);
		}
		System.out.println();
		
	}

	// Count down in integer steps using while loop
	public void decrement(double startVal, double minVal) {

		double i = startVal;
		System.out.println("Counting down from "+startVal+" to "+minVal+" in integer steps:");

		// Loop till iterator <= minVal
		while ( i >= minVal) {
			// Print out iterator at each step
			System.out.println("Iterator i = "+i);
			i-- ;			 
		}
		System.out.println();

	}

	// Count up in arbitrary steps using while loop
	public void increment(double startVal, double maxVal, double incVal) {

		double i = startVal;
		System.out.println("Counting up from "+startVal+" to "+maxVal+" in steps of "+incVal+":");

		// Loop till maxVal reached or exceeded
		while ( i <= maxVal ) {
			// Print out iterator at each step
			 System.out.println("Iterator i = "+i);
			 i += incVal;			 
		}
		System.out.println();

	}

	// Timer, displaying number of iterations every N steps 
	public int timer(long maxTime, int loopSteps) {

		// Get current system time in milliseconds
		long timeStart = System.currentTimeMillis();
		long timeNow = System.currentTimeMillis();
		long timeDiff = 0;
		int loopNum = 0 ;
		System.out.println("Running timer for "+maxTime+"ms, displaying number of completed loops every "+
				loopSteps+" steps");
		System.out.println();

		// Run while loop for maxTime milliseconds
		while ( timeDiff < maxTime) {
			timeNow = System.currentTimeMillis();
			timeDiff = timeNow - timeStart ;
			loopNum++ ;

			// Calculate whether to display loop number using remainder
			int iremainder = loopNum % loopSteps ;
			if (iremainder == 0) {
				//System.out.println("  Iteration = "+loopNum);
				System.out.println("  Iteration = "+loopNum+"; time since start = "+timeDiff+"ms");
				/** System.out.println("  Iteration = "+loopNum+"; current time = "+timeNow+
						"; time since start = "+timeDiff+"ms"); */
			} 
		}
		// Display summary data
		System.out.println();
		System.out.println("Ran timer for "+maxTime+"ms, displaying number of completed loops every "+
				loopSteps+" steps");
		System.out.println("Total duration of timer: "+timeDiff+"ms");
		System.out.println("Total number of iterations: "+loopNum);
		System.out.println();

		return loopNum;

	}

	public static void main(String[] args) {

		// Instantiate AlgorithmControl object alg
		AlgorithmControl alg = new AlgorithmControl();

		// Run loop method from 1 to 20 
		alg.loop(1, 20);

		// Run decrement method from 5 to -10
		alg.decrement(5, -10);

		// Run increment method from 2.4 to 14.9 in steps of 0.5
		alg.increment(2.4, 14.9, 0.5);

		// Run timer method for 5s printing every 100 steps
		int loopNum100 = alg.timer(5000, 100) ;

		// Run timer method for 5s printing every 50,000 steps
		int loopNum50000 = alg.timer(5000, 50000) ;

		System.out.println(loopNum100+" loops completed for timer displaying every 100 iterations.");
		System.out.println(loopNum50000+" loops completed for timer displaying every 50,000 iterations.");
		System.out.println();
		System.out.println("Number of loops completed for timer displaying every "+
				"50,000 iterations is much higher than for 100 iterations");
		System.out.println("This is because displaying text to the screen takes CPU resources,");
		System.out.println("delaying the timer each time a call to System.out.println is made.");

	}

}
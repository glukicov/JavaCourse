package module8;


public class CountdownTask implements Runnable {
	/** A class performing a countdown
	 * 
	 * @author Gleb
	 * @version 1.3 (26/11/14)
	 * @
	 **/

	//Initialising the variables for counting 
	int interval;


	/** This constructor sets the number of seconds to countdown  in seconds
	 * 
	 * @param interval
	 */
	public CountdownTask(int interval){
		this.interval=interval;
		
	}

	

	public void run() {
		//Setting the countdown interval with respect to system's time
		long startTime = System.currentTimeMillis() / 1000;
		long endTime = startTime + interval;
		
		//Using loop to check the elapsed time and print the time remaining
		while (System.currentTimeMillis() / 1000 < endTime) {
			while (startTime != System.currentTimeMillis() / 1000) {
				startTime += 1;
				if (endTime - startTime > 1)
					System.out.println(endTime - startTime + " seconds left.");
				else if (endTime - startTime == 1) {
					System.out.println("1 second left.");
				}
			}
		}
		System.out.println("Countdown is finished!.");
	}

}

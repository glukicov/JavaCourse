package module8;

/** A class for...
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * @
 * */

public class ExampleNumberSeries implements Runnable {
	private int start;
	private int end;
	private int step;
	public ExampleNumberSeries(int start, int end, int step) {
		this.start = start;
		this.end = end;
		this.step = step;
	}
	public void run() {
		for (int i=start; i<end; i+=step) {
			System.out.println(i);
		}
	}

public static void main(String[] args) {

	Thread odds = new Thread(new ExampleNumberSeries(1,1000,2));
	Thread evens = new Thread(new ExampleNumberSeries(2,1000,2));
	odds.start();
	evens.start();


}

}

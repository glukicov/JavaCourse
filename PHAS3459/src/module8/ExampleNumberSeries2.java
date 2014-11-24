package module8;

public class ExampleNumberSeries2 implements Runnable {
	private int start;
	private int step;
	public ExampleNumberSeries2(int start, int step) {
		this.start = start;
		this.step = step;
	}
	public void run() {
		int i = start;
		while (true) { // run until interrupted
			if (Thread.currentThread().isInterrupted()) return;
			System.out.println(i);
			i += step;
		}
	}
	public static void main(String[] args) {
		Thread odds = new Thread(new ExampleNumberSeries2(1,2));
		Thread evens = new Thread(new ExampleNumberSeries2(2,2));
		odds.start();
		evens.start();
		try {
			Thread.sleep(5000); // main thread pauses for 5 seconds
			// while other threads run
		}
		catch (InterruptedException e) {
			// stop early if main thread is interrupted
		}
		odds.interrupt();
		evens.interrupt();

	}
}
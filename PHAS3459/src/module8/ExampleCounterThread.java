package module8;

public class ExampleCounterThread implements Runnable {
	private ExampleCounter c;
	private Thread t;
	public ExampleCounterThread (ExampleCounter c) { this.c = c; }
	public void start() {
		if (t == null) {
			t = new Thread(this,"counter");
			t.start();
		}
	}
	public void run() {
		if ( t!= null) {c.count();}
	}

public static void main(String[] args) {
	ExampleCounter c1 = new ExampleCounter(); 
	ExampleCounter c2 = new ExampleCounter();
	ExampleCounterThread ct1 = new ExampleCounterThread(c1);
	ExampleCounterThread ct2 = new ExampleCounterThread(c1); // use same Counter
	// Or use different Counters :
	//ExampleCounterThread ct2 = new ExampleCounterThread(c2);
	ct1.start();
	ct2.start();
}

}

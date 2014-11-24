package module8;

public class ExampleCounter {

	private int value = 1;
	public ExampleCounter() {}
	public synchronized void count() {
		int limit = value + 1000;
		while (value < limit) {
			System.out.println(value);
			value++;
		}
	}
}
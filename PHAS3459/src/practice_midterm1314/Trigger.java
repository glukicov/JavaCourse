package practice_midterm1314;

public class Trigger {
	String name;
	double signal;
	double background;
	private double ratio;
	
	public Trigger() {}
	
	public Trigger(String name, double s, double b) {
		signal = s;
		background = b;
		this.name = name;
		
	}
		
	public double ratio() {
		this.ratio = signal/background;
		return ratio;
	}
	
	public String toString() {
		return name+" "+signal+" "+background+" "+ratio();
	}
}

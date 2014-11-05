package module5;

public class DataPoints {

	private double x;
	private double y;
	private double ey;

	//Data: http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt

	//Constructor for setting values
	public DataPoints(double x, double y, double ey) {
		this.x = x; this.y = y; this.ey = ey;
	}

	//Getter methods
	public double getx() {
		return this.x;
	}
	public double gety() {
		return this.y;
	}
	public double getey() {
		return this.ey;
	}
	public String toString() {
		return "(" + this.x + ", " + this.y + ", " + this.ey + ")";
	}



}



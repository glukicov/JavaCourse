package module5;

public class DataPoint {

	private double x;
	private double y;
	private double ey;

	//Data: http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt

	//Constructor for setting values
	public DataPoint(double x, double y, double ey) {
		this.x = x; this.y = y; this.ey = ey;
	}

	//Getter methods
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getEY() {
		return this.ey;
	}
	//Method to output values as a string
	public String toString() {
		return "("+this.x+", "+this.y+", "+this.ey+")";
	}



}



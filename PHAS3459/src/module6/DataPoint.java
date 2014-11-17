package module6;

public class DataPoint {

	protected double x;
	protected double y;
	protected double ey;

	
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
		return "x= "+this.x+", y= "+this.y+" +- "+this.ey+"";
	}



}



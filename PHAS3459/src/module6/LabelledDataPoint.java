package module6;

//This subclass extends the DataPoint superclass

public class LabelledDataPoint extends DataPoint {

	protected String label;
	
	//Constructor for setting values
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.label=label;
		
	}

	//If an object stored in the array is LabelledDataPoint this method will
	// overwrite toString method as defined in DataPoint
	
	public String toString(){
		return this.label+": x= "+this.x+", y= "+this.y+" +- "+this.ey+"";
	}
	
	
}

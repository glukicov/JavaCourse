package experiment;

public class DataPoint {

	private double decay;
	
	//Constructor for setting values
	public DataPoint(double decay) {
		this.decay = decay;
	}

	//Getter methods
	public double getDecay() {
		return this.decay;
	}
		
	//Method to output values as a string
	public double toDouble() {
		return this.decay;
	}



}



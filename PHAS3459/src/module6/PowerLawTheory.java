package module6;

public class PowerLawTheory implements Theory {

	//This class implements Theory interface
	double n;
	
	//Constructor for setting values
	public PowerLawTheory(double n){
		this.n=n;
	}
	
	//Modelling y=x^n
	public double y(double x){
		return  Math.pow(x, n);

	}
	
	//Method to output values as a string
		public String toString() {
			return "y=x^"+this.n+"";
		}
}


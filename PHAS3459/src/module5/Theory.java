package module5;

public class Theory {

	//Modelling y=x^n
	
	private double n;
	public Theory(double n){
		this.n=n;
	}

	public double y(double x){
		return  Math.pow(x, n);

	}
}


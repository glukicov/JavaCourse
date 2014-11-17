package module6;

public class QuadraticTheory implements Theory {

	//This class implements Theory interface
	double a;
	double b;
	double c;
	
	//Constructor for setting values
	public QuadraticTheory(double a,double b, double c){
		this.a=a; this.b=b; this.c=c;
	}
	
	//Modelling y=ax^2+bx+c
	public double y(double x){
		return  a*Math.pow(x, 2)+b*x+c;

	}
	
	//Method to output values as a string
		public String toString() {
			return "y= "+this.a+"x^2 +"+this.b+"x +"+this.c+"";
		}
}


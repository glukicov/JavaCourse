package module1;
public class ExampleDeclaringFunction2 {
	public ExampleDeclaringFunction2() {}
	
	public double quadratic (double x) {
		double y;
		double a=2.0; double b=3.0; double c=5.0;
		y=a*x*x + b*x +c;
		return y;
	}
	
	public static void main(String[] args) {
		ExampleDeclaringFunction2 myS = new ExampleDeclaringFunction2();
	double xx=2.0;
	double yy=myS.quadratic(xx);
	System.out.println("xx =" +xx+" yy = " +yy);		

	}

}
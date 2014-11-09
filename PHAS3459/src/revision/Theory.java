package revision;

public class Theory {
	
	private int n;
	
	public Theory(int n){
		this.n=n;
	}
	
	public double y(double x){
		return Math.pow(x,n);
	}

}

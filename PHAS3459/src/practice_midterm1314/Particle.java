package practice_midterm1314;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Particle {
	private int q;
	private double p;
	private double theta;
	private double phi;
	private String[] data;
	private FourVector fv;
	
	public Particle(String[] data) throws InputMismatchException {
		if (data.length != 4) {
			throw new InputMismatchException("Invalid input! Number of input fields must be 4.");
		} else {
			this.data = data;
			q = Integer.parseInt(data[0]);
			p = Double.parseDouble(data[1]);
			theta = Double.parseDouble(data[2]);
			phi = Double.parseDouble(data[3]);
			fv = new FourVector(p,theta,phi);
		}
	}

	public int getQ() {
		return q;
	}

	public double getP() {
		return p;
	}

	public double getTheta() {
		return theta;
	}

	public double getPhi() {
		return phi;
	}
	
	public String toString() {
		return Arrays.toString(data);		
	}
	
	public FourVector fourVector() {
		return fv;
	}
	
}

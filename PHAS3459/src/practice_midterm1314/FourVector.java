package practice_midterm1314;

import java.util.Arrays;

public class FourVector {
	// Calculated instance variables
	private double E;
	private double px;
	private double py;
	private double pz;
	private double modP;
	private double ivM;
	
	// Four-vector
	private double[] fourVector;
	
	// Instance variables from data
	private double p;
	private double theta;
	private double phi;
	
	public FourVector(double E, double px, double py, double pz) {
		this.E = E; this.px = px; this.py = py; this.pz = pz;
		fourVector = new double[]{E,px,py,pz};
	}
	
	public FourVector(double p, double theta, double  phi) {
		this.p = p; this.theta = theta; this.phi = phi;
		this.E = Math.abs(this.p);
		this.px = px();
		this.py = py();
		this.pz = pz();
		fourVector = new double[]{E,px,py,pz};
	}
	
	public FourVector(double[] fourVector) {
		this.fourVector = fourVector;
		E = fourVector[0];
		px = fourVector[1];
		py = fourVector[2];
		pz = fourVector[3];
	}
	
	private double px() {
		px = p*Math.sin(theta)*Math.cos(phi);
		return px;
	}
	
	private double py() {
		py = p*Math.sin(theta)*Math.sin(phi);
		return py;
	}
	
	private double pz() {
		pz = p*Math.cos(theta);
		return pz;
	}
	
	public double modP() {
		modP = Math.sqrt(Math.pow(px,2)+Math.pow(py,2)+Math.pow(pz,2));
		return modP;
	}
	
	public double getE() {
		return E;
	}

	public double getPx() {
		return px;
	}

	public double getPy() {
		return py;
	}

	public double getPz() {
		return pz;
	}

	public double[] getFourVector() {
		return fourVector;
	}
	
	static FourVector add(FourVector a, FourVector b) {
		double[] fvArray = new double[4];
		for (int i=0; i<4; i++) {
			fvArray[i] = a.fourVector[i] + b.fourVector[i];
		}
		FourVector c = new FourVector(fvArray);
		return c;
	}
	
	public FourVector add(FourVector b) {
		FourVector c = add(this, b);
		return c;
	}
	
	static double ivMass(FourVector a, FourVector b) {
		FourVector c = add(a,b);
		c.ivM = Math.sqrt(Math.pow(c.E,2)-Math.pow(c.modP(),2));
		return c.ivM;
	}
	
	public double ivMass() {
		ivM = Math.sqrt(Math.pow(E,2)-Math.pow(modP(),2));
		return ivM;
	}
	
	public String toString() {
		return Arrays.toString(fourVector);
	}

}

package practice_midterm1112;

import java.util.*;

public class Particle {
	private double x;
	private double y;
	private double z;
	private double r;
	private List<Double> particle = new ArrayList<Double>(); 
	
	public Particle(double x,double y, double z) {
		this.x = x; this.y = y; this.z = z;
		Double[] particleList = new Double[]{x,y,z};
		particle.addAll(Arrays.asList(particleList));
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public double getR() {
		return r;
	}
	
	public void setR(double r) {
		this.r = r;
	}

	public List<Double> getParticle() {
		return particle;
	}
	
	public String toString() {
		return particle.toString();
	}
	
}

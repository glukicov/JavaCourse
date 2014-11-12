package practice_midterm1112;
import java.util.*;

public class Planet {
	private List<Particle> particles =  new ArrayList<Particle>();
	private Double z;
	
	public Planet(Double z) {
		this.z = z;
	}
	
	public Planet() {}

	public List<Particle> getParticles() {
		return particles;
	}

	public Double getZ() {
		return z;
	}
	
	public void setZ(Double z) {
		this.z = z;
	}
	
	public void add(Particle p) {
		particles.add(p);
	}
	
	public Double meanX() {
		Double sumX = 0.0;
		Double n = (double) particles.size();
		for (Particle p : particles) {
			sumX += p.getX();
		}
		Double meanX = sumX/n;
		return meanX;
	}
	
	public Double meanY() {
		Double sumY = 0.0;
		Double n = (double) particles.size();
		for (Particle p : particles) {
			sumY += p.getY();
		}
		Double meanY = sumY/n;
		return meanY;
	}
	
	public void radialDistance() {
		Double xBar = meanX();
		Double yBar = meanY();
		for (Particle p : particles) {
			Double x = p.getX();
			Double y = p.getY();
			Double r = Math.sqrt(Math.pow((x-xBar),2)+Math.pow((y-yBar),2));
			p.setR(r);
		}
	}
	
	public Double RMSRadius() {
		radialDistance();
		Double sumRi = 0.0;
		Double n = (double) particles.size();
		for (Particle p : particles) {
			sumRi += Math.pow(p.getR(),2);
		}
		Double rRMS = Math.sqrt(sumRi/n);
		return rRMS;
	}
	
	public Double maxRadius() {
		List<Double> radii =  new ArrayList<Double>();
		for (Particle p : particles) {
			radii.add(p.getR());
		}
		Collections.sort(radii);
		Collections.reverse(radii);
		Double maxRadius = radii.get(0);
		return maxRadius;
	}
}

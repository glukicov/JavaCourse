package practice_midterm1314;

import java.util.*;
import java.util.InputMismatchException;

public class Event {
	private String trigger;
	private List<Particle> particles = new ArrayList<Particle>();
	private double ratio;
	private double sig;
	private double bg;
	private List<Pair> pairs = new ArrayList<Pair>();
	
	public Event(String[] title) throws InputMismatchException {
		if (title.length != 3) {
			throw new InputMismatchException("Input is must be 3 values.");
		} else {
			trigger = title[2];
		}
	}
	
	public void addParticle(String[] data) {
		Particle p = new Particle(data);
		particles.add(p);
	}
	
	public void addParticle(Particle p) {
		particles.add(p);
	}
	
	public List<Particle> getParticles() {
		return particles;
	}
	
	public String getTrigger() {
		return trigger;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(trigger+'\n');
		for (Particle p : particles) {
			sb.append(p+"\n");
		}
		return sb.toString();
	}
	
	public List<Pair> pairsList() {
		for (Particle p : particles) {
			int id = particles.indexOf(p);
			for (int j=id+1; j<particles.size(); j++) {
				Particle q = particles.get(j);
				if (q.getQ() != p.getQ()) {
					Pair pq = new Pair(p,q);
					pairs.add(pq);
				} 
			}
		}
		return pairs;
	}
	
	public double[] ratioCalculator() throws ArithmeticException {
		double signal = 0;
		double background = 0;
		double r;
		List<Pair> pl = pairsList();
		for (Pair pq : pl) {
			double pm = pq.pairMass();
			if (pm >= 8 && pm <= 10) {
				signal++;
			} else if (pm >= 11 && pm <= 15) {
				background++;
			}
		}
		r = signal/background;
		ratio = r;
		sig = signal;
		bg = background;
		return new double[]{signal, background, r};
		//return ratio;
	}
	
}

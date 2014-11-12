// Written by Aditya Mukherjee for PHAS3459 Midterm of 2014-15 on 10th November 2014
package practice_exam1;
import java.util.*;

// Class represents method of planet discovery, stores its name and a list of planets discovered by the method
public class Method {
	// Instance variables
	private String name;
	private List<Planet> planets = new ArrayList<Planet>();
	
	// Constructors
	public Method() {} // Null constructor
	// Constructor with name
	public Method(String name) {
		this.name = name;
	}
	
	// getters 
	public String getName() {
		return name;
	}
	
	public List<Planet> getPlanets() {
		return planets;
	}
	
	// method to add planet to list of planets
	public void add(Planet p) {
		planets.add(p);
	}
	
	public Planet lightestPlanet() {
		double lightestMass = Double.MAX_VALUE;
		Planet lightestPlanet = new Planet();
		for (Planet p : planets) {
			if (p.getMass()<lightestMass) {
				lightestMass = p.getMass();
				lightestPlanet = p;
			}
		}
		return lightestPlanet;
	}
	
	public int earliestPlanet() {
		int earliestDate = Integer.MAX_VALUE;
		// Planet earliestPlanet = new Planet(); // left to allow extension of functionality incase full details of earliest planet are needed
		for (Planet p : planets) {
			if (p.getDate()<earliestDate) {
				earliestDate = p.getDate();
				//earliestPlanet = p; // extends functionality
			}
		}
		return earliestDate;
	}
	
	public int numberPlanets() {
		int number = planets.size();
		return number;
	}
	
	// to allow printing
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name+"\n");
		for (Planet p : planets) {
			sb.append(p+"\n");
		}
		return sb.toString();
	}
	
}

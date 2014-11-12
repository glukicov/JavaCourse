// Written by Aditya Mukherjee for PHAS3459 Midterm of 2014-15 on 10th November 2014
package practice_exam1;
import java.util.*;

// Class to store planet object
public class Planet {
	// Instance variables
	private String name;
	private int date;
	private String method;
	private double mass;
	private double separation;
	private double distance;
	
	/* CONSTRUCTORS */
	// Null constructor
	public Planet() {}
	// Constructor with and with distance
	public Planet(String name, int date, String method, double mass, double separation, double distance) {
		this.name = name;
		this.date = date;
		this.method = method;
		this.mass = mass;
		this.separation = separation;
		this.distance = distance;
	}
	// Constructor with and without distance
	public Planet(String name, int date, String method, double mass, double separation) {
		this.name = name;
		this.date = date;
		this.method = method;
		this.mass = mass;
		this.separation = separation;
	}
	
	/* GETTERS */
	public String getName() {
		return name;
	}

	public int getDate() {
		return date;
	}

	public String getMethod() {
		return method;
	}

	public double getMass() {
		return mass;
	}

	public double getSeparation() {
		return separation;
	}

	public double getDistance() {
		return distance;
	}
	
	// to allow printing
	public String toString() {
		// prints "UNKNOWN" for distance if no distance recorded
		if (this.distance != 0.0) {
			return "["+name+", "+date+", "+method+", "+mass+", "+separation+", "+distance+"]";
		} else {
			return "["+name+", "+date+", "+method+", "+mass+", "+separation+", "+"UNKNOWN"+"]";
		}
	}
	
	public boolean distanceExists() {
		if (this.distance != 0.0) {
			return true;
		} else {
			return false;
		}
	}
}

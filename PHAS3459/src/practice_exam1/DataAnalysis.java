// Written by Aditya Mukherjee for PHAS3459 Midterm of 2014-15 on 10th November 2014
package practice_exam1;
import java.util.*;

// Class to analyse exoplanet data
public class DataAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// URL to read data from
			String URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt";
			// Create HashMap of exoplanets
			Map<String, Planet> exoplanets = Input.getData(URL); 
			// Calculate and print details of planet closest to Earth
			System.out.println("Exoplanet closest to Earth:");
			Planet p = earthNearest(exoplanets);
			// Printing formatted output
			System.out.printf("%-16s %-5s %-12s %-12s %-18s %-18s\n", "Name", "Date", "Method", "Mass", "Distance from Star", "Distance from Earth");
			System.out.printf("%-16s %-5s %-12s %-12s %-18s %-18s\n", "", "", "", "Jupiters", "a.u.", "parsecs");
			planetPrinter(p);
			// Create map of planets by Method
			Map<String, Method> methods = Input.planetsByMethod(exoplanets);
			System.out.println();
			// Print method statistics
			System.out.println("Statistics for each method of discovery:");
			methodStats(methods);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// print error trace
			e.printStackTrace();
		}
	}
	
	// method to find planet closest to earth
	public static Planet earthNearest(Map<String, Planet> exoplanets) {
		// set to maximum possible double value
		double minDistance = Double.MAX_VALUE;
		String nearestName = ""; 
		// Iterate through all entries in exoplanet map
		for (Map.Entry<String, Planet> e : exoplanets.entrySet()) {
			// value of each key in exoplanet map is the planet object
			Planet p = e.getValue();
			double distance = p.getDistance();
			// check if planet has a distance
			if (p.distanceExists()) {
				// if planet distance smaller than current minimum, it becomes the new minimum
				if (distance < minDistance) {
					minDistance = distance;
					// collect name of planet with current minimum distance
					nearestName = p.getName();
				} 
			}
		}
		// get planet object of minimum distance
		Planet nearestPlanet = exoplanets.get(nearestName);
		return nearestPlanet;
	}
	
	// provide statistics about each method of dicovery: number of exoplanets discovered, earliest year used to discover an exoplanet, lightest exoplanet discovered
	public static void methodStats(Map<String, Method> methods) {
		// print formatted column headers: %-Xs is left justified, X characters wide, string format, %-X.Yf is left justified, X wide column, Y decimal places float formatting
		System.out.printf("%-12s %-12s %-12s %s\n", "Method", "Number", "Earliest", "Lightest Planet Discovered:"); 
		System.out.printf("%-12s %-12s %-12s %-16s %-5s %-12s %-12s %-18s %-18s\n", // 
				"", "discovered", "discovery", "Name", "Date", "Method", "Mass", "Distance from Star", "Distance from Earth"); 
		// Iterate through method map
		for (Map.Entry<String, Method> e : methods.entrySet()) {
			Method m = e.getValue();
			String name = e.getKey();
			int number = m.numberPlanets(); // number of planets in the method
			int earliest = (int) m.earliestPlanet(); // year of earliest discovery
			Planet l = m.lightestPlanet(); // lightest planet
			System.out.printf("%-12s %-12s %-12s %-16s %-5s %-12s %-12.8f %-18.8f %-18.8f\n", 
					name, number, earliest, l.getName(), l.getDate(), l.getMethod(), l.getMass(), l.getSeparation(), l.getDistance());
		}
	}
	
	// print planet data in formatted columns
	public static void planetPrinter(Planet p) {
		System.out.printf("%-16s %-5s %-12s %-12.8f %-18.8f %-18.8f\n", p.getName(), p.getDate(), p.getMethod(), p.getMass(), p.getSeparation(), p.getDistance());
	}
	
}

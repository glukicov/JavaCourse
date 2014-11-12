// Written by Aditya Mukherjee for PHAS3459 Midterm of 2014-15 on 10th November 2014
package practice_exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

// Class to read from URL and build Map of exoplanet data
public class Input {

	// Scanner to process read lines
	static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}
	
	// Method to use scanner for URL and read data into Map, returns Map with exoplanet name as key, exoplanet object as value
	public static Map<String, Planet> getData(String url) throws IOException, InputMismatchException {
		Map<String, Planet> exoplanets = new HashMap<String, Planet>();
		Scanner sc = scFromURL(url);
		//int i = 0; //Counter for loop runs (number of planets processed)
		while (sc.hasNextLine()) {
			// Instantiate planet object and input data processing Strings
			Planet exoplanet;
			String [] inputLine;
			String line;
			// trim leading and trailing whitespace
			line = sc.nextLine().trim();
			// Split line by ','
			String[] lineArray = line.trim().split(",");
			// Skip lines where second field begins with a letter (the second field for exoplanet lines is the date which starts with a number)
			if (inputLineCheck(lineArray)) {
				// Go to nextline and split by ','
				inputLine = sc.nextLine().trim().split(",");
			} else {
				inputLine = lineArray;
			}
			// Check if input is 5 or 6 pieces of data
			if (inputLine.length == 5 || inputLine.length == 6) { 
				// Set planet instance variables from input String
				String name = inputLine[0];
				// System.out.println(name); // code to check data working
				int year = Integer.parseInt(inputLine[1]);
				String method = inputLine[2];
				double mass = Double.parseDouble(inputLine[3]);
				double separation = Double.parseDouble(inputLine[4]);
				// Instantiate planet object with the appropriate constructor depending on the number of inputs provided
				if (inputLine.length == 6) {
					double distance = Double.parseDouble(inputLine[4]);
					exoplanet = new Planet(name, year, method, mass, separation, distance);
				} else {
					exoplanet = new Planet(name, year, method, mass, separation);
				}
				// if HashMap of planets already contains planet name, throw error
				if (exoplanets.containsKey(name) == true) {
					throw new InputMismatchException("Duplicate planet!");
				} else {
					// add planet to hashmap
					exoplanets.put(name, exoplanet);
				}
			} else {
				throw new InputMismatchException("Input must contain 5 or 6 variables in the format: NAME,DATE,[PLANET DISCOVERY METHOD],[MASS,SEPARATION FROM STAR],[DISTANCE FROM EARTH]");
			}
			//i++; //Increment counter
		}
		// Close scanner to prevent memory leak
		sc.close();
		//System.out.println(i); // Print planet counter
		//System.out.println(exoplanets.keySet().size()); // Print size of exoplanet map to compare with counter
		return exoplanets;
	}
	
	//  create new hashmap of methods
	public static Map<String, Method> planetsByMethod(Map<String, Planet> exoplanets) {
		Map<String, Method> methods = new HashMap<String, Method>();
		// loop through each entry in exoplanets map
		for (Entry<String, Planet> e : exoplanets.entrySet()) {
			Planet p = e.getValue();
			String key = p.getMethod();
			if (methods.containsKey(key)) {
				methods.get(key).add(p);
			} else {
				// add new method to methods hashmap
				methods.put(key, new Method(key));
			}
		}
		return methods;
	}
	
	// check input line 
	private static boolean inputLineCheck(String[] lineArray) {
		// check if second element in line array starts with a letter 
		if (Character.isLetter(lineArray[1].charAt(0))) {
			return true;
		} else {
			return false;
		}
	}
}

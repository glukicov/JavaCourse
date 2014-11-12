package practice_midterm1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Input {
	
	static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}
	
	public static Map<Double, Planet> getData(String url) throws IOException, InputMismatchException {
		Map<Double, Planet> beam = new TreeMap<Double, Planet>();
		Scanner sc = scFromURL(url);
		String line;
		String[] lineArray;
		while (sc.hasNextLine()) {
			Planet detector = new Planet();
			line = sc.nextLine().trim();
			if (Character.isLetter(line.charAt(0))) {}	
			else {
				lineArray = line.trim().split("\\s+");
				if (lineArray.length != 3) { 
					throw new InputMismatchException("Input must contain 3 variables.");
				} else {
					Double x = Double.parseDouble(lineArray[0]);
					Double y = Double.parseDouble(lineArray[1]);
					Double z = Math.abs(Double.parseDouble(lineArray[2]));
					Particle p = new Particle(x, y, z);
					//System.out.println(p);
					if (beam.containsKey(z) == false) {
						detector.add(p);
						beam.put(z, detector);
					} else {
						beam.get(z).add(p);
					}
				}
			}
		}
		sc.close();
		return beam;
	}

}


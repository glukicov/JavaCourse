package practice_midterm1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Input {
	//static int year = Calendar.getInstance().get(Calendar.YEAR);
	//static int month = Calendar.getInstance().get(Calendar.MONTH);
	static int year = 2012;
	static int month = 11;
	
	static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}
	
	public static Map<Integer, List<Double>> data(String url) throws IOException{
		Map<Integer, List<Double>> rainData = new TreeMap<Integer, List<Double>>();
		Scanner sc = scFromURL(url);
		String line;
		String[] lineArray;
		while (sc.hasNextLine()) {
			List<Double> rainfall = new ArrayList<Double>();
			line = sc.nextLine().trim();
			if (Character.isLetter(line.charAt(0))) {}	
			else {
				lineArray = line.trim().split("\\s+");
				int year = Integer.parseInt(lineArray[0]);
				double totalRain = Double.parseDouble(lineArray[lineArray.length-1]);
				rainfall.add(totalRain);
				if (year <= Input.year) {
					for (int i=1;i<lineArray.length-1;i++) {
						if (i > Input.month && year == Input.year) {
							System.out.println(i+"/"+year+" is in the future!");
						} else {
							double d = Double.parseDouble(lineArray[i]);
							rainfall.add(d);
						}
					}
				}
				rainData.put(year, rainfall);	
			}
		}
		sc.close();
		return rainData;
	}

}

package practice_midterm1213;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class DataAnalysis {
	Map<Integer, List<Double>> rainData = new TreeMap<Integer, List<Double>>();
	Map<Integer, List<Double>> byMonth = new HashMap<Integer, List<Double>>();

	public static void main(String[] args) throws IOException {
		DataAnalysis dA = new DataAnalysis();
		dA.input("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2012-13/HadEWP_monthly_qc.txt");
		dA.rainByMonth();
		dA.maxRain();
		dA.minMaxMonthlyRain();
		dA.wettest3Months();
		dA.monthStats();
		dA.percentageMoreRain();
	}
	
	// Input
	public void input(String URL) throws IOException {	
		Map<Integer, List<Double>>  rainData = Input.data(URL);
		this.rainData = rainData;
	}	
	
	// Max rainfall in dataset
	public void maxRain() {
		int maxYear = 0;
		double max = 0;
		int maxMonth = 0;
		for (Entry<Integer, List<Double>> e : rainData.entrySet()) {
			List<Double> line = e.getValue();
			List<Double> calendar = line.subList(1,line.size());
			double maxRain = Collections.max(calendar);
			int month = calendar.indexOf(maxRain);
			int year = e.getKey();
			//System.out.println(year+" "+(month+1)+" "+maxRain);
			if (maxRain > max) {
				max = maxRain;
				maxYear = year;
				maxMonth = month+1;
			}
		}
		System.out.println("Maximum rain of dataset:");
		System.out.printf("%-8s %-8s %-8s\n","Year", "Month", "Rain");
		System.out.printf("%-8s %-8s %-8s\n", maxYear, maxMonth, max);
	}
		
	public void rainByMonth() {
		Map<Integer, List<Double>> byMonth = new HashMap<Integer, List<Double>>();
		for (int i=0; i<12; i++) {
			byMonth.put(i+1, new ArrayList<Double>());
		}
		for (Entry<Integer, List<Double>> e : rainData.entrySet()) {
			List<Double> line = e.getValue();
			List<Double> calendar = line.subList(1,line.size());
			for (int i=0; i<calendar.size(); i++) {
				double d = calendar.get(i);
				byMonth.get(i+1).add(d);
			}
		}
		this.byMonth = byMonth;
	}
	// Max min rainfall per month
	public void minMaxMonthlyRain() {
		List<Integer> keys = new ArrayList<Integer>(rainData.keySet());
		System.out.println("Maximum and minimum rainfall by month:");
		System.out.printf("%-8s %-8s %-8s %-8s %-8s\n","Month", "Max", "Year", "Min", "Year");
		
		for (Entry<Integer, List<Double>> m : byMonth.entrySet()) {
			List<Double> rByMonth = m.getValue();
			double maxRMonth = Collections.max(rByMonth);
			double minRMonth = Collections.min(rByMonth);
			int maxY = keys.get(rByMonth.indexOf(maxRMonth));
			int minY = keys.get(rByMonth.indexOf(minRMonth));
			int month = m.getKey();
			System.out.printf("%-8s %-8s %-8s %-8s %-8s\n", month, maxRMonth, maxY, minRMonth, minY);
		}
	}
	
	// Wettest 3 month period
	public void wettest3Months() {
		System.out.println("Wettest 3 month period overall");
		System.out.printf("%-8s %-8s %-8s\n","Year", "Months", "Total Rain");
		double w3 = 0;
		String w3m = "";
		int w3y = 0;
		for (Entry<Integer, List<Double>> y : rainData.entrySet()) {
			List<Double> year = y.getValue();
			List<Double> calYear = year.subList(1,year.size());
			double w3PerYear = 0;
			String w3Months = "";
			for (int i=0; i<calYear.size()-2; i++) {
				double d = calYear.get(i)+calYear.get(i+1)+calYear.get(i+2);
				if (d>w3PerYear) {
					w3PerYear = d;
					w3Months = (i+1)+"-"+(i+3);
				}
			}
			if (w3PerYear>w3) {
				w3 = w3PerYear;
				w3m = w3Months;
				w3y = y.getKey();
			}
			// System.out.printf("%-12s %-12s %.1f\n", y.getKey(), w3Months, w3PerYear); // to print each month
		}
		System.out.printf("%-8s %-8s %-8s\n", w3y, w3m, w3);
	}
		
	// Mean and RMS for each month
	public void monthStats() {
		System.out.println("Mean and RMS for each month: ");
		System.out.printf("%-8s %-8s %-8s\n", "Month", "Mean", "RMS");
		for (Map.Entry<Integer, List<Double>> e : byMonth.entrySet()) {
			List<Double> yRain = e.getValue();
			double total = 0;
			double sqTotal = 0;
			double n = yRain.size();
			for (Double mRain : yRain) {				
				total += mRain;
				sqTotal += Math.pow(mRain,2);
			}
			double mean = total/n;
			double rms = Math.sqrt(sqTotal/n);
			System.out.printf("%-8s %5.3f %8.3f\n",e.getKey(), mean, rms);
		}
	}
	
	// Month comparison of other years to 2012
	public void percentageMoreRain() {
		System.out.println("Percentage of previous years with a larger rainfall per month of 2012");
		System.out.printf("%-8s %-8s\n", "Month", "Percentage");
		for (int i=1; i<=Input.month; i++) {		
			List<Double> yRain = byMonth.get(i);
			double rain2012 = yRain.get(yRain.size()-1);
			double more = 0;
			//double less = 0;
			for (Double mRain : yRain) {
				more += (mRain > rain2012) ? 1 : 0;
				//less += (mRain < rain2012) ? 1 : 0;
			}
			double total = yRain.size()-1;
			double percentage = (more/total)*100;
			System.out.printf("%-8s %5.3f\n", i, percentage);
		}
	}
}


	


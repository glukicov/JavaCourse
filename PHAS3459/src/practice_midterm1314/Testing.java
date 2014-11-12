package practice_midterm1314;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Testing {

	public static void main(String[] args) throws IOException, ArithmeticException {
		// TODO Auto-generated method stub
		/* Testing Particle and FourVector classes 
		String s1 = "1 11.727031 2.102098 1.576670";
		String s2 = "-1 4.380394 0.523488 0.298805";
		
		String[] d1 = s1.split("\\s+");
		String[] d2 = s2.split("\\s+");
		
		Particle p1 = new Particle(d1);
		Particle p2 = new Particle(d2);
		
		FourVector fp1 = p1.fourVector();
		FourVector fp2 = p2.fourVector();
		FourVector fp3 = FourVector.add(fp1,fp2);
		
		System.out.println("Particle 1: "+p1);
		System.out.println("Four-vector 1: "+fp1);
		System.out.printf("|p|1 = "+"%.2f",fp1.modP());
		System.out.printf("m1 = "+"%.2f",fp1.ivMass());
		System.out.println('\n');
		
		System.out.println("Particle 2: "+p2);
		System.out.println("Four-vector 2: "+fp2);
		System.out.printf("|p|2 = "+"%.2f",fp2.modP());
		System.out.printf("m2 = "+"%.2f",fp2.ivMass());
		System.out.println('\n');
		
		System.out.println("fp1 + fp2 = "+fp3);
		System.out.printf("|p|3 = "+"%.2f",fp3.modP());
		System.out.printf("\nm3 = "+"%.2f",fp3.ivMass());
		System.out.printf("\nm3 = "+"%.2f",FourVector.ivMass(fp1,fp2));
		*/
		Input i = new Input();
		HashMap<Integer,Event> events = i.recordEvents();
		int n = 0;
		double s = 0;
		double b = 0;
		HashMap<String,Trigger> triggerMap = new HashMap<String,Trigger>();
			for (n=0; n<events.size(); n++) {
				try {
					Event e = events.get(n);
					String name = e.getTrigger();
					double[] ratio = e.ratioCalculator();
					if (triggerMap.containsKey(name)) {
						double signal = triggerMap.get(name).signal + ratio[0];
						double background = triggerMap.get(name).background + ratio[1];
						Trigger t = new Trigger(name, signal, background);
						triggerMap.put(name, t);
					} else {
						double signal = ratio[0];
						double background = ratio[1];
						Trigger t = new Trigger(name, signal, background);
						triggerMap.put(name, t);
					}
					s += ratio[0];
					b += ratio[1];
				} 
				catch (ArithmeticException ae) {
					continue;
			}
		}
		double bestRatio = 0; 
		String bestT = "";
		System.out.printf("%-10s %-10s %-10s %-10s\n", "Trigger", "Signal", "Background", "Ratio");
		for (Map.Entry<String, Trigger> e : triggerMap.entrySet()) {
			Trigger t = e.getValue();
			System.out.printf("%-10s %-10s %-10s %-10s\n", t.name, t.signal, t.background, t.ratio());
			if (bestRatio < t.ratio()) {
				bestRatio = t.ratio();
				bestT = t.name;
			}
		}
		Trigger bT = triggerMap.get(bestT);
		System.out.println("Trigger with best ratio:");
		System.out.printf("%-10s %-10s %-10s %-10s\n", bT.name, bT.signal, bT.background, bT.ratio());
		System.out.printf("%-10s %-10s\n", "Total Signal:",s);
		System.out.printf("%-10s %-10s\n", "Total Background:",b);
		System.out.printf("%-10s %-10s\n", "Total Ratio:",s/b);	}
		
}

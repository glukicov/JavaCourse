package module6;

import java.util.Collection;
import java.util.Iterator;

public class ChiSquared implements GoodnessOfFitCalculator {
	
	// This class implements GoodnessOfFitCalculator interface

	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		double chi=0;
		Iterator<DataPoint> point = data.iterator();
		while (point.hasNext()){
			DataPoint scan = point.next();
			chi+=Math.pow(scan.getY()-theory.y(scan.getX()),2)/Math.pow(scan.getEY(), 2);
		}
		return chi;

	}
}


package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ChiSquared implements GoodnessOfFitCalculator {

}




//Static Chi^2 method:
static double goodnessOfFit(Theory theory, ArrayList<DataPoint> experiment)throws IOException{
	double chi=0;
	Iterator<DataPoint> point = experiment.iterator();
	while (point.hasNext()){
		DataPoint scan = point.next();
		chi+=Math.pow(scan.getY()-theory.y(scan.getX()),2)/Math.pow(scan.getEY(), 2);
	}
	return chi;
}
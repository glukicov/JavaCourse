package module6;

import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis  {

	// using url from the Test Data Points class:  dataURL="http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt";
	static String dataURL=TestDataPoints.dataURL;


	public static void main(String[] args) {

		try{
			ArrayList<DataPoint> data = new ArrayList<DataPoint>();	
			// Refereeing to the method in another class
			data = TestDataPoints.dataFromURL(dataURL);

			//Testing the best fit for the data:
			// 1) y=x^2 or 2) y=x^2.05 or 3) y=x^2+10x

			// Setting values on theory classes by creating an instance of that class (object)
			PowerLawTheory theory1=new PowerLawTheory (2);  // 1) y=x^2 
			PowerLawTheory theory2=new PowerLawTheory (2.05);  //   2) y=x^2.05  
			QuadraticTheory theory3=new QuadraticTheory (1, 10, 0); 	// 3) 3) y=x^2+10x

			// Puts different models into an array list for comparison by bestTheory method
			ArrayList<Theory> theories = new ArrayList<Theory>();	
			theories.add(theory1);
			theories.add(theory2);
			theories.add(theory3);

			// Setting the godCalcualtor 
			GoodnessOfFitCalculator gofCalculator=new ChiSquared();

			System.out.println("The best fit to the data is provided by the following model: " +bestTheory(data, theories, gofCalculator)+"\n");

			//Creating an instance of ChiSquared class
			ChiSquared ch = new ChiSquared(); 

			// Explicitly printing out Chi2 and Reduced Chi2 values for each model
			for (Theory th:theories){
						System.out.println("Testing for theory: "+th);
						double chi = ch.goodnessOfFit(data, th);
						System.out.println("The value of chi^2=" +chi);
						System.out.println("Reduced chi^2=" +chi/data.size()+"\n");
			}

		}
		catch (Exception e){System.out.println("An error has occured: " +e.getMessage());}

		finally {System.out.println("Task execution has finished!");}		

	}


	//This methods compares the theories' fit, as a collection of objects in array list.
	private static Theory bestTheory(Collection<DataPoint> data, 
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}





}

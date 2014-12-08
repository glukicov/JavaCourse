package exam2011;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/** Main class for displaying the results:
 *
 * blah-blah-blah....
 * <p>
 *  
 * <p>
 *  
 * <p>
 *
 *
 * @author Gleb
 * @version 1.3 (17/11/14)
 * @
 * */
public class Main {

	//Storing URL variable
	private static final String urlRegions ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/regions.txt";
	private static final String urlPopulations ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/populations.txt";
	private static final String urlXYZ ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesXYZ.txt";
	private static final String urlAB ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesAB.txt";
	public static double occA = 0;
	public static double occB = 0;
	public static double occX = 0;
	public static double occY = 0;
	public static double occZ = 0;
	public static double meanA = 0;
	public static double meanB = 0;
	public static double stdDA = 0;
	public static double stdDB = 0;

	public static void main(String[] args) {

		try {
			//Creating an instance of Methods class, which implements an interface (Interface) 
			//to use its non-static methods for data analysis and data input, etc. 
			// (see Methods.java for the definitions of the custom methods and functions used)
			Methods m = new Methods();

			//Storing all data as ArrayList - I love array lists:
			//	Easy to work with: sort, iterate, etc.
			//  Obvious choice, duh! 
		
			ArrayList<Reg> regions = m.readRegions(urlRegions);			

			ArrayList<Pop> populations = m.readPopulations(urlPopulations);

			ArrayList<AB> ab =m.readAB(urlAB);

			ArrayList<XYZ> xyz =m.readXYZ(urlXYZ);

			// Finding the total population using the great power of Array LIst!
			int sumOfPopulation=0;
			for (Pop item: populations){
				sumOfPopulation=sumOfPopulation+item.getPopulation();
			}
			System.out.println("Total UK population in question " +sumOfPopulation);

			//For A per capita: //same for others....
			//First find total A occ.
			double sumA = 0;
			double sumB = 0;
			for (AB item : ab){
				sumA=sumA+item.getA();
				sumB=sumB+item.getB();
			}
			//Find the population which was surveyed for A and B
			double sumOfPopulationAB = 0;
			for (int i=0; i<ab.size(); i++){
				String code=ab.get(i).getCode();
				for (Pop p: populations){
					if (p.getCode().equals(code)){
						sumOfPopulationAB=sumOfPopulationAB+p.getPopulation();
					}
				}
			}
			//Same for XYZ 
			double sumX = 0;
			double sumY = 0;
			double sumZ = 0;
			for (XYZ item : xyz){
				sumX=sumX+item.getX();
				sumY=sumY+item.getY();
				sumZ=sumZ+item.getZ();
			}
			//Find the population which was surveyed for XYZ
			double sumOfPopulationXYZ = 0;
			for (int i=0; i<ab.size(); i++){
				String code=ab.get(i).getCode();
				for (Pop p: populations){
					if (p.getCode().equals(code)){
						sumOfPopulationXYZ=sumOfPopulationXYZ+p.getPopulation();
					}
				}
			}							
			occA=sumA/sumOfPopulationAB;
			occB=sumB/sumOfPopulationAB;
			occX=sumX/sumOfPopulationXYZ;
			occY=sumY/sumOfPopulationXYZ;
			 occZ=sumZ/sumOfPopulationXYZ;
			System.out.printf("Occurrence of A per capita %.7f%n",occA);
			System.out.printf("Occurrence of B per capita %.7f%n",occB);
			System.out.printf("Occurrence of X per capita %.7f%n",occX);
			System.out.printf("Occurrence of Y per capita %.7f%n",occY);
			System.out.printf("Occurrence of Z per capita %.7f%n",occZ);

			//Now create two arrays sumAB and sumXYZ for total number of diseases per region
			ArrayList<Pop> sumAB = new ArrayList<Pop>();
			ArrayList<Pop> sumXYZ = new ArrayList<Pop>();
			
			for (AB item : ab){
				String code =item.getCode();
				int totalAB=item.getA()+item.getB();
				sumAB.add(new Pop(code,totalAB));
			}
			System.out.println("size of AB population :"+sumAB.size());
			
			for (XYZ item : xyz){
				String code =item.getCode();
				int totalXYZ=item.getX()+item.getY()+item.getZ();
				sumXYZ.add(new Pop(code,totalXYZ));
			}
			System.out.println("size of XYZ population :"+sumXYZ.size());
			System.out.println("Hence compare those two disease group separately");

			//Now create two arrays capAB and capXYZ for number of total number of
			// Diseases per capita in the region
			ArrayList<Cap> capAB = new ArrayList<Cap>();
			ArrayList<Cap> capXYZ = new ArrayList<Cap>();
			
			//Taking care that AB, and XYZ size < populations
			// Divide by population for each region
			for (Pop item : sumAB){
				double capita=0;
				String code =item.getCode();
				double number=item.getPopulation();
				for (Pop pop: populations){
					String popCode=pop.getCode();
					if (code.equals(popCode)){
						capita = number/pop.getPopulation();
					    
					}
				}				
				
					capAB.add(new Cap(code,capita));
			}
			//System.out.println("size of AB cap population :"+capAB.size());
			//System.out.println("size of AB cap population :"+capAB);
			//Same for XYZ
			for (Pop item : sumXYZ){
				double capita=0;
				String code =item.getCode();
				double number=item.getPopulation();
				for (Pop pop: populations){
					String popCode=pop.getCode();
					if (code.equals(popCode)){
						capita = number/pop.getPopulation();
					    
					}
				}				
				
					capXYZ.add(new Cap(code,capita));
			}
			
		//	System.out.println("size of XYZ cap population :"+capXYZ);
		//	System.out.println("size of XYZ cap population :"+capXYZ.size());
			
			//Using a custom comparator to sort in acceding order the collection 
			// object by  
			Collections.sort(capXYZ, new Comparator<Cap>() {
				@Override
				public int compare(Cap c1, Cap c2) {
					return Double.compare(c1.getPopulation(), c2.getPopulation());
				}
			});
			//Same of AB
			Collections.sort(capAB, new Comparator<Cap>() {
				@Override
				public int compare(Cap c1, Cap c2) {
					return Double.compare(c1.getPopulation(), c2.getPopulation());
				}
			});
			
			//The highest and lowest and last and first, respectively
			String lowestXYZCode=capXYZ.get(0).getCode();
			String highestXYZCode=capXYZ.get(capXYZ.size()-1).getCode();
			String lowestABCode=capAB.get(0).getCode();
			String highestABCode=capAB.get(capAB.size()-1).getCode();
			
			//Again, using the magic of array Lists to get the desired information! 
			for (Reg item : regions){
				String code=item.getCode();
				if (code.equals(lowestXYZCode)){
					System.out.println("The lowest region with XYZ is "+item.getName().replace(",", "").replace("[", "").replace("]", ""));
				}
				if (code.equals(highestXYZCode)){
					System.out.println("The highest region with XYZ is "+item.getName().replace(",", "").replace("[", "").replace("]", ""));
				}
				if (code.equals(lowestABCode)){
					System.out.println("The lowest region with AB is "+item.getName().replace(",", "").replace("[", "").replace("]", ""));
				}
				if (code.equals(highestABCode)){
					System.out.println("The highest region with AB is "+item.getName().replace(",", "").replace("[", "").replace("]", ""));
				}
			}
			
			ArrayList<Result> result =m.poissonALLA(ab, populations, regions);
			System.out.println(result.toString().replace(",", "").replace("[", "").replace("]", ""));
			
			meanA=m.meanA(ab);
			meanB=m.meanB(ab);
			stdDA=m.stdA(ab, meanA);
			stdDB=m.stdB(ab, meanB);

			double corrAB = m.correlationAB(ab, meanA, meanB,stdDA, stdDB);
			System.out.println(corrAB);
			
			ArrayList<AB> aboveMean=m.filter(ab, meanA);
			System.out.println(aboveMean.size());
			
			ArrayList<String> selected = m.select(ab, 5, regions);
			System.out.println(selected.toString().replace(",", "").replace("[", "").replace("]", ""));
		} 

		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}

package exam2012;

import java.io.IOException;
import java.util.ArrayList;

/** Main class for displaying the results:
 *
 * Provides not so elegant and resource heavy solution, but hey, it works! 
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
	private static final String urlGG ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt";
	private static final String urlZZ ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt";
	private static final String URLHiggs ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt";

	//Counter variables with extended scope (!! use with great care!!)
	static double predictedCounterZZ=0;
	static double predictedCounterGG=0;
	static double eventsZZ=0;
	static double eventsGG=0;
	static double energyHiggs=0;
	static double measuredCounterZZ=0;
	static double measuredCounterGG=0;

	public static void main(String[] args) {

		try {
			//Creating an instance of Methods class, which implements an interface (Interface) 
			//to use its non-static methods for data analysis and data input, etc. 
			// (see Methods.java for the definitions of the custom methods and functions used)
			Methods m = new Methods();

			//Storing the background data in the array list collections
			ArrayList<Background> totalBackgroundGG = m.readBackground(urlGG);
			ArrayList<Background> totalBackgroundZZ = m.readBackground(urlZZ);


			//Using collection Iterator to loop though all items 
			//and add energies to new arrays in the range 120-140 Gev
			// those are the predicted (theory) values for events per bin
			//use counter to get the total number of events immediately 

			ArrayList<Background> predictedGG = new ArrayList<Background>();
			for(Background item1 : totalBackgroundGG){
				if (item1.getLowBin()>=120 && item1.getHighBin()<=140){
					predictedGG.add(item1);
					predictedCounterGG=predictedCounterGG+item1.getEvents();
				}
			}

			//Same for ZZ:
			ArrayList<Background> predictedZZ = new ArrayList<Background>();
			for(Background item2 : totalBackgroundZZ){
				if (item2.getLowBin()>=120 && item2.getHighBin()<=140){
					predictedZZ.add(item2);
					predictedCounterZZ=predictedCounterZZ+item2.getEvents();
				}
			}
			

			System.out.printf("Total GG %10.3f background events expected in 120-140 Gev\n",predictedCounterGG);
			System.out.printf("Total ZZ %10.3f background events expected in 120-140 Gev\n",predictedCounterZZ);

			
			//Reading Higgs data for ZZ and GG			
			ArrayList<Higgs> higgsData=m.readHiggs(URLHiggs);
			//Creating array to store ALL highs events for each channel
			ArrayList<Higgs> totalHiggsZZ = new ArrayList<Higgs>();
			ArrayList<Higgs> totalHiggsGG = new ArrayList<Higgs>();

			//Sorting by channels and counting
			for (Higgs item : higgsData){
				if(item.getEventID().equals("GG")){
					totalHiggsGG.add(item);
					eventsGG = eventsGG + 1;
				}
				if(item.getEventID().equals("ZZ")){
					totalHiggsZZ.add(item);
					eventsZZ = eventsZZ + 1;
				}
			}
			
			//Creating a duplicate arrays just to get the bins (see later)
			ArrayList<Background> totalBackgroundGGempty = m.readBackground(urlGG);
			ArrayList<Background> totalBackgroundZZempty = m.readBackground(urlZZ);
			
			//Now creating an empty totalMeasuredGG array and import the bins from totalBackgroundGGempty (low and high)
			//Leaving the events number as 0, which will be filled later with events from higgsGG
			ArrayList<Background> totalMeasuredGG = new ArrayList<Background>();
			ArrayList<Background> totalMeasuredZZ = new ArrayList<Background>();
			
			//these arrays now have the bin widhts and 0 as events number
			for (Background item : totalBackgroundGGempty){
				item.setEvents(0);
				totalMeasuredGG.add(item);
			}
			for (Background item : totalBackgroundZZempty){
				item.setEvents(0);
				totalMeasuredZZ.add(item);
			}
			
		
			
			 // For each of 100 bins:
			// extract each Higgs event one by one (for a channel), compare it 
			//with Low and High bin, if it belongs to that bin -> counter +1
			// and number of events is incremented with iEvents method (see Method class)
			// record total number of events per bin

		   //For GG for each one of 100 bins
			for (int i=0; i<100;i++){
			//extract higgs energy one by one
				for (Higgs event: totalHiggsGG){
					//store it in a temp. variable
					energyHiggs=event.getEventEnergy();
					//get the bin width
					int low = totalMeasuredGG.get(i).getLowBin();
					int high = totalMeasuredGG.get(i).getHighBin();
					//check if event belong to that bin
					boolean test = energyHiggs<=high && energyHiggs>=low;
					//if it does -> add 1 to the event field in that energy range
					// like a histogram! 
					if (test){
						totalMeasuredGG.get(i).iEvents();
					}

				}
									
			}
						
			
			//Same for ZZ
			for (int i=0; i<100;i++){
			for (Higgs event: totalHiggsZZ){
						energyHiggs=event.getEventEnergy();
					
						int low = totalMeasuredZZ.get(i).getLowBin();
						int high = totalMeasuredZZ.get(i).getHighBin();
						boolean test = energyHiggs<=high && energyHiggs>=low;
						if (test){
							totalMeasuredZZ.get(i).iEvents();
						}

					}
			}
						
						
			//For measured events in 120-140 Gev: extract the range into a new arrayList
			ArrayList<Background> measuredGG = new ArrayList<Background>();
			for(Background item1 : totalMeasuredGG){
				if (item1.getLowBin()>=120 && item1.getHighBin()<=140){
					measuredGG.add(item1);
					measuredCounterGG=measuredCounterGG+item1.getEvents();
				}
			}
			//same for ZZ:
			ArrayList<Background> measuredZZ = new ArrayList<Background>();
			for(Background item2 : totalMeasuredZZ){
				if (item2.getLowBin()>=120 && item2.getHighBin()<=140){
					measuredZZ.add(item2);
					measuredCounterZZ=measuredCounterZZ+item2.getEvents();
				}
			}
		

			System.out.printf("Total GG %10.3f candidate events measured in 120-140 Gev\n",measuredCounterGG);
			System.out.printf("Total ZZ %10.3f candidate events measured in 120-140 Gev\n",measuredCounterZZ);
			
			//Print out the arrays! Notice the right energy range and
			// different number of events per bin for EXPECTED vs MEASURED
			//WOOOOOOOOOOOOOOOOOOOOO
		//	System.out.println(predictedZZ);
		//	System.out.println(measuredZZ);
		//	System.out.println(predictedGG);
		//	System.out.println(measuredGG);
			
			System.out.println("LL of GG for 120-140 GeV:"+m.logL(predictedGG,measuredGG));
			System.out.println("LL of ZZ for 120-140 GeV:"+m.logL(predictedZZ,measuredZZ));
			
		
		} 

		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}

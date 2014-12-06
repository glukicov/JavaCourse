package exam2012;

import java.io.IOException;
import java.util.ArrayList;

/** Main class for displaying the results:
 *
 * 
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
public class CopyOfMain {

	//Storing URL variable
	private static final String urlGG ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt";
	private static final String urlZZ ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt";
	private static final String URLHiggs ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt";


	static double totalZZ=0;
	static double totalGG=0;
	static double eventsZZ=0;
	static double eventsGG=0;
	static double energyHiggs=0;
	static double counterZZ=0;
	static double counterGG=0;

	public static void main(String[] args) {

		try {
			//Creating an instance of Methods class, which implements an interface (Interface) 
			//to use its non-static methods for data analysis and data input, etc. 
			// (see Methods.java for the definitions of the custom methods and functions used)
			Methods m = new Methods();

			//Storing the backgorund data in the array list collection
			ArrayList<Background> dataGG = m.readBackground(urlGG);
			ArrayList<Background> dataZZ = m.readBackground(urlZZ);


			//Using collection Iterator to loop though all items 
			//and delete energies outside of the range 

			ArrayList<Background> predictedGG = new ArrayList<Background>();
			for(Background item1 : dataGG){
				if (item1.getLowBin()>=120 && item1.getHighBin()<=140){
					predictedGG.add(item1);
					totalGG=totalGG+item1.getEvents();
				}
			}

			ArrayList<Background> predictedZZ = new ArrayList<Background>();
			for(Background item2 : dataZZ){
				if (item2.getLowBin()>=120 && item2.getHighBin()<=140){
					predictedZZ.add(item2);
					totalZZ=totalZZ+item2.getEvents();
				}
			}


			System.out.printf("Total GG %10.3f events expected in 120-140 Gev\n",totalGG);
			System.out.printf("Total ZZ %10.3f events expected in 120-140 Gev\n",totalZZ);

			ArrayList<Higgs> higgsData=m.readHiggs(URLHiggs);

			ArrayList<Higgs> higgsZZ = new ArrayList<Higgs>();
			ArrayList<Higgs> higgsGG = new ArrayList<Higgs>();

			for (Higgs item : higgsData){
				if(item.getEventID().equals("GG")){
					higgsGG.add(item);
					eventsGG = eventsGG + 1;
				}
				if(item.getEventID().equals("ZZ")){
					higgsZZ.add(item);
					eventsZZ = eventsZZ + 1;
				}
			}

			//Now creating an empty binsGG array and import the bins from dataGG (low and high)
			//Leaving the events number as 0, which will be filled later from higgsGG
			ArrayList<Background> binsGG = new ArrayList<Background>();
			ArrayList<Background> binsZZ = new ArrayList<Background>();

			for (Background item : dataGG){
				item.setEvents(0);
				binsGG.add(item);
			}
			for (Background item : dataZZ){
				item.setEvents(0);
				binsZZ.add(item);
			}


			//For GG and ZZ: For each of 100 bins:
			// extract each Higgs event one by one, compare it 
			//with Low and High bin, if it belongs to that bin -> counter +1
			// record total number of events per bin


			for (int i=0; i<100;i++){
			for (Higgs event: higgsGG){
					energyHiggs=event.getEventEnergy();
				
					int low = binsGG.get(i).getLowBin();
					int high = binsGG.get(i).getHighBin();
					boolean test = energyHiggs<=high && energyHiggs>=low;
					if (test){
						binsGG.get(i).iEvents();
					}

				}
			for (Higgs event: higgsZZ){
						energyHiggs=event.getEventEnergy();
					
						int low = binsZZ.get(i).getLowBin();
						int high = binsZZ.get(i).getHighBin();
						boolean test = energyHiggs<=high && energyHiggs>=low;
						if (test){
							binsZZ.get(i).iEvents();
						}

					}
			}
		
			
			//creating new arrays with 120-140GeV range
			ArrayList<Background> measuredGG = new ArrayList<Background>();
			ArrayList<Background> measuredZZ = new ArrayList<Background>();
			for (Background item : binsZZ){
				if(item.getLowBin()>=120 && item.getHighBin()<=140){
					measuredZZ.add(item);
					counterZZ = counterZZ + item.getEvents();
				}
			
			}
			
			for (Background item : binsGG){
				if(item.getLowBin()>=120 && item.getHighBin()<=140){
					measuredGG.add(item);
					counterGG = counterGG + item.getEvents();
				}
				
			}
			
			System.out.println("Total GG in 120-140 GeV measured: "+counterGG);
			System.out.println("Total ZZ in 120-140 GeV measured: "+counterZZ);
	
		
			
		
		} 

		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}

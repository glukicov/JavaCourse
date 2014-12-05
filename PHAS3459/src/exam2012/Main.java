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
public class Main {

	//Storing URL variable
	private static final String urlGG ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt";
	private static final String urlZZ ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt";
	private static final String URLHiggs ="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt";


	static double totalZZ=0;
	static double totalGG=0;
	static double eventsZZ=0;
	static double eventsGG=0;
	static double energyHiggs=0;

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

			ArrayList<Background> newGG = new ArrayList<Background>();
			for(Background item1 : dataGG){
				if (item1.getLowBin()>=120 && item1.getHighBin()<=140){
					newGG.add(item1);
					totalGG=totalGG+item1.getEvents();
				}
			}

			ArrayList<Background> newZZ = new ArrayList<Background>();
			for(Background item2 : dataZZ){
				if (item2.getLowBin()>=120 && item2.getHighBin()<=140){
					newZZ.add(item2);
					System.out.println(item2.getEvents());					
					totalZZ=totalZZ+item2.getEvents();
				}
			}


			System.out.printf("Toal GG %10.3f%n",totalGG);
			System.out.printf("Toal ZZ %10.3f%n",totalZZ);

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
			System.out.printf("Total of %10.3f%n GG events ", eventsGG);
			System.out.printf("Total of %10.3f%n ZZ events ", eventsZZ);

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
			//	for (int i=0; i>=binsGG.size();i++){
					energyHiggs=event.getEventEnergy();
				//	System.out.println("energyHiggs= "+energyHiggs);
			//		System.out.println("i= "+i+"\n");
				
					int low = binsGG.get(i).getLowBin();
				//	System.out.println("low= "+low);
					int high = binsGG.get(i).getHighBin();
			//		System.out.println("high= "+high);
					boolean test = energyHiggs<=high && energyHiggs>=low;
			//		System.out.println("test= "+test);
					if (test){
						binsGG.get(i).iEvents();
				//		System.out.println("binsGG.get(i)= "+binsGG.get(i));
					}

				}
			for (Higgs event: higgsZZ){
				//	for (int i=0; i>=binsGG.size();i++){
						energyHiggs=event.getEventEnergy();
					//	System.out.println("energyHiggs= "+energyHiggs);
				//		System.out.println("i= "+i+"\n");
					
						int low = binsZZ.get(i).getLowBin();
					//	System.out.println("low= "+low);
						int high = binsZZ.get(i).getHighBin();
				//		System.out.println("high= "+high);
						boolean test = energyHiggs<=high && energyHiggs>=low;
				//		System.out.println("test= "+test);
						if (test){
							binsZZ.get(i).iEvents();
					//		System.out.println("binsGG.get(i)= "+binsGG.get(i));
						}

					}
			}
			//System.out.println(binsGG);
			//System.out.println(binsZZ);
			
			
			
		
			
			/*
			//Using a custom comparator to sort in acceding order the collection 
			// object by  
			Collections.sort(arrayTiming, new Comparator<DataFormat>() {
				@Override
				public int compare(DataFormat c1, DataFormat c2) {
					return Double.compare(c1.getMass(), c2.getMass());
				}
			});

			 */


		} 

		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}

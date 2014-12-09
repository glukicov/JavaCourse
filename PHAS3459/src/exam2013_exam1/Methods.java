package exam2013_exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 * 
 * @author Gleb
 * This class implements and extends on methods defined in the Interface to be used in Main
 */
public class Methods implements Interface {

	/**
	 * A method....  
	 * @param url
	 * @return data
	 * @throws IOException
	 */
	public void ratio(ArrayList<EventsMass> data, Set<String> triggers){
		ArrayList<EventsRatio> result = new ArrayList<EventsRatio>();

		//
		// Count for all triggers
		double counterSignal=0; // total number of particles in signal
		double counterBackground=0; //total number of particles in backg

		double ratioTotal=0;
		for (String trigger : triggers){
			//Those should be set to 0 again for each new trigger loop
			double sumOfSignal=0;
			double sumOfBackground=0;
			double ratio=0; //sum of s/b
			String name1 = trigger;
			for (EventsMass item : data){
				String name2 = item.getTrigger();
				double mass= item.getMass();
				if(name1.equals(name2)) {
				if(mass>=8 && mass<10){
					sumOfSignal=sumOfSignal+mass;
					counterSignal=counterSignal+1;
				}
				if (mass>=11 && mass<=15){
					sumOfBackground=sumOfBackground+mass;
					counterBackground=counterBackground+1;
				}
			}	
				
			}
			
			ratio=sumOfSignal/sumOfBackground;
			ratioTotal=ratioTotal+ratio;
			result.add(new EventsRatio(name1, ratio));
		}

		
		System.out.println("The total number of particle pairs in the signal region: "+counterSignal+"\n");
		System.out.println("The total number of particle pairs in the background region: "+counterBackground+"\n");
		
		//Using a custom comparator to sort in acceding order the collection 
		// object by  
		Collections.sort(result, new Comparator<EventsRatio>() {
			@Override
			public int compare(EventsRatio c1, EventsRatio c2) {
				return Double.compare(c1.getRatio(), c2.getRatio());
			}
		});
		 System.out.printf("The signal/background ratio for all events combined %.3f",ratioTotal);
		 System.out.println("\n");
		String leftAlignFormat = "| %-11s | %-19s |%n";
        System.out.format("+-------------+---------------------+%n");
        System.out.printf("| Trigger     |  Ratio              |%n");
        System.out.format("+-------------+---------------------+%n");
        Iterator<EventsRatio> EventsRatioItr = result.iterator();
        while (EventsRatioItr.hasNext()) {
        	EventsRatio pSp = EventsRatioItr.next();
                System.out.format(leftAlignFormat, pSp.getTrigger(), pSp.getRatio());
                //System.out.printf("%-23s %13s %13.2f\n", pSp.name, pSp.number, pSp.meanHeight());
        }
        System.out.format("+-------------+---------------------+%n");
        
        
       
        System.out.println("The name of the trigger with the highest signal/background ratio: "+result.get(result.size()-1).getTrigger()+"\n");
	}


	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid)
	 * 
	 *  scan first line of event info
	 *  trim for whitspaces
	 *  for number of tracks giver -> skip the following lines
	 *  read next event line
	 *  
	 */
	public ArrayList<Events> readTriggers(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<Events> data = new  ArrayList<Events>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line)
		//scanner.nextLine();
		//scanner.useDelimiter(",");
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			//Trim for whitesapces if appropriate 
			line.trim();

			Scanner scan = new Scanner(line);
			//scan.useDelimiter(",");
			String E=scan.next(); 
			//	System.out.println("E="+E);
			int tracks=scan.nextInt();
			//	System.out.println("tracks="+tracks);
			String trigger=scan.next(); 
			//		System.out.println("trigger="+trigger);
			data.add(new Events(tracks, trigger));

			for (int i=0; i<tracks; i++) {
				line = scanner.nextLine();

			}
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}




	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 * 
	 * Reading and storing event info
	 * for number of tracks reading and storing event details + event info (same for each event)
	 * 
	 * 
	 */
	public ArrayList<EventsParticles> readPairsEvents(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<EventsParticles>  data = new  ArrayList<EventsParticles>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);


		//Counter variable to
		int eventID=0;
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			eventID=eventID+1;


			line.trim();

			Scanner scan = new Scanner(line);

			String E=scan.next(); 
			//	System.out.println("E="+E);
			int tracks=scan.nextInt();
			//	System.out.println("tracks="+tracks);
			String trigger=scan.next(); 
			//	System.out.println("trigger="+trigger);


			for (int i=0; i<tracks; i++) {

				String linetest =scanner.nextLine();
				//						System.out.println(linetest);

				Scanner testScan = new Scanner(linetest);
				int charge = testScan.nextInt();		
				//					System.out.println(charge);

				double momentum = testScan.nextDouble();		
				//				System.out.println(momentum);

				double theta = testScan.nextDouble();			
				//			System.out.println(theta);

				double phi = testScan.nextDouble();			
				//		System.out.println(phi);

				data.add(new EventsParticles(trigger,tracks, eventID, charge, momentum, theta, phi));
				testScan.close();
			}
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}

	/**
	 * Take each event get its momentum and charge
	 * to ensure only 1 combination - combine for + to - only (q1>0)
	 * 
	 */
	public ArrayList<EventsMass> pairs(ArrayList<EventsParticles> data){
		//New array to store results
		ArrayList<EventsMass> result = new ArrayList<EventsMass>();
		double sum=0;
		for (EventsParticles item1 : data){
			int id1 = item1.getEvent();
			int q1= item1.getCharge();
			//compare with other particle from this event (-) only
			for (EventsParticles item2 : data){
				int id2 = item2.getEvent();
				int q2 = item2.getCharge();
				if (id1==id2 && q1!=q2 && q1>0){
					sum=item1.getMomentum()+item2.getMomentum();

					result.add(new EventsMass(item2.getTrigger(), item2.getTracks(), item2.getEvent(), sum));
				}

			}
		}



		return result;
	}




}

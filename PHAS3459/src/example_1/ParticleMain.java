package example_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ParticleMain {

	//Data url: 
	static String url=("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/particles.txt");
	//Array list to store event
	ArrayList<Event> events = new ArrayList<Event>();
	//Storing triggers 
	HashSet<String> triggers = new HashSet<String>();

	int pairSignal=0;
	int pairBackground=0;

	public static void main(String[] args) {

		//Creating a new instance of that class	
		ParticleMain pm=new ParticleMain();

		try{
			//Parse data is defined in the satic class
			pm.events=parseData(brFromURL(url));

		}
		catch (IOException e){
			System.out.println("An error has occured: " +e.getMessage());
		}

		for(Event evenList : pm.events){
			pm.triggers.add(evenList.trigger);
		}

		try{
			double noiseRatio=triggerCheck(pm.events);
			System.out.println("Total Signal/Noise Ratio: " + noiseRatio);
		} catch (Exception excep) {
			System.out.println("Cannot divide by 0: " + excep.getMessage());
		}

		// Loop over trigger array
		String bestTrigger;
		double bestTriggerRatio = 0;   //todo- loop through and get best
		for (String s : pm.triggers) {
			for (Event e : pm.events) {
				ArrayList<Event> eventsWithTrigger = new ArrayList<Event>();
				if (e.trigger.equals(s)) {
					eventsWithTrigger.add(e);
				}
				try {
					double x = triggerCheck(eventsWithTrigger);
					//  System.out.println("Signal/Noise Ratio for Trigger " + s + " is: " + x);
				} catch (Exception excep) {
					//  System.out.println("Cannot divide by 0: " + excep.getMessage());
				}
			}
		}

	
	}



	private static double triggerCheck(ArrayList<Event> events) {

		int signal=0;
		int background=0;

		for (Event eventList : events){
			for(Particle scann: eventList.Systems){

				if (scann.invMass()  < 10 && scann.invMass() > 8) {
					signal++;
				} else if (scann.invMass() < 15 && scann.invMass() > 11) {
					background++;
				}
			}
		}

		// Always throwing an error because no events passed in => background == 0
		return signal/background;
	}



	private static ArrayList<Event> parseData(BufferedReader brFromURL) {

		ArrayList<Event> event=new ArrayList<Event>();

		Scanner scann=new Scanner(brFromURL);

		while (scann.hasNextLine()){
			//Definition of data handling:
			// "E" -line
			String eventLine=scann.nextLine();
			// Ignore "E"
			Scanner escann=new Scanner(eventLine);
			escann.next();

			//Recording number of events
			int events= (int) Integer.parseInt(escann.next());
			String trigger=escann.next();
			escann.close();

			//Array to store event lines
			Particle[] particles = new Particle[events];

			//Looping over each line:
			for (int i=0; i<events; i++){
				String dataLine=scann.nextLine();
				Scanner datascann=new Scanner(dataLine);

				Integer charge = Integer.parseInt(datascann.next());
				Double momentum = Double.parseDouble(datascann.next());
				Double theta = Double.parseDouble(datascann.next());
				Double phi = Double.parseDouble(datascann.next());
				datascann.close();
				particles[i] = new Particle(charge, momentum, theta, phi);
			}
			Event eventList=new Event(events, trigger, particles);
			System.out.println("Even List"+eventList.toString());
			event.add(eventList);

		}
		scann.close();
		System.out.println("Event"+event.toString());
		
		return event;

	}


	//buffered reader method
	public static BufferedReader brFromURL(String someURL) throws IOException{
		URL u=new URL(someURL);
		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}

}

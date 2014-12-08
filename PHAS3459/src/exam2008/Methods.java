package exam2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * 
 * @author Gleb
 * This class implements and extends on methods defined in SelectMethods interface to be used in Main
 */
public class Methods implements Interface {

	/**
	 * A method generating random -1 to 1 float 
	 *
	 */
	public float randomTrig(){
		Random rand=new Random(); 
		int sign=rand.nextInt(2);
		float val = rand.nextFloat();

		if (sign==0){
			val=-val;
		}
		return val;
	}



	/**
	 * Basically, user specify how long (time) and for how many particle movements
	 *  (i.e. Steps) user desire the simulation to run on particle
	 *  <p>
	 *  
	 *  The simulation outputs (screen/array/file) the times, x, y,z
	 *  
	 *  <p>
	 * 
	 * @param time - specified time interval for simulation
	 * @param steps - number of time increments (that is how many time particle moves in specified time)
	 * @throws Exception -Throw Exception for negative timestep 
	 */
	public ArrayList<Particle> simulate(double time, double steps, double distance) throws Exception {
		// Throw Exception for negative timestep

		if ( time <= 0 || steps <=0 ) {
			throw new Exception("Timestep must be greater than zero.");
		}
		//Creating an object p, to access the non-static methods from that class
		Particle p = new Particle();
		Methods m= new Methods();
		ArrayList<Particle> data = new ArrayList<Particle>();
		//Finding the time increment
		double dt=time/steps;
		double dT=0;
		//starting from after the first movement 
		for (double t=dt; t<=time; t=t+dt){

			double dx=(m.randomTrig())/2*Math.cos(Math.PI*m.randomTrig());
			double dy=(m.randomTrig())/2*Math.sin(Math.PI*m.randomTrig());;
			double dz=m.randomTrig();

			p.setX(dx);
			p.setY(dy);
			p.setZ(dz);
			;
			double x= +p.getX();
			double y= p.getY();
			double z=p.getZ();
			data.add(new Particle(t,x,y,z));
		}
		return data;
	}









	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<DataFormat> readData(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<DataFormat> data = new  ArrayList<DataFormat>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line)
		scanner.nextLine();
		//scanner.useDelimiter(",");
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			//Trim for whitesapces if appropriate 
			line.trim();

			Scanner scan = new Scanner(line);

			String name=scan.next(); 
			//System.out.println("name=" +name);

			double x=scan.nextDouble();
			//System.out.println("year= "+year);
			double y=scan.nextDouble();
			//System.out.println("method ="+method);
			double z=scan.nextDouble(); 
			//	System.out.println("mass= "+mass);
			
			data.add(new DataFormat(name, x, y, z));
			
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}

}

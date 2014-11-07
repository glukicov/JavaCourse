package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Minerals {

	public static void main(String[] args) {

		//Data(code, mass): 
		String sampleURL=("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
		// Location(location (word), code):
		String locationURL=("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");

		//Initialising variables:
		double minMass=Double.MAX_VALUE;
		double maxMass=Double.MIN_VALUE;
		int minID=0;
		int maxID=0;

		//Initialising Hashmaps
		HashMap<Integer, String> locations = new HashMap<Integer, String>();
		HashMap<Integer, Double> samples = new HashMap<Integer, Double>();


		try{
			//Analysing though samples
			BufferedReader brSample=brFromURL(sampleURL);
			Scanner scannerSample = new Scanner(brSample);
			while(scannerSample.hasNext()){
				int id = scannerSample.nextInt();
				double mass=scannerSample.nextDouble(); 
				samples.put(id,mass);
				// Data comparison: 
				if (mass < minMass) {
					minMass = mass;
					minID = id;
				}
				if (mass > maxMass) {
					maxMass = mass;
					maxID = id;
				}
			}
		scannerSample.close();

		//Analysing though locations
		BufferedReader brLoc=brFromURL(locationURL);
		Scanner scannerLoc = new Scanner(brLoc);

		//Data handling description using regular expressions
		while(scannerLoc.hasNext()){
			String location =scannerLoc.next("[a-zA-Z]*") ;
			locations.put(scannerLoc.nextInt(),location);

		}
		scannerLoc.close();
	}
	catch (IOException e){
		System.out.println("An error has occured: " +e.getMessage());
	}

	System.out.println("Samples: "+samples+"\n");
	System.out.println("Locations: "+locations+"\n");

	System.out.println("Largest mass of a sample: ID= "+maxID+ ", mass= "+maxMass+ " /g, location="+locations.get(maxID)+"\n");
	System.out.println("Smallest mass of a sample: ID= "+minID+ ", mass= "+minMass+ " /g, location="+locations.get(minID)+"\n");

	//TO-DO later: Combining Hashmas into 1 with 3 objects is it possible
	//or use other collection like:
	/*		HashMap<Integer, Double, String>combined = new HashMap();
		combined.putAll(samples);
		combined.putAll(locations)
	 */

}

//Reusing buffered reader from module 4
static BufferedReader brFromURL(String someURL) throws IOException{
	URL u=new URL(someURL);
	//Opening an input stream to read some number of bytes and wrapping it into a buffer
	InputStream is=u.openStream();
	InputStreamReader isr = new InputStreamReader(is);
	return new BufferedReader(isr);
}


}

package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MineralsWithArrayList {

	public static void main(String[] args) {

		//Data(code, mass): 
		String sampleURL=("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
		// Location(location (word), code):
		String locationURL=("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");

		//Initialising variables:
		//double minMass=Double.MAX_VALUE;
		//double maxMass=Double.MIN_VALUE;
		//int minID=0;
		//int maxID=0;

		//Initialising Hashmaps
		ArrayList<Locations> locations = new ArrayList<Locations>();
		ArrayList<Samples> samples = new ArrayList<Samples>();

		try{
			
			//Analysing though samples
			locations=locFromURL(locationURL);
			samples=dataFromURL(sampleURL);
			
			Collections.sort(samples, new Samples.compare());	
	

	}
	catch (IOException e){
		System.out.println("An error has occured: " +e.getMessage());
	}

	System.out.println("Samples: "+samples.toString()+"\n");
	System.out.println("Locations: "+locations+"\n");
	
	
	
	System.out.println("Samples after sorting: "+samples.toString()+"\n");
	//System.out.println("Samples after sorting: "+samples+"\n");
	
	

//	System.out.println("Largest mass of a sample: ID= "+maxID+ ", mass= "+maxMass+ " /g, location="+locations.get(maxID)+"\n");
//	System.out.println("Smallest mass of a sample: ID= "+minID+ ", mass= "+minMass+ " /g, location="+locations.get(minID)+"\n");

	//TO-DO later: Combining Hashmas into 1 with 3 objects is it possible
	//or use other collection like:
	/*		HashMap<Integer, Double, String>combined = new HashMap();
		combined.putAll(samples);
		combined.putAll(locations)
	 */

}

//Reusing buffered reader from module 4
	static ArrayList<Samples> dataFromURL(String someURL) throws MalformedURLException, IOException{
		ArrayList<Samples> arrayList=new ArrayList<Samples>(); 
		URL u=new URL(someURL);
		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		Scanner s=new Scanner(br);
		while(s.hasNext()){
			arrayList.add(new Samples(s.nextInt(), 
					s.nextDouble()));
		}
		s.close();
		return arrayList;
	}

	static ArrayList<Locations> locFromURL(String someURL) throws MalformedURLException, IOException{
		ArrayList<Locations> arrayList=new ArrayList<Locations>(); 
		URL u=new URL(someURL);
		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		Scanner s=new Scanner(br);
		while(s.hasNext()){
			String location =s.next("[a-zA-Z]*") ;
			arrayList.add(new Locations(location, 
					s.nextInt()));
		}
		s.close();
		return arrayList;
	}
	
	
}

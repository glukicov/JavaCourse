package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
			
			//Collections.sort(samples);	
	
			
			
			
			//This method works for sorting out array list for doubles (mass) 
			Collections.sort(samples, new Comparator<Samples>() {
			    @Override
			    public int compare(Samples c1, Samples c2) {
			        return Double.compare(c1.getMass(), c2.getMass());
			    }
			});
			
			
			
			
			
			
			

	}
	catch (IOException e){
		System.out.println("An error has occured: " +e.getMessage());
	}

	System.out.println("Samples: "+samples.toString()+"\n");
	System.out.println("Locations: "+locations+"\n");
	
	
	
	System.out.println("Samples after sorting: "+samples.toString()+"\n");
	//System.out.println("Samples after sorting: "+samples+"\n");
	
	System.out.println("The length of array"+ samples.size());		
	System.out.println("The lightest element:" +samples.get(0).getMass());	
	Object lightest=samples.get(0);
//	System.out.println("The lightest mass:"+lightest.);
	
	int maxID=samples.get(528).getCode();
	int minID=samples.get(0).getCode();
	
	// /g, location="+locations.get(maxID)+"\n"
	//  /g, location="+locations.get(minID)+"\n"

	
										//Implementing search though locations list array to find a specific location
	
	
	
	 int x = maxID;
	 System.out.println("x"+x);
	 int index2=locations.indexOf(x);
	 System.out.println("index 2=" +index2);
	 int index=Collections.binarySearch(locations, x);

	   int liVal = -1;
	   for(int i=0; i<locations.size();i++)
	       if(x < locations.get(i).getCode()) // if we met a value > x
	       {
	          if(liVal==-1) // if we could not find any largest value smaller than x
	              liVal = locations.get(i).getCode(); // return the value > x
	          break;
	       }
	       else if(x > locations.get(i).getCode()) // find the largest value smaller than x, 
	       {
	           if(liVal < locations.get(i).getCode())
	               liVal = locations.get(i).getCode();
	       }

	System.out.println(liVal);
	
	
	
	
	
	
	
	
	
	
	
	System.out.println("Largest mass of a sample: ID= "+samples.get(528).getCode()+ ", mass= "+samples.get(528).getMass());
	System.out.println("Smallest mass of a sample: ID= "+samples.get(0).getCode()+ ", mass= "+samples.get(0).getMass());

	
	
	
	
	
	
	
	
	
	
//	int index = locations.indexOf(28);
//	System.out.println("index="+index);
	
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

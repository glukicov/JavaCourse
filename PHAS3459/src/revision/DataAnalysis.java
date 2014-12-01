package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import module5.DataPoint;
import module5.Theory;

public class DataAnalysis {

	public static void main(String[] args) {

		String url=("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		//Initialising an array list:

		try{		
			ArrayList<DataPoint> data=new ArrayList<DataPoint>(); 
			data=dataFromURL(url);
			System.out.println(data);
			Theory n2=new Theory(2);
			Theory n4=new Theory(4);

			double chi2 = goodnessOfFit(n2, data);
			double chi4 = goodnessOfFit(n4, data);

			System.out.println("Chi squared test with n=2: "+chi2);
			System.out.println("Chi squared test with n=4: "+chi4);

			if(chi2>chi4){
				System.out.println("y=x^4 better describes the data");
			}
			else{
				System.out.println("y=x^2 better describes the data");
			}


		}
		catch (Exception e){
			System.out.println("An error has occured: " +e.getMessage());
		}

		


	}



	static ArrayList<DataPoint> dataFromURL(String someURL) throws MalformedURLException, IOException{
		ArrayList<DataPoint> arrayList=new ArrayList<DataPoint>(); 
		URL u=new URL(someURL);
		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		Scanner s=new Scanner(br);
		while(s.hasNextDouble()){
			arrayList.add(new DataPoint(s.nextDouble(), 
					s.nextDouble(),s.nextDouble()));
		}
		s.close();
		return arrayList;
	}
	
	static double goodnessOfFit(Theory theory, ArrayList<DataPoint> experiment)throws IOException{
		double chi=0;
		Iterator<DataPoint> point = experiment.iterator();
		while (point.hasNext()){
			DataPoint scan = point.next();
			chi+=Math.pow(scan.getY()-theory.y(scan.getX()),2)/Math.pow(scan.getEy(), 2);
		}
		return chi;
	}
}




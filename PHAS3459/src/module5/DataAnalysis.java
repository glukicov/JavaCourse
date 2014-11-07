package module5;

import java.io.*;
import java.net.*;
import java.util.*;

public class DataAnalysis {

	//Data: http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt

	public static void main(String[] args) {
		try{
			ArrayList<DataPoint> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			System.out.println(data);

			//Setting n-values on theory class for n= 2 and 4
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

	static ArrayList<DataPoint> dataFromURL(String url)throws IOException{
		//Initialising array list
		ArrayList<DataPoint> data=new ArrayList<DataPoint>();

		URL u=new URL(url);
		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		//Using scanner to conveniently go through and append data to the array list
		Scanner scanner = new Scanner(br);

		//Data handling description (x, y, ey)...
		while(scanner.hasNextDouble()){
			data.add(new DataPoint(scanner.nextDouble(), 
					scanner.nextDouble(),scanner.nextDouble()));
		}
		//Explicitly closing the scanner
		scanner.close();
		return data;
	}

	//Static Chi^2 method:
	static double goodnessOfFit(Theory theory, ArrayList<DataPoint> experiment)throws IOException{
		double chi=0;
		Iterator<DataPoint> point = experiment.iterator();
		while (point.hasNext()){
			DataPoint scan = point.next();
			chi+=Math.pow(scan.getY()-theory.y(scan.getX()),2)/Math.pow(scan.getEY(), 2);
		}
		return chi;
	}


}

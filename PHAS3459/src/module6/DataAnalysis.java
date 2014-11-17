package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class DataAnalysis {

	static String dataURL="http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt";

	public static void main(String[] args) {

		//////////////////////////////////////////
		
		try{
			ArrayList<DataPoint> data = new ArrayList<DataPoint>();	
			//storing the data inside the ArrayList with custom object definition by DataPoint class
			data = dataFromURL(dataURL);

			//Printing out each data point, depending on the presence of the label: Each data point 
			// will be added to the list as a LabelledDataPoint (subclass of DataPoint) if it has a label, and a DataPoint otherwise.
			for (DataPoint i:data){
				System.out.println(i);
			}
		}
		catch (Exception e){System.out.println("An error has occured: " +e.getMessage());}

		finally {System.out.println("Task execution has finished!");}


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

		while(scanner.hasNextLine()){

			//Store a line as a string
			String line = scanner.nextLine();
			

			//Opening new scanner to parse through a line
			Scanner scanLine = new Scanner(line);

			//Parsing and storing the variables to be added to array
			Double x = Double.parseDouble(scanLine.next());
			Double y = Double.parseDouble(scanLine.next());
			Double ey = Double.parseDouble(scanLine.next());
			String label = null;

			//Checking for the presence of the label (4th "next" position)
			if (scanLine.hasNext()){
				label=scanLine.next();
				//or null otherwise
			}
			//Closing the line scanner
			scanLine.close();
			
			//For each scanned line:
			//If there is a label -use LabelledDataPoint class
			//otherwise use DataPoint to put a point into data array
			
			if (label !=null) {
				LabelledDataPoint point = new LabelledDataPoint (x, y, ey, label);
				data.add(point);
			}
			else {
				DataPoint point = new DataPoint (x, y, ey);
				data.add(point);
			}
			
		}
		//Explicitly closing the scanner
		scanner.close();
		return data;

	}
	////////////////////
	
	private static Theory bestTheory(Collection<DataPoint> data, 
            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
        boolean first = true;
        double bestGoodnessOfFit = 0.0;
        Theory bestTheory = null;
        for (Theory theory : theories) {
            double gof = gofCalculator.goodnessOfFit(data, theory);
            if (first) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
                first = false;
            } else if (gof < bestGoodnessOfFit) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
            }
        }
        return bestTheory;
    }





}

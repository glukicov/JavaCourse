package module4;

import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {

	//Initialising the variables
	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues;

	//Explicitly declaring pw (and fw) variable so it can be used
	//by different methods: Class Level Scope
	private PrintWriter pw;
	private FileWriter  fw;

	public static void main(String[] args){

		// Constructor to create the new instance (object) of this class
		NumericalReader nr=new NumericalReader();
		try{
			/*+++++++ Chose ONE (!) of the following inputs by 'uncommenting' +++++++*/	
			BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			/* OR */
			//BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			/* OR */
			//BufferedReader br = brFromFile("C:/Users/G/Documents/PHYSICS/test3.txt");
			/*+++++++ End of input choise +++++++ */

			nr.analysisStart(); // initialising values

			String line; //Creating an empty string;


			while ((line = br.readLine()) != null) { 
				try{
					nr.analyseData(line); // analyse each line and check for comments
				}
				catch (IOException e){
					System.out.println("An error has occured: " +e.getMessage());
				}
			}

			nr.analysisEnd(); // print out the results

		}
		catch (IOException e){
			System.out.println("An error has occured: " +e.getMessage());
		}
	}


	/* Methods defining I/O */

	static BufferedReader brFromURL(String someURL) throws IOException{
		URL u=new URL(someURL);
		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		InputStream is=u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}

	static BufferedReader brFromFile(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		return new BufferedReader(fr);
	}


	/* Methods defining Data Analysis */

	void analysisStart()throws IOException{
		//Setting up method to write the results to a file
		//Here we are using PrintWriter to wrap the FileWriter
		String outputFilePath = "N:/Users/G/Documents/PHYSICS/numbers.txt";
		fw = new FileWriter(outputFilePath);
		BufferedWriter bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		minValue=Double.MAX_VALUE; // otherwise it will always stay zero...

	}
	void analyseData(String s)throws IOException{
		//Setting up methods to analyse each line of the input file
		Scanner scanner = new Scanner(s);

		//Definition of data handling
		try{
			//Checking for empty lines
			if(!s.isEmpty() && s != null){
				// Trimming whitespace
				if(!Character.isDigit(s.charAt(0))){
					s.trim();
				}
				// Determines whether the specified char value is a digit
				if(Character.isDigit(s.charAt(0))){

					while(scanner.hasNextDouble()){
						//Summing total number of numbers
						nValues++;
						String str = scanner.next();

						//Sum of all numbers
						sumOfValues +=  Double.parseDouble(str);
						//Printing numbers to the file
						pw.println((double) Double.parseDouble(str));
						//Printing numbers to the screen
						System.out.println(Double.parseDouble(str));
				
						//Comparing each scanned digit with local variables
						if(Double.parseDouble(str) < minValue) {
							minValue = Double.parseDouble(str);
						}

						if(Double.parseDouble(str) > maxValue) {
							maxValue = Double.parseDouble(str);
						}
					}
				}
			}
			//Explicitly closing the scanner
			scanner.close();
		}
		catch (Exception e){
			System.out.println("An error has occured: " +e.getMessage());
		}
	}


	void analysisEnd()throws IOException{
		//Printing the final results to the screen
		final double average = sumOfValues/nValues;
		System.out.println("The minimum value= "+minValue);
		System.out.println("The maximum value= "+maxValue);
		System.out.format("The average value=%10.4f%n",average);
		System.out.println("The total number of values= "+nValues);

		//If we also wanted to printing the final results to the file (outputFilePath)
		//pw.println("The minimum value= "+minValue);
		//etc..
		//and we would close PrintWriter HERE to force the flushing of a an unfilled Buffer
		//and print results to the file
		pw.close();
	}	

}

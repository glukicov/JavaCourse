package module4;

import java.io.*;			// For BufferedReader, InputStreamReader, InputStream, FileReader 
import java.net.URL;		// For URL
import java.util.Scanner;	// For Scanner

public class NumericalReader {

	// Private variables to keep track of values read in
	private double maxValue, minValue, sumOfValues, meanValue;
	private int nValues;
	private String fileName;

	// Return BufferedReader from URL
	public static BufferedReader brFromURL(String urlName) throws IOException {

		// Create InputStream from URL object
		URL u = new URL(urlName);
		InputStream is = u.openStream();

		// Create BufferedReader from InputStreamReader object 
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;

	}

	// Return BufferedReader from filename
	public static BufferedReader brFile(String fileName) throws IOException {

		// Instantiate FileReader object from filename
		FileReader fr = new FileReader(fileName);

		// Return BufferedReader object from FileReader
		BufferedReader br = new BufferedReader(fr);
		return br;

	}

	// Start number analysis: create file and initialise variables
	// Note that this is a more complex version of analysisStart 
	// than the one that is asked for so that more than one file
	// can be created.
	private void analysisStart(String dataFile) throws IOException {

		// Find user home directory
		String userHome = System.getProperty("user.home");

		// Store data file in user home directory
		this.fileName = (userHome + File.separator + dataFile);

		// Create file
		System.out.println("Creating file " + this.fileName);
		System.out.println();
		FileWriter f = new FileWriter(this.fileName);
		BufferedWriter b = new BufferedWriter(f);
		b.close();

		// Initialise variables
		this.maxValue = 0;
		this.minValue = 0;
		this.nValues = 0;
		this.sumOfValues = 0;
		this.meanValue = 0;

	}

	// Version of analysisStart to use default filename
	private void analysisStart() throws IOException {
		this.analysisStart("numbers.txt");
	}

	// Analyse data for each line
	private void analyseData(String lineIn) throws Exception {

		// Check if line actually has any data in it
		if ( lineIn.isEmpty() ) {
			return;
		}
		// Check if line starts with a letter and is commented out
		else if ( Character.isLetter( lineIn.charAt(0) ) ) {
			return;
		}
		else {

			// Instantiate Scanner with line data String
			Scanner s = new Scanner(lineIn);

			// Step through numbers in line
			while (s.hasNextDouble() ) {

				// Read out next number
				double curValue = s.nextDouble();

				// If no values read, initialise minValue and maxValue
				if (this.nValues == 0) {
					this.maxValue = curValue;
					this.minValue = curValue;
				}

				// Update running total for nValues, sumOfValues
				this.nValues ++;
				this.sumOfValues += curValue;

				// Only update maxValue if curValue is bigger than previous maxValue
				if (curValue > this.maxValue) {
					this.maxValue = curValue;
				}

				// Only update minValue if curValue is smaller than previous minValue
				if (curValue < this.minValue) {
					this.minValue = curValue;
				}

				// Display value on screen
				System.out.println(curValue);

				// Instantiate FileWriter, BufferedWriter and PrintWriter objects for writing data to file
				FileWriter f = new FileWriter(this.fileName, true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter pw = new PrintWriter(b);

				// Write number to file
				pw.println(curValue);
				pw.close();

			}
			
			// Close Scanner
			s.close();

		}
	}

	// Display final values
	private void analysisEnd() {

		this.meanValue = this.sumOfValues/this.nValues;
		System.out.println();
		System.out.println("Final data values:");
		System.out.println("Maximum Value: "+this.maxValue);
		System.out.println("Minimum Value: "+this.minValue);
		System.out.println("Number of Values: "+this.nValues);
		System.out.println("Mean Value: "+this.meanValue);
		System.out.println("Sum of all Values: "+this.sumOfValues);
		System.out.println();

	}

	public static void main(String[] args) {

		// Insantiate NumericalReader object for file
		// http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt
		NumericalReader nr = new NumericalReader();
		try {
			nr.analysisStart(); // initialize minValue etc.
			BufferedReader reader = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			String line = "";
			System.out.println("Reading data values:");
			while ((line = reader.readLine()) != null) {
				nr.analyseData(line); // analyze lines, check for comments etc.
			}
		}
		catch (Exception e) {
			System.out.println("Error in NumericalReader: ");
			e.printStackTrace();
		}

		nr.analysisEnd(); // print min, max, etc.

		// Insantiate second NumericalReader object for file
		// http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt
		NumericalReader nr2 = new NumericalReader();
		try {
			nr2.analysisStart("numbers2.txt"); // initialize minValue etc.
			BufferedReader reader = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			String line = "";
			System.out.println("Reading data values:");
			while ((line = reader.readLine()) != null) {
				nr2.analyseData(line); // analyze lines, check for comments etc.
			}
		}
		catch (Exception e) {
			System.out.println("Error in NumericalReader: ");
			e.printStackTrace();
		}

		nr2.analysisEnd(); // print min, max, etc.

		// Insantiate third NumericalReader object for file
		// http://www.hep.ucl.ac.uk/undergrad/3459/data-extra/module4/module4_data3.txt
		NumericalReader nr3 = new NumericalReader();
		try {
			nr3.analysisStart("numbers3.txt"); // initialize minValue etc.
			BufferedReader reader = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data-extra/module4/module4_data3.txt");
			String line = "";
			System.out.println("Reading data values:");
			while ((line = reader.readLine()) != null) {
				nr3.analyseData(line); // analyze lines, check for comments etc.
			}
		}
		catch (Exception e) {
			System.out.println("Error in NumericalReader: ");
			e.printStackTrace();
		}

		nr3.analysisEnd(); // print min, max, etc.

	}

}
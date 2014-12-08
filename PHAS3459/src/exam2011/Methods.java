package exam2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * 
 * @author Gleb
 * This class implements and extends on methods defined in SelectMethods interface to be used in Main
 */
public class Methods implements Interface {

	/**
	 * A method....  
	 * @param url
	 * @return data
	 * @throws IOException
	 */


	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<Pop> readPopulations(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<Pop> data = new ArrayList<Pop>();
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
			String key=scan.next(); 
			//System.out.println("name=" +name);
			int value=scan.nextInt(); 
			//System.out.println("method ="+method);

			//	add this variables to the collection object
			data.add(new Pop(key, value));

			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}	


	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<Reg> readRegions(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<Reg> data = new  ArrayList<Reg>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line)
		scanner.nextLine();
		scanner.useDelimiter(",");
		//scanner.useDelimiter(",");
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			//Trim for whitesapces if appropriate 
			line.trim();

			Scanner scan = new Scanner(line);
			scan.useDelimiter(",");
			String key=scan.next(); 
			//System.out.println("name=" +name);
			String value=scan.nextLine(); 
			//System.out.println("method ="+method);

			//	add this variables to the collection object
			data.add(new Reg(key, value));

			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}


	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<AB> readAB(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<AB> data = new  ArrayList<AB>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line)
		//scanner.nextLine();
		//scanner.useDelimiter(",");
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			//Trim for whitesapces if appropriate 
			line.trim();

			Scanner scan = new Scanner(line);
			String code=scan.next(); 
			//System.out.println("name=" +name);
			int a=scan.nextInt();
			//System.out.println("year= "+year);
			int b=scan.nextInt();

			//	add this variables to the collection object
			data.add(new AB(code, a, b));
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}

	/**
	 * A method to read the data using a buffer from a URL address (input),
	 * scan through the data and store it a collection object (output)
	 * @param url as a string (e.g. www.google.com)
	 * @return data as a collection object
	 * @throws IOException (e.g. thrown if URL is not valid) 
	 */
	public ArrayList<XYZ> readXYZ(String url) throws IOException {
		//taking a URL (string) as an input
		URL u = new URL(url);
		//Opening stream to read bytes
		InputStream is = u.openStream();
		//Opening steam to read characters
		InputStreamReader isr = new InputStreamReader(is);
		// Creating BufferedReader from InputStreamReader object to read lines
		BufferedReader br = new BufferedReader(isr);
		//Creating an empty collection object to hold the data
		ArrayList<XYZ> data = new  ArrayList<XYZ>();
		String line;
		//Creating a scanner to look though data 
		Scanner scanner = new Scanner(br);
		//Move to next line (consume the whole line)
		//scanner.nextLine();
		//scanner.useDelimiter(",");
		//Looping over all lines, one by one
		//and store the appropriate elements in temporary variables
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			//System.out.println("line=" +line);

			//Trim for whitesapces if appropriate 
			line.trim();

			Scanner scan = new Scanner(line);
			String code=scan.next(); 
			//System.out.println("name=" +name);
			int x=scan.nextInt();
			//System.out.println("year= "+year);
			int y=scan.nextInt();
			int z=scan.nextInt();
			//	add this variables to the collection object
			data.add(new XYZ(code, x, y, z));
			//Explicitly closing and flushing the scanner
			scan.close();
		}
		//Explicitly closing and flushing the scanner
		scanner.close();
		return data;
	}



	/**
	 * A method that takes in the array AB and return the region and its statstic as array
	 * for each disease  
	 */
	public ArrayList<Result> poissonALLA(ArrayList<AB> data, ArrayList<Pop> population, ArrayList<Reg> regions) throws IOException {
		// new list to store the resutls
		ArrayList<Result> result = new ArrayList<Result>();
		//Create the min value to find the lagest from the sample
		double max=Double.MIN_VALUE;
		double S=0;
		double number=0;
		String name=null;
		//For each of the AB data point for A only:
		for (AB item: data){
			//Get code:
			String codeData = item.getCode();
			//For each of the population:
			for (Pop pop: population){
				//Get code:
				String codePop = pop.getCode();
				//If both are equal - do the maths
				if(codePop.equals(codeData)){
					//Get the poisson sig.
					S=(item.getA()-pop.getPopulation()*Main.occA)/Math.sqrt(pop.getPopulation()*(Main.occA));

					max=S;
					//Get measured x
					number = item.getA();

					//Find the name form code
					for (Reg reg : regions){
						String regCode=reg.getCode();
						if (regCode.equals(codePop)){
							name=reg.getName();

						}
					}

				}
			}
			result.add(new Result(name,number,S));
		}

		//Now sort and get the biggest stat sig:
		Collections.sort(result, new Comparator<Result>() {
			@Override
			public int compare(Result c1, Result c2) {
				return Double.compare(c1.getY(), c2.getY());
			}
		});

		ArrayList<Result> finalResult = new ArrayList<Result>();
		finalResult.add(result.get(result.size()-1));

		return finalResult;
	}



	/**
	 * A method that takes in the array AB and return the region and its statstic as array
	 * for each disease  
	 */
	public ArrayList<Result> poisson(ArrayList<AB> data, ArrayList<Pop> population, ArrayList<Reg> regions) throws IOException {
		// new list to store the resutls
		ArrayList<Result> result = new ArrayList<Result>();
		//Create the min value to find the lagest from the sample
		//For each of the AB data point for A only:
		for (AB item: data){
			//Get code:
			String codeData = item.getCode();
			//For each of the population:
			for (Pop pop: population){
				//Get code:
				String codePop = pop.getCode();
				//If both are equal - do the maths
				if(codePop.equals(codeData)){
					//Get the poisson sig.
					double S=(item.getA()-pop.getPopulation()*Main.occA)/Math.sqrt(pop.getPopulation()*(Main.occA));
					//Get measured x
					double number = item.getA();
					//Find the name form code
					for (Reg reg : regions){
						String regCode=reg.getCode();
						if (regCode.equals(codePop)){
							String name=reg.getName();
							result.add(new Result(name,number,S));
						}
					}

				}
			}

		}


		return result;
	}

	public double meanB(ArrayList<AB> data) {
		double sum=0;
		for (AB item: data){
			sum=sum+item.getB();
		}
		double mean = sum/data.size();
		return mean;		
	}
	@Override
	public double meanA(ArrayList<AB> data) {
		double sum=0;
		for (AB item: data){
			sum=sum+item.getA();
		}
		double mean = sum/data.size();
		return mean;		
	}


	@Override
	public double stdA(ArrayList<AB> data, double meanA) {
		double sum=0;
		for (AB item: data){
			double dev=item.getA()*item.getA()-meanA*meanA;
			sum=sum+dev;
		}
		double std = Math.sqrt(sum/data.size());
		return std;
	}


	@Override
	public double stdB(ArrayList<AB> data, double meanB) {
		double sum=0;
		for (AB item: data){
			double dev=item.getB()*item.getB()-meanB*meanB;
			sum=sum+dev;
		}
		double std = Math.sqrt(sum/data.size());
		return std;
	}


	@Override
	public double correlationAB(ArrayList<AB> data, double meanA, double meanB, double stdA, double stdB) {
		double sum=0;
		for (AB item : data){
			double sumI=(item.getA()-meanA)*(item.getB()-meanB)/(data.size()*stdA*stdB);
			sum=sum+sumI;
		}
		return sum;

	}


	@Override
	public ArrayList<AB> filter(ArrayList<AB> data, double meanA) {
		ArrayList<AB> result = new ArrayList<AB>();

		for (AB item : data){
			int a = item.getA();
			int b = item.getB();
			String code= item.getCode();
			if(a>meanA){
				result.add(new AB(code, a, b));
			}
		}


		return result;
	}


	@Override
	public ArrayList<String> select(ArrayList<AB> data, int number, ArrayList<Reg> regions) {
		ArrayList<AB> result = new ArrayList<AB>();
		//Same of AB
		Collections.sort(data, new Comparator<AB>() {
			@Override
			public int compare(AB c1, AB c2) {
				return Double.compare(c1.getA(), c2.getA());
			}
		});

		for (int i=0; i<=number; i++){

			result.add((data.get(i)));
			result.add((data.get(data.size()-1-i)));
		}

		//Same of AB
		Collections.sort(result, new Comparator<AB>() {
			@Override
			public int compare(AB c1, AB c2) {
				return Double.compare(c1.getA(), c2.getA());
			}
		});

		//Now getting names:
		ArrayList<String> names = new ArrayList<String>(); 
		
		for (AB item : result){
			String codeRes=item.getCode();

			for (Reg reg : regions){
				String regCode=reg.getCode();
				if (regCode.equals(codeRes)){
					String name=reg.getName();
					names.add(name);
				}

			}

		}
		return names;
	}
}

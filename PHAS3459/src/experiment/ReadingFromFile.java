package experiment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFromFile {

	public static void main(String[] args) {
		
		try{
			System.out.println("Starting task!");
			printFile("C:/Users/G/Documents/PHYSICS/Year III/PHAS3440 Experimental Physics/Experiment/DATA/data.data");
		}
		catch(Exception e){System.out.println("Error occured "); e.getMessage();}}
	

	public static void printFile(String fileName)
			throws IOException {

		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line=br.readLine()) != null) {
		//	Integer r[]=
		}
		br.close();


	}

}

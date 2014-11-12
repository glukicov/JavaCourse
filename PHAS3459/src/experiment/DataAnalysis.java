package experiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {
		
	public static void main(String[] args) {
		try{
			ArrayList<DataPoint> raw_data = dataFromFile("C:/Users/G/Documents/PHYSICS/Year III/PHAS3440 Experimental Physics/Experiment/DATA/raw_data.data");
			//System.out.println(raw_data);

			// Removing events with t > 40000ns
			for (int i = 0; i < raw_data.size(); i++){
				if (raw_data.get(i).getDecay() >= 40000){
					raw_data.remove(i);
					i--;
				}
			}
			//System.out.println(raw_data);
			
					
			//Printing the data to the file using Object Stream method
			
			try {
				System.out.println("Starting task!");
				File file = new File("C:/Users/G/Documents/PHYSICS/Year III/PHAS3440 Experimental Physics/Experiment/DATA/data.data");
		 
		         // if file doesnt exists, then create it
		         if (!file.exists()) {
		            file.createNewFile();
		         }
		 
		         FileWriter fw = new FileWriter(file.getAbsoluteFile());
		         BufferedWriter bw = new BufferedWriter(fw);
		         PrintWriter pw = new PrintWriter(bw);
		         //set this to the string you are trying to write
		         for (int i=0; i < raw_data.size(); i++)
		         // Converting from ns to us
		         pw.println((raw_data.get(i).toDouble())/1000);
		         bw.close();
		 
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
			
		}
		catch (Exception e){
			System.out.println("An error has occured: " +e.getMessage());
		}
	finally{System.out.println("Task completed!");}
	

	}


	static ArrayList<DataPoint> dataFromFile(String fileName)throws IOException{
		//Initialising array list
		ArrayList<DataPoint> data=new ArrayList<DataPoint>();

		//Opening an input stream to read some number of bytes and wrapping it into a buffer
		FileReader fr = new FileReader(fileName);
		BufferedReader br= new BufferedReader(fr);

		//Using scanner to conveniently go through and append data to the array list
		Scanner scanner = new Scanner(br);

		//Data handling description (decay, time)
		while(scanner.hasNextInt()){
			data.add(new DataPoint(scanner.nextInt()));
			scanner.nextLine();
		}
		//Explicitly closing the scanner
		scanner.close();
		return data;
	}




}

package module4;

import java.io.*;
import java.util.*;

public class ExampleScanner {

	public static void main(String[] args) {

		String file="N:/Eclipse/workspace/test2.txt";

		try{

			BufferedReader r = new BufferedReader(new FileReader(file));
			Scanner s = new Scanner(r);
			double sum = 0;
			double lsum=0;
			while (s.hasNext()) {
				String token = s.next();
				try {
					double x = Double.parseDouble(token);
					sum += x;
				} catch (NumberFormatException e) {
				//	System.out.println("Not a numbers found!");
					lsum =lsum+1;
					// Ignore anything that is not a number!
				}
			}
			System.out.println("sum of all numbers found="+sum);
			System.out.println("Total number of non-numbers="+lsum);
			s.close();

		}
				catch(Exception e){
			System.out.println("Error opening the file");
		}

	}



}

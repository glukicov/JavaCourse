package module4;

import java.io.*;

public class ExampleFileReader {

	public static void main(String[] args) {
		try{
		printFile("N:/Eclipse/workspace/test2.txt");
		}
		catch(Exception e){}
			
		}
	
	
	public static void printFile(String fileName)
				throws IOException {
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line=br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
	}
	}

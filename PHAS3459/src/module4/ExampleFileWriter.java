package module4;

import java.io.*;

public class ExampleFileWriter {
	public static void main(String[] args) throws IOException {

		String filename = "N:/Eclipse/workspace/test2.txt";
	
			FileWriter f = new FileWriter(filename);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter pw = new PrintWriter(b);
			pw.println("Some numbers");
			for (int i=0; i<10; i++) {
				pw.println(i+" "+i*0.1);
			}
			pw.close();




		}
	}

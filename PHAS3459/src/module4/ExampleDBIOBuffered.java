package module4;

import java.io.*;

public class ExampleDBIOBuffered {

	public static void main(String[] args) throws IOException {

		String fileName = "N:/Eclipse/workspace/test3.txt";
	
		FileOutputStream f = new FileOutputStream(fileName);
		BufferedOutputStream b = new BufferedOutputStream(f);
		DataOutputStream d = new DataOutputStream(b);
		for (int i=0; i<100; i++) {
		d.writeDouble(i*0.1);
		}
		d.close();




		}
	}

package module4;

import java.io.*;

public class ExampleDBIOBufferedRead {

	public static void main(String[] args) throws IOException {

		String fileName = "N:/Eclipse/workspace/test3.txt";

		FileInputStream f = new FileInputStream(fileName);
		BufferedInputStream b = new BufferedInputStream(f);
		DataInputStream d = new DataInputStream(b);
		double sum = 0;
		while (true) {
			try {
				double x = d.readDouble();
				sum += x;

			}


			catch (EOFException e) {
				System.out.println("We have reached the end of the file");
				break;
			}
		}
		d.close();
		System.out.println("sum of all numbers found="+sum);


	}
}

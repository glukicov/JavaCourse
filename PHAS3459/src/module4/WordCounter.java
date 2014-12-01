package module4;

import java.io.*; // For BufferedReader, InputStreamReader, InputStream
import java.net.*; // For URL
import java.util.*; // For Scanner

public class WordCounter {

	// Return keyboard input as string using BufferedReader
	public static String getStringFromKeyboard() throws IOException {

		// Instantiate BufferedReader object with keyboard input from InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("Please enter URL:");
		// Convert single BufferedReader line to String
		String keyString = br.readLine();
		//System.out.println("Your URL is: "+keyString);

		return keyString;

	}

	public static int countWordsInResource(String webAddress) throws IOException {

		// Initialise word count variable
		int countWords = 0;

		// Instantiate URL object with web address
		URL u = new URL(webAddress);

		// Instantiate BufferedReader using URL stream
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		// Instantiate Scanner for processing text data
		Scanner s = new Scanner(b);

		// Step through Scanner word by word
		while (s.hasNext()) {
			s.next();
			countWords++;
		}

		// Close Scanner (closes remaining objects)
		s.close();

		return countWords;

	}

	public static void main(String[] args) {

		try {
			// Read URL String from keyboard input
			// Use this URL: http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt
			String keyString = WordCounter.getStringFromKeyboard();

			// Count words in URL
			int countWords = WordCounter.countWordsInResource(keyString);
			System.out.println("Number of words in URL: "+countWords);
		}
		// Catch URL and InputStream Exceptions
		catch (IOException e) {
			System.out.println("Error in WordCounter: ");
			e.printStackTrace();
		}

	}

}
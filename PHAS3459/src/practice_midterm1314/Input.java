package practice_midterm1314;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Map.Entry;

public class Input {
	
	HashMap<Integer, Event> events =  new HashMap<Integer,Event>();
	String URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/particles.txt";
	
	static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}
	
	public HashMap<Integer, Event> recordEvents(String url) throws IOException{
		Scanner sc = scFromURL(url);
		String[] line;
		Integer x = 0;
		while (sc.hasNextLine()) {
			line = sc.nextLine().split("\\s+");
			char id = line[0].charAt(0);
			if (id == 'E') {
				Event e = new Event(line);
				int n = Integer.parseInt(line[1]);
				for (int i=0; i<n; i++) {
					String[] data = sc.nextLine().split("\\s+");
					e.addParticle(data);
				}
				events.put(x,e);
				x++;
			} 
		}
		return events;
	}
	
	public HashMap<Integer, Event> recordEvents() throws IOException {
		return recordEvents(URL);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<Integer, Event>> it = events.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer,Event> pair = (Entry<Integer, Event>)it.next();
			sb.append(pair.getValue()).append('\n');
		}
		return sb.toString();
	}
	
}

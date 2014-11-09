package revision;

import java.util.ArrayList;
import java.util.Iterator;

public class revision { 
	
	public static void main(String[] args) {
				
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello"); // add to end
		list.add("and"); // add to end
		list.add("welcome"); // add to end
		list.add(2,"another"); // add 3 at position 2
		list.set(3,"word");
		String o = list.get(3);
		
		boolean contains_and = list.contains("and");
		int location = list.indexOf("and");
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
		String s = it.next();
		it.remove(); // removes current element
		System.out.println(it.toString());
		}
		
		
		
	}
	
	
}


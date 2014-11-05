package module5;

import java.util.ArrayList;
import java.util.Iterator;

public class ExampleLooping {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello"); // add to end
		list.add("and"); // add to end
		list.add("welcome"); // add to end
		System.out.println("list="+list);
		list.add(2,"another"); // add 3 at position 2
		list.set(3,"word");
		System.out.println("list="+list);
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
		String s = it.next();
		//System.out.println(s);
		it.remove(); // removes current element
		}
	
		for (String word : list) {
			System.out.println(word);
			}
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 10; i > 0; i--) {
		nums.add(i);
		}
	//	Collections.sort(nums);
	}

}

package module5;

import java.awt.Point;
import java.util.ArrayList;


public class ExampleArrayList {

	public static void main(String[] args) {
	
		// Create ArrayList objects
		ArrayList<Point> mypoints = new ArrayList<Point>();
		ArrayList<Integer> mynumbers = new ArrayList<Integer>();
		for (int x = 0; x < 10; x++){
		for (int y = 0; y < 10; y++) {
		Point p = new Point(x,y);
		// Add new objects
		mypoints.add(p);
		mynumbers.add(x*y);
		}
		}
	
		System.out.println(mypoints);
		System.out.println(mynumbers);

		Point p = mypoints.get(2);
		int val = mynumbers.get(11);
		
		System.out.println(p);
		System.out.println(val);
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello"); // add to end
		list.add("and"); // add to end
		list.add("welcome"); // add to end
		System.out.println("list="+list);
		list.add(2,"another"); // add 3 at position 2
		list.set(3,"word");
		System.out.println("list="+list);
		String o = list.get(1);
		list.remove(2);
		list.clear();
		boolean contains_and = list.contains("and");
		int location = list.indexOf("and");
		System.out.println(location);
		System.out.println(contains_and);
		System.out.println(o);
		System.out.println("list="+list);
		
	
	}

}

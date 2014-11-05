package module5;

import java.util.Collections;
import java.util.Comparator;

public class ExampleSortingCollections implements Comparator<Integer> {

	double nums;
	
	public int compare(Integer arg0, Integer arg1) {
		// The compare method must return:
		// 0 : if arg0 is equal to arg1
		// +ve integer : if arg0 > arg1
		// -ve integer : if arg0 < arg1
		return (Math.abs(arg0) - Math.abs(arg1));
	}

// ...




public static void main(String[] args) {
//	Collections.sort(nums, new ExampleSortingCollectionse());
}



}

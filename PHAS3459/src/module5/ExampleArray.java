/*package module5;

public class ExampleArray {
	public static void main(String[] args) {
		// General syntax to declare an array is :
	//	type[] arrayName = new type[length]
		// An array storing two integer values :
		int[]ks = new int[2];
		ks[0] = 45; ks[1] = 46;
		// An array storing 10 Point objects :
		Point[] mypoints = new Point[10];
		mypoints[0] = new Point(10,11);
		mypoints[0].x = 12;
		// ... etc.
		
		
		// Declare an array to store six integers:
		int[] values = new int[6];
		// The following is fine if you know the array’s length:
		for (int i = 0; i <=5; i++) {
		values[i] = i*i;
		}
		// But it’s better to use the array’s "length" variable:
		for (int k = 0; k < values.length; k++) {
		values[k] = values[k]*values[k];
		}
		// The following line will produce an error:
		int ix = values[6];
		
		
		public class myList {
			private int[] data;
			public myList(int[] values) { data = values ;}
			public int[] negativeList() {
			int[] nData = new int[data.length];
			for (int i = 0; i< data.length; ++i){
			nData[i] = -1*data[i];
			}
			return nData;
			}
			// In some other code we might then do :
			int[] data = {0,5,6,7,9,10};
			myList myL = new myList(data);
			int[] nData = myL.negativeList();
			// ... etc.
		
		
			//automatically create an integer array
			// of length 6 and set the values :
			int[] values = {0,1,4,9,16,25};
	}
}
*/
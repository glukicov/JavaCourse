package module1;

public class AlgorithmControl {
	
	public static void loop() { //Creating a void method loop() as defined below:
		int i;
		int f=20;
		for (i=1; i<=f; i++){   // Creating a for loop with logical condition i<=f
			System.out.println("i= "+i); //Whcih prints an incriment of x until x reaches 20
			}
	}
	
	public static void decrement(){ //Creating a void method decrement() as defined below:
		int x=-5;
		while (x<11){  // Creating a while loop which prints value of x until x reaches 11
			System.out.println("x= "+x); // For last print out x is still 10
			x++;  
		}			
	}

	public static void increment(){ //Creating a void method increment to print out values from
									// 2.4 to 14.9 in steps of 0.5
		double inc_val;
		double finish=14.9;
		double step=0.5;
		for(inc_val=2.4; inc_val<=finish; inc_val=inc_val+0.5){
			System.out.println("inc_val= "+inc_val);
		}
		
	}
	
	
	public static void main(String[] args) {
	
	// loop(); //Calling on the loop method
	//	decrement();  //Calling on the decrement method
	//	increment();
		

	}
}


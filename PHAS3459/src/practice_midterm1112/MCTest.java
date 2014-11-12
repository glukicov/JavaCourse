package practice_midterm1112;

import java.util.Scanner;

public class MCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int loopCount=0;
		System.out.println("Starting loop");
		do {
		System.out.println("Loop"+loopCount);
		loopCount++;
		}
		while (loopCount<10);
		
		//int anInt = Integer.parseInt("12.5");
		//System.out.println(anInt);
		
		MCTest mct = new MCTest();
		MCTest mct2 = mct;
		
		try {
			test();
			} catch (Exception e) {
			System.out.println("Exception!");
			} finally {
			System.out.println("Finally");
			}
		
		int i=1;
		Scanner s = new Scanner("exp(0) = 1");
		while (s.hasNext()) {s.next(); i++;}
		System.out.println(i);

	}
	
	public static void test() throws Exception {
		// ...
		}
}

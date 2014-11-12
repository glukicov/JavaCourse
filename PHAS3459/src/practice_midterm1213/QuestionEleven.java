package practice_midterm1213;
import java.util.*;

public class QuestionEleven {
		
	public static void Tuesday() {System.out.println("Tuesday");}
	public void Thursday() {System.out.println("Thursday");}
	public static void main(String[] args) {
		QuestionEleven t = new QuestionEleven();
		// here
		Tuesday();
		//Thursday(); // Can't make non-static reference in static method
		t.Thursday();
		QuestionEleven t2 = t;
		
		int i=0;
		Scanner s = new Scanner("exp(0) = 1");
		while (s.hasNext()) {s.next(); i++;}
		System.out.println(i);

	}
}

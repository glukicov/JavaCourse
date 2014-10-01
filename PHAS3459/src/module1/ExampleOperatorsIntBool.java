package module1;

public class ExampleOperatorsIntBool {

	public static void main(String[] args) {
		
		// and (&), or (|), not (˜)
		// left shift (<<), signed right shift (>>),
		// unsigned right shift (>>>)
		int ia = 1; int ib = 2; int ic;
		ic = ia | ib; // would set value of ic = 3.
		System.out.println(ic);
		ic = ia & ib; // would set value of ic = 0.
		System.out.println(ic);
		ic = ib << 1; // would set value of ic = 4.
		boolean ab = true; boolean bc = false;
		boolean cd = ab | bc; // sets cd to be true.
		
		int a=1; int b=0; int c=0;
		
		// conditional AND (&&)
		// conditional OR (||)
		boolean biggest = (a>b) && (a>c); // Doesn’t check a against c
		System.out.println(biggest);
		// if a is not greater than b.
		boolean notBiggest = (a<b) || (a<c); // Doesn’t check a against c
		// if a is less than b.
		
	}

}

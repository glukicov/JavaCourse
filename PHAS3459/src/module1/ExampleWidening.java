package module1;

public class ExampleWidening {
	public static void main (String args[]) {
		int ix = 123456789;
		int iy = 123456788;
		System.out.println(ix-iy);
		float fx = ix; // this is a widening conversion
		float fy = iy;
		System.out.println(fx-fy);
		// What happens when you make these doubles instead of floats ?
	}
}

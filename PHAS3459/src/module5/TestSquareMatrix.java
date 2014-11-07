package module5;

import java.io.IOException;

public class TestSquareMatrix {
	static SquareMatrix A;
	static SquareMatrix B;
	static SquareMatrix C;
	static SquareMatrix D;
	public static void main(String[] args) throws Exception {

		// Creating matrix-array objects 
		try{
			A = new SquareMatrix(new double[][]
					{{1,0,2},{0,1,0},{-3,0,-1}});
			B = new SquareMatrix(new double[][]
					{{0,0,1},{0,1,0},{-1,0,1}});
			C = new SquareMatrix(new double[][]
					{{4,3},{3,2}});
			D = new SquareMatrix(new double[][]
					{{-2,3},{3,-4}});
		}
		catch (IOException e){
			System.out.println("Matrix releated error has occured: " +e.getMessage());
		}
		
		System.out.println("A+B= "+(A.add(B)));
		System.out.println("A-B= "+B.subtract(A));
		
		System.out.println("AxB= "+A.multiply(B));
		System.out.println("BxB= "+B.multiply(A));
	
	
		System.out.println("[A,B]= "+(A.multiply(B)).subtract(B.multiply(A)));
	
		System.out.println("CxD= "+C.multiply(D));
		System.out.println("Is CxD = I ? :"+(C.multiply(D)).equals(SquareMatrix.unitMatrix(2)));
	}
	
}


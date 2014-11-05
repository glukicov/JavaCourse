package module5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {

	//Initialising Array parameters

	private double [][] array;

	// SquareMatrix Array constructor
	public SquareMatrix(double [][] elements) throws Exception{

		//Handling the size of the array:

		for (int k = 0; k < elements.length; k++) {

			//Here we implement "non-square" matrix exception

			if (elements.length!=Array.getLength(elements[k])){
				throw new Exception("The array passed as an arguement is not a square matrix!");
			}
		}

		array = elements;
	}


	public String toString(){
		//Using string builder to append elements
		StringBuilder z = new StringBuilder();
		for (double[] i : array) {
			z.append(Arrays.toString(i)); 
		}
		return z.toString();
	}

	public static SquareMatrix unitMatrix(int size) throws Exception{
		double[][] array = new double[size][size];
		//Composing a unit matrix
		for(int row=0; row<size; row++){
			for(int col=0; col<size; col++){
				if(row == col){
					array[row][col] = 1;
				}
				else{
					array[row][col] = 0;
				}
			}
		}
		return new SquareMatrix(array);
	}

	//Using Eclipse-built Hash code to compare two objects
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(array, other.array)) {
			return false;
		}
		return true;
	}

	//Creating add, subtract and multiply methods with appropriate exception handling

	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2)throws Exception {
		if (sm1.array.length != sm1.array.length)
			throw new Exception("Two matricies do not have the same size!");

		// Creating a new matrix object

		double sum[][] = new double[sm1.array.length][sm1.array.length];

		// Summation loops:
		for (int r = 0; r < sm1.array.length ; r++) {
			for (int c = 0; c < sm1.array.length; c++) {
				sum[r][c] = sm1.array[r][c] + sm2.array[r][c];
			}
		}
		return new SquareMatrix(sum);
	}

	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2)throws Exception {
		if (sm1.array.length != sm1.array.length)
			throw new Exception("Two matricies do not have the same size!");

		// Creating a new matrix object

		double difference[][] = new double[sm1.array.length][sm1.array.length];

		// Summation loops:
		for (int r = 0; r < sm1.array.length ; r++) {
			for (int c = 0; c < sm1.array.length; c++) {
				difference[r][c] = sm1.array[r][c] - sm2.array[r][c];
			}
		}
		return new SquareMatrix(difference);
	}

	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2)throws Exception {
		if (sm1.array.length != sm1.array.length)
			throw new Exception("Two matricies do not have the same size!");

		// Creating a new matrix object

		double product[][] = new double[sm1.array.length][sm1.array.length];

		// Summation loops:
		for (int r = 0; r < sm1.array.length ; r++) {
			for (int c = 0; c < sm1.array.length; c++) {
				for (int i = 0; i < sm1.array.length; i++) {
					product[r][c] += sm1.array[r][i] * sm2.array[i][c];
				}
			}
		}
		return new SquareMatrix(product);
	}

	//Non-static methods:
	
	SquareMatrix add(SquareMatrix sm2)throws Exception {
		return SquareMatrix.add(this, sm2);
	}

	SquareMatrix subtract(SquareMatrix sm2)throws Exception {
		return SquareMatrix.subtract(this, sm2);
	}
	SquareMatrix multiply(SquareMatrix sm2)throws Exception {
		return SquareMatrix.multiply(this, sm2);
	}
}








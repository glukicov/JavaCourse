package module3; 


import java.util.Random; //Importing class to generate pseudorandom numbers 


// classes belong to lang group are imported by default 



public class Alphabet { 






	private static int sumInt; //Variable to be used for summing integers 


	private static int exceptionNumber; //Total number of exceptions thrown 






	//Method generating random integer [0-127] (ranInt) and returning a character 


	// based on that integer 


	static char randomCharacter(){ 

		int ranInt= new Random().nextInt(128); 


		return (char) ranInt; 


	} 






	public static void main(String[] args) { 






		//creating an empty string object 


		StringBuilder string = new StringBuilder(); 






		//Creating a loop to run 1000 times 


		int i;  


		for (i=1; i<=1000; i++){ 






			//Generating random character 


			char ranChar=randomCharacter(); 






			//Test 


			if(Character.isLetterOrDigit(ranChar)){ 

				
				//If tested passed append this char to string 


				string.append(ranChar); 


			} 


			try{ 


				//Adding number to the running total 


				sumInt+=Integer.parseInt(Character.toString(ranChar)); 


			} 


			//If this produces an error - add this to total number of errors 


			catch (Exception e){ 


				exceptionNumber++; 


			} 






		} 


		//Final Results 


		System.out.println("Contnets of the string: " +string+"\n"); 


		System.out.println("Sum of all the numbers in the string= "+sumInt+"\n"); 


		System.out.println("Number of exceptions thrown by Integer.parseInt()="+exceptionNumber+"\n"); 


	} 


} 

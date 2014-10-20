package module3;

//This code combines the methods employed in TestThreeVectors, TestComplex and ParticleMain classes from module 2,
// where exceptions are to be thrown, because the method fails to execute as intended.

public class TestExceptions {

	public static void main(String[] args) {
		
										// TESTING COMPLEX:
		//passing appropriate variables:
		Complex c1=new Complex(-1, 2);
					
		// Adding exception handling when we call on divide and normalise methods
		System.out.println("TESTING COMPLEX: exception handling");
		System.out.println("c1= "+c1);
		System.out.println("c0= "+Complex.ZERO);
		try {
					System.out.println("c1/c0= "+Complex.divide(c1, Complex.ZERO));
				}
				catch(Exception e){
					System.out.println("c1/0= " +e);
				}

				// Testing the normalise method for c1 and ZERO
				
				try {
					System.out.println("Normalise c0= "+Complex.ZERO.normalised());
				}
				catch(Exception z){
					System.out.println("Normalise c0= " +z);
				}
				System.out.println("\n");

				
										// TESTING ThreeVector:
				//passing appropriate variables:
				ThreeVector v1=new ThreeVector(3,4,1);
				ThreeVector v3=new ThreeVector(0,0,0);

				// Adding exception handling when we call on unitVector and angle methods 
				
				System.out.println("TESTING ThreeVector: exception handling");
				System.out.println("v1= "+v1);
				System.out.println("v3= "+v3);
				try{
					System.out.println("Unit vector of v3= "+v3.unitVector());
				}
				catch (Exception e){
					System.out.println("Unit vector of v3= "+e);
				}
		
				try{
					System.out.println("Angle between v1 and v3= "+ThreeVector.angle(v1,v3));
				}
				catch (Exception e){
					System.out.println("Angle between v1 and v3= "+e);
				}
				System.out.println("\n");

		
											// TESTING FallingPartilce:
				//passing appropriate variables:
			

				// Adding exception handling when we call on constructors and methods in FallingParticle class
				
				System.out.println("TESTING FallingPartilce: exception handling");
	
				//Simulating descent of the particle for dt=0.5
				try{
					FallingParticle fp1=new FallingParticle(0, -5);
					fp1.setZ(10);
					fp1.drop(0.5);
					System.out.println("Time interval=0.5 /s");
					System.out.println("Time taken to reach the bottom="+fp1.getT()+"/s");
					System.out.println("Final velocity at the impact="+fp1.getV()+"/ms^-1\n");
				}
				catch (Exception e){
					System.out.println(e);
				}
				//Setting Initial height




				//Simulating descent of the particle for dt=0.1
				try{
					FallingParticle fp2=new FallingParticle(-1, 2.1);
					//Setting Initial height
					fp2.setZ(10);
					fp2.drop(0.1);
					System.out.println("Time interval= 0.1 /s");
					System.out.println("Time taken to reach the bottom="+fp2.getT()+"/s");
					System.out.println("Final velocity at the impact="+fp2.getV()+"/ms^-1\n");
				}
				catch (Exception e){
					System.out.println(e);
				}

				//Simulating descent of the particle for dt=0.01
				try{
					FallingParticle fp3=new FallingParticle(5.3, -2);
					//Setting Initial height
					fp3.setZ(10);
					fp3.drop(0.01);
					System.out.println("Time interval=0.01 /s");
					System.out.println("Time taken to reach the bottom="+fp3.getT()+"/s");
					System.out.println("Final velocity at the impact="+fp3.getV()+"/ms^-1\n");
				}
				catch (Exception e){
					System.out.println(e);
				}

				//Simulating descent of the particle for dt=0.001
				try{
					FallingParticle fp4=new FallingParticle(5.3, 2.1);
					//Setting Initial height
					fp4.setZ(-10);
					fp4.drop(0.001);
					System.out.println("Time interval=0.001 /s");
					System.out.println("Time taken to reach the bottom="+fp4.getT()+"/s");
					System.out.println("Final velocity at the impact="+fp4.getV()+"/ms^-1\n");
				}
				catch (Exception e){
					System.out.println(e);
				}

	
	
}
}

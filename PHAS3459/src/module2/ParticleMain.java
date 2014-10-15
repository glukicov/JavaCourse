package module2;

public class ParticleMain {

	/* Units m=mass (kg), d=drag coefficient (kg/m), t=time(s), z=vertical position (m)
	// v=velocity in upwards direction (m/s), g=9.81 m/s^2 (acceleration due to gravity) */

	public static void main(String[] args) {

		//Creating a falling paricle object by calling on the constructor
		//from FallingParticle class:



		//Simulating descent of the particle for dt=0.5
		FallingParticle fp1=new FallingParticle(5.3, 2.1);
		//Setting Initial height
		fp1.setZ(10);
		fp1.drop(0.5);
		System.out.println("Time interval=0.5 /s");
		System.out.println("Time taken to reach the bottom="+fp1.getT()+"/s");
		System.out.println("Final velocity at the impact="+fp1.getV()+"/ms^-1\n");



		//Simulating descent of the particle for dt=0.1
		FallingParticle fp2=new FallingParticle(5.3, 2.1);
		//Setting Initial height
		fp2.setZ(10);
		fp2.drop(0.1);
		System.out.println("Time interval= 0.1 /s");
		System.out.println("Time taken to reach the bottom="+fp2.getT()+"/s");
		System.out.println("Final velocity at the impact="+fp2.getV()+"/ms^-1\n");


		//Simulating descent of the particle for dt=0.01
		FallingParticle fp3=new FallingParticle(5.3, 2.1);
		//Setting Initial height
		fp3.setZ(10);
		fp3.drop(0.01);
		System.out.println("Time interval=0.01 /s");
		System.out.println("Time taken to reach the bottom="+fp3.getT()+"/s");
		System.out.println("Final velocity at the impact="+fp3.getV()+"/ms^-1\n");


		//Simulating descent of the particle for dt=0.001
		FallingParticle fp4=new FallingParticle(5.3, 2.1);
		//Setting Initial height
		fp4.setZ(10);
		fp4.drop(0.001);
		System.out.println("Time interval=0.001 /s");
		System.out.println("Time taken to reach the bottom="+fp4.getT()+"/s");
		System.out.println("Final velocity at the impact="+fp4.getV()+"/ms^-1\n");



		//Simulating descent of the particle for dt=0.0001
		FallingParticle fp5=new FallingParticle(5.3, 2.1);
		//Setting Initial height
		fp5.setZ(10);
		fp5.drop(0.0001);
		System.out.println("Time interval=0.0001 /s");
		System.out.println("Time taken to reach the bottom="+fp5.getT()+"/s");
		System.out.println("Final velocity at the impact="+fp5.getV()+"/ms^-1\n");





	}
}

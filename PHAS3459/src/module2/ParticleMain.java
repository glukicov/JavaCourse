package module2;

public class ParticleMain {

	/* Units m=mass (kg), d=drag coefficient (kg/m), t=time(s), z=vertical position (m)
	// v=velocity in upwards direction (m/s), g=9.81 m/s^2 (acceleration due to gravity) */
	
	public static void main(String[] args) {
		
		//Creating a falling paricle object by calling on the constructor
		//from FallingParticle class:
		
		FallingParticle fp=new FallingParticle(5.3, 2.1);
		
		//Creating an array dT containing time interval as elements 
		double[] dT= {0.5, 0.1, 0.01, 0.001, 0.0001};
		
		//Creating a for loop to drop the particle
		for (double i : dT){
			//Setting Initial height
			fp.setZ(10);
			
			//Simulating descent of the particle
			fp.drop(i);
			
			System.out.println("Time interval="+dT+"/s");
			System.out.println("Time taken to reach the bottom="+fp.getT()+"/s");
			System.out.println("Final velocity at the impact="+fp.getV()+"/ms^-1");
			System.out.println("Particle has fallen thorugh="+fp.getZ()+"/m");
		

			}
		
		
		
		
		
		
		
	}
}

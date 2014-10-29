package module2;
import java.util.Arrays; //Need this to easily print out arrays
public class ParticleMain {

	/* Units m=mass (kg), d=drag coefficient (kg/m), t=time(s), z=vertical position (m)
	// v=velocity in upwards direction (m/s), g=9.81 m/s^2 (acceleration due to gravity) */
	//Simulating descent of the particle for dt=0.5

	public static void main(String[] args) {
		//Creating a falling particle object by calling on the constructor
		try{
			FallingParticle m=new FallingParticle(5.1, 2.3);

			//from FallingParticle class:
			//Simulating descent of the particle for dt=0.1, 0.01, 0.001, 0.001, 0.0001;
			//By looping in on the dropParticle method

			//Declaring and filling an array to store the dt values:
			double[] dt = new double[5];
			for (int i=0; i<dt.length; i++){
				dt[i]=Math.pow(0.1,i+1);
			}

			//Now calling on the 
			for (int k=0; k<dt.length; k++){

				m.dropParticle(10, dt[k]);


			}


			System.out.println("We have used the following time interal array");
			System.out.println(Arrays.toString(dt));
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}


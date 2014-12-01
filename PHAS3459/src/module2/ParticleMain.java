package module2;

public class ParticleMain {

	public static void main(String[] args) {

		//Instantiate FallingParticle object
		FallingParticle dropPart = new FallingParticle(5.3, 2.1);

		// Set initial drop height
		dropPart.setZ(10);

		// Drop particle using different timesteps
		dropPart.drop(0.5);
		dropPart.drop(0.1);
		dropPart.drop(0.01);
		dropPart.drop(0.001);
		dropPart.drop(0.0001);
		System.out.println("Note that the final time and velocity converge on certain values as the timestep is reduced.");
		System.out.println("Also note that the slight overshoot in particle position gets smaller with the timestep reduction.");

	}

}
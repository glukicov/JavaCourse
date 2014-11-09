package example_1;

public class Particle {

	//Initialising variables
	private int charge;
	private double momentum;
	private double theta;
	private double phi;
	private double invMass;

	//Constructor for setting parameters of a particle:
	public Particle(Integer charge, Double momentum, Double theta, 
			Double phi){
		this.charge=charge; this.momentum=momentum; this.theta=theta; this.phi=phi;
	}

	//Getter methods
	public double getCharge() {
		return this.charge;
	}
	public double getMomentum() {
		return this.momentum;
	}
	public double getTheta() {
		return this.theta;
	}
	public double getPhi() {
		return this.phi;
	}
	  public double invMass() {
	        return this.invMass;
	    }


	//Method to output values as a string
	public String toString() {
		return "(Charge="+this.charge+", Momentum="+this.momentum+", Theta="+this.theta+", Phi="+this.phi+")";
	}

}

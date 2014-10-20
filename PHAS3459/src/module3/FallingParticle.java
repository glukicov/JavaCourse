package module3;

public class FallingParticle {

	// Defining m=mass (kg), d=drag coefficient (kg/m), t=time(s), z=vertical position (m)
	// v=velocity in upwards direction (m/s), g=9.81 m/s^2 (acceleration due to gravity)
	//private static final encapsulation protects variables from being accidently changed
	//from outside the class
	private double m; //m is particle dependent 

	private double d; //drag is fluid dependent

	private double z; //starting position to be specified 

	private double t=0; //start time is taken as origin

	private double v=0; //start from rest

	private static double g=9.80665; //at UK's latitude

	// Constructor 
	public FallingParticle(double m, double d){
		this.m=m;
		this.d=d;
	}
	// Set method with no return
	void setZ(double z) {
		this.z = z;
	}
	void setV(double v) {
		this.v = v;
	}
	//Get method with return
	double getZ() {
		return this.z;
	}
	double getV() {
		return this.v;
	}
	double getT() {
		return this.t;
	}

	//creating a no return method to calculate acceleration, and update velocity
	void doTimeStep(double dt){
		double a=((d*v*v/m)-g);
		t = t + dt;
		v = v + a*dt;
		z = z + v*dt;

	}

	// no return method to simulate the descent of the particle
		void drop(double dT) {
			this.t = 0;
			while (z > 0) {
				doTimeStep(dT);
			}
		}









}

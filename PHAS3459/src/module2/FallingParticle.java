package module2;

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
	public FallingParticle(double m, double d)throws Exception{

		if ((m<=0) && (d<0)){
			throw new Exception("Mass is less than or equal to zero AND drag is less than zero!");		
		}
		if (m<=0){
			throw new Exception("Mass of the particle is less than or equal to zero!");		
		}
		if (d<0){
			throw new Exception("Drag is less than zero!");		
		}
		this.m=m;
		this.d=d;
	}
	// Set method with no return
	void setZ(double z) throws Exception {
		if (z<0){
			throw new Exception("Starting position cannot be less than zero!");
		}
		this.z = z;

	}
	void setV(double v) {
		this.v = v;
	}
	//Get method with return
	double getZ(){

		return this.z;

	}
	double getV() {
		return this.v;
	}
	double getT() {
		return this.t;
	}

	public void dropParticle(double z, double dT){
		//Setting Initial height
		try{
			this.setZ(z);
			this.drop(dT);
			System.out.println("Time interval="+dT+ "/s");
			System.out.println("Time taken to reach the bottom="+this.getT()+"/s");
			System.out.println("Final velocity at the impact="+this.getV()+"/ms^-1\n");
		}
		catch (Exception e){
			System.out.println(e);
		}
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

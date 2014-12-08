package exam2008;
/** This class defines coordinate representation of a particle in 4D
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */
public class Particle {
	//Set initial coordinatrs to zero
	private double t=0;
	private double x=0;
	private double y=0;
	private double z=0;

	public Particle()  {
		
		}
	
	public Particle(double t, double x, double y, double z) throws Exception {
	this.t=t; this.x=x; this.y=y; this.z=z;
	}
		

	// Return particle position (Getter methods)
	double getX() {
		return this.x;
	}
	
	double getY() {
		return this.y;
	}
	
	double getZ() {
		return this.z;
	}
	
	double getT() {
		return this.t;
	}

	
	// Set particle position (vector addition)
	void setX(double dx) {
		this.x = this.x+dx;
	}

	void setY(double dy) {
		this.y = this.y+dy;
	}
	
	void setZ(double dz) {
		this.z = this.z+dz;
	}
	void setT(double dt) {
		this.t = this.t+dt;
	}
	 //Method to output values as a string
	@Override
	public String toString() {
		return ""+this.x+" "+this.y+" "+this.z+"\r\n";
	}

	
}
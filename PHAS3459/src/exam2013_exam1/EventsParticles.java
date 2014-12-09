package exam2013_exam1;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * Extending on methods from Events
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class EventsParticles extends Events {

	//Initialising variables
//	private Event event;  //storing the event in it own class (E n_tracks trigger_id)
	private int event;
	private int charge; 	//1 or -1
	private double momentum; 
	private double theta; 
	private double phi;



	/**
	 * // Construct data point for PLANETS WITHOUT DISTANCE 
	 * @param latitude
	 * @param longitude
	 * @param code
	 * @param height
	 */
	public EventsParticles(String trigger, int tracks, int event, int charge, double momentum, double theta, double phi){
		super (tracks, trigger); this.event=event; this.charge=charge; this.momentum=momentum; this.theta=theta; this.phi=phi;
	}
	
	public int getEvent() {
		return this.event;
	}	
	
	public int getCharge() {
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

	
	
	//Method to output values as a string
		public String toString() {
			return super.toString() + "Event: "+this.event+", Charge: "+this.charge+", Momentum: "+this.momentum+" GeV/c, Theta: "+this.theta+" rad, Phi "+this.phi+" rad\n";
		}
	
		
}

package exam2013_exam1;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * Extending on methods from Events
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class EventsMass extends Events {

	//Initialising variables
//	private Event event;  //storing the event in it own class (E n_tracks trigger_id)
	private int event;
	private double mass; 



	/**
	 * // Construct data point for PLANETS WITHOUT DISTANCE 
	 * @param latitude
	 * @param longitude
	 * @param code
	 * @param height
	 */
	public EventsMass(String trigger, int tracks, int event, double mass){
		super (tracks, trigger); this.event=event; this.mass=mass;
	}
	
	public int getEvent() {
		return this.event;
	}	
		
	public double getMass() {
		return this.mass;
	}


	
	
	//Method to output values as a string
		public String toString() {
			return super.toString() + "Event: "+this.event+", Mass: "+this.mass+" GeV/c\n";
		}
	
		
}

package exam2013_exam1;

/** This class stores the data in appropriate format to be used by a collection objects in the Main class
 * Extending on methods from Events
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class EventsRatio{

	//Initialising variables
//	private Event event;  //storing the event in it own class (E n_tracks trigger_id)
	private String trigger;
	private double ratio; 



	/**
	 * // Construct data point for PLANETS WITHOUT DISTANCE 
	 * @param latitude
	 * @param longitude
	 * @param code
	 * @param height
	 */
	public EventsRatio(String trigger, double ratio){
		this.trigger=trigger; this.ratio=ratio;
	}
	
		
	public double getRatio() {
		return this.ratio;
	}
	public String getTrigger() {
		return this.trigger;
	}

	
	
	//Method to output values as a string
		public String toString() {
			return "Trigger: "+this.trigger+", Ratio (Signal/BG): "+this.ratio+" GeV/c\n";
		}
	
		
}

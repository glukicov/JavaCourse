package exam2013_exam1;

/** This class stores only holds data of event information: limited use 
 * for counting the triggers and number OF total events only
 * extending class EventParticles
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class Events {

	//Initialising variables
	private int tracks;
	private String trigger;
	/**
	 * // Construct data point for PLANETS WITHOUT DISTANCE 
	 * @param latitude
	 * @param longitude
	 * @param code
	 * @param height
	 */

	public Events(){}

	public Events(int tracks, String trigger){
		this.tracks=tracks; this.trigger=trigger;
	}
	//Getter methods

	public int getTracks() {
		return this.tracks;
	}
	public String getTrigger() {
		return this.trigger;
	}


	//Method to output values as a string
	public String toString() {
		return "Tracks: "+this.tracks+", Trigger: "+this.trigger+"  ";
	}

}

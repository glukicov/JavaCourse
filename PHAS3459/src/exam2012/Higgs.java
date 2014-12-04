package exam2012;

/** This class stores the Higgs data in appropriate format to be used by a collection 
 * objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class Higgs {

	//Initialising variables
	private String eventID;
	private double eventEnergy;

	/**
	 * // Construct data point for PLANETS WITHOUT DISTANCE 
	 * @param ID
	 * @param Energy
	 */
	public Higgs(String eventID,double eventEnergy){
		this.eventID=eventID; this.eventEnergy=eventEnergy; 
	}
	
	//Getter methods
	public String getEventID() {
		return this.eventID;
	}
	public double getEventEnergy() {
		return this.eventEnergy;
	}

	

	//Method to output values as a string
	public String toString() {
		return "Channel: "+this.eventID+", Event Energy: "+this.eventEnergy+" GeV\n";
	}

}

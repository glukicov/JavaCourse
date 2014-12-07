package exam2012;

/** This class stores the background data in appropriate format to be used by a collection 
 * objects in the Main class
 * 
 * 
 * 
 * @author Gleb
 * @version 1.0 (17/11/14)
 * */

public class Background {

	//Initialising variables
	private int lowBin;
	private int highBin;
	private double events;
	
	/**
	 * // Construct data point for PLANETS WITHOUT DISTANCE 
	 * @param lowBin
	 * @param highBin
	 * @param events
	 */
	public Background(int lowBin, int highBin, double events){
		this.lowBin=lowBin; this.highBin=highBin; this.events=events;
	}
	
	//Setter methods
	public void setEvents(double events) {
	this.events=events;
	}
	
	public void addEvents(double number) {
		this.events=this.events+number;
		}
	
	public void iEvents() {
		this.events=this.events+1;
		}
		
	//Getter methods
	public int getLowBin() {
		return this.lowBin;
	}
	public int getHighBin() {
		return this.highBin;
	}
	public double getEvents() {
		return this.events;
	}
	

	//Method to output values as a string
	public String toString() {
		return "Min. Energy: "+this.lowBin+" GeV, Max Energy: "+this.highBin+" GeV, Expected Events: "+this.events+"\n";
	}

}

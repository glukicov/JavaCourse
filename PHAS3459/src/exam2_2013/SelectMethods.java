package exam2_2013;

import java.util.ArrayList;

/**
 * 
 * @author Gleb
 * This classs implements and extends on methods defined in Subset interface
 */

public class SelectMethods implements Interface {

	final double r=6371; //in km 

	/**
	 * method...
	 */
	public ArrayList<DataFormat> SelectSouthOfLatitude(ArrayList<DataFormat> data, double latitude) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();

		// Loop over input data
		for (DataFormat specimen : data) {

			double specimenLatitude = specimen.getLatitude();
			// If it matches lat conditions, add to new array
			if (specimenLatitude >= latitude) {
				selected.add(specimen);
			}
		}

		return selected;
	}

	/**
	 * method...
	 */	
	public ArrayList<DataFormat> SelectNorthOfLatitude(ArrayList<DataFormat> data, double latitude) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();

		// Loop over input data
		for (DataFormat specimen : data) {

			double specimenLatitude = specimen.getLatitude();
			// If it matches lat conditions, add to new array
			if (specimenLatitude <= latitude) {
				selected.add(specimen);
			}

		}

		return selected;
	}


	/**
	 * method...
	 */
	public ArrayList<DataFormat> SelectSpecimen(ArrayList<DataFormat> data, String code) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();

		// Loop over input data
		for (DataFormat specimen : data) {

			String specimenCode = specimen.getCode();
			// If it code matches store the specimen
			if (specimenCode.equals(code)) {
				selected.add(specimen);
			}

		}

		return selected;
	}


	public double Haversine(double x){
	//	double hav=(1-Math.cos(radAngle2-radAngle1))/2;
	//	double hav=1/2*(1-Math.cos(radAngle2-radAngle1));
		  return 0.5*(1-Math.cos(x));
	//	System.out.println("hav=" +hav);
		//return hav;
	}

	/**
	 * method...
	 */
	public ArrayList<DataFormat> SelectDistance(ArrayList<DataFormat> data, double distance, double latitude, double longitude) {
		// Array to hold matching results
		ArrayList<DataFormat> selected = new ArrayList<DataFormat>();
		//Those are constants:
		double radLatitude=Math.toRadians(latitude);
		//System.out.println("radLatitude= "+radLatitude);
		double radLongitude=Math.toRadians(longitude);
		//System.out.println("radLongitude= "+radLongitude);
		//System.out.println("r= "+r);
		// Loop over input data
		for (DataFormat specimen : data) {

			double specimenRadLatitude = Math.toRadians(specimen.getLatitude());
			//System.out.println("specimenRadLatitude= "+specimenRadLatitude);
			double specimenRadLongitude = Math.toRadians(specimen.getLongitude());
			//System.out.println("specimenRadLongitude= "+specimenRadLongitude);
			// If within given distance (in km!) - store it

			double h=Haversine(radLatitude - specimenRadLatitude)+((Math.cos(specimenRadLatitude))*(Math.cos(radLatitude))*(Haversine(radLongitude - specimenRadLongitude)));
			//System.out.println("h="+h);
			double d=2*r*Math.asin(Math.sqrt(h)); //h in radians
			//System.out.println("d=" +d);
			boolean test = d >= distance ;
			//System.out.println("test=" +test);
			if (test) {
				selected.add(specimen);
			}

		}

		return selected;
	}




}

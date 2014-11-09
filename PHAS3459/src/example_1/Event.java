package example_1;

import java.util.ArrayList;

public class Event {

	//Initialising event variables:
	String trigger;
	int numberParticles;
	Particle[] particleArray;
	//+/- pair combinations
	ArrayList<Particle> Systems=new ArrayList<Particle>();

	public Event(int numberParticles, String trigger, Particle[] particleArray){
		this.numberParticles=numberParticles;
		this.trigger=trigger;
		this.particleArray=particleArray;
		this.pairs();
	}
	void pairs() {
		ArrayList<Particle> pos = new ArrayList<Particle>();
		ArrayList<Particle> neg = new ArrayList<Particle>();

		for(Particle part : particleArray){
			if (part.getCharge()==1){
				pos.add(part);
			}
			else if (part.getCharge()==-1){
				neg.add(part);
			}
		}

		//Generating a new Particle object for each pair
		for (Particle positive : pos){
			for(Particle negative : neg){
		//		this.Systems.add(new Particle(positive, negative));
			}
		}


	}
	
	//Method to output values as a string
		public String toString() {
			return "("+this.numberParticles+", "+this.trigger+", "+this.particleArray+")";
		}
}

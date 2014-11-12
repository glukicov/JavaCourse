package practice_midterm1314;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Pair {
	private Particle pos;
	private Particle neg;
	private FourVector sys;
	private FourVector vpos;
	private FourVector vneg;
	
	public Pair(Particle a, Particle b) throws InputMismatchException {
		if (a.getQ() == b.getQ()) {
			throw new InputMismatchException("Pairs must have two particles of opposite charge.");
		} else {
			pos = (a.getQ() > 0) ? a : b;
			neg = (a == pos) ? b : a;
			vpos = pos.fourVector();
			vneg = neg.fourVector();
		}
	}
	
	public double pairMass() {
		double pairMass;
		sys = vpos.add(vneg);
		pairMass = sys.ivMass();
		return pairMass;
	}
	
	public String toString() {
		return Arrays.toString(vpos.getFourVector())+'\n'+Arrays.toString(vneg.getFourVector());
	}
}

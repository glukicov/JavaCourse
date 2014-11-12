package practice_midterm1112;
import java.util.List;
import java.util.Map;


public class DataAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/midterm/bpm.txt";
			Map<Double, Planet> beamData = Input.getData(URL); 
			System.out.printf("%12s %16s %16s %12s %12s %12s\n", "BPM Position", "No. Particles", "Average x", "Average y", "RMS radius", "Max radius");
			for (Map.Entry<Double, Planet> entry : beamData.entrySet()) {
				int n = entry.getValue().getParticles().size();
				Double xbar = entry.getValue().meanX();
				Double ybar = entry.getValue().meanY();
				Double rRMS = entry.getValue().RMSRadius();
				Double maxR = entry.getValue().maxRadius();
				System.out.printf("%12s %16s %16.8f %12.8f %12.8f %12.8f\n", entry.getKey(), n, xbar, ybar, rRMS, maxR);
				/*StringBuilder sb = new StringBuilder();
				sb.append("Particles: ");
				for (Particle p : entry.getValue()) {
					sb.append(p+" ");
				}
				System.out.println(sb);*/
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}

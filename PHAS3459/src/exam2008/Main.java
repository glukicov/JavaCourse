package exam2008;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {

		String filename="C:/Users/G/Documents/PHYSICS/results.txt";
		
		try{
			//Instantiate Particle object

			Methods m = new Methods();
						
			FileWriter f = new FileWriter(filename);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter pw = new PrintWriter(b);
			
			int counter=0;
			for (int i=1; i<=100; i++){
			ArrayList<Particle> data = m.simulate(1,1000,1);
			pw.println("Particle "+i);
			pw.println("X				y			z ");
			counter=counter+i;
			//if(counter>=100){
			pw.println(data.get(998).toString().replace(",", "").replace("[", "").replace("]", ""));
				}			
			pw.close();	
		
			
			ArrayList<DataFormat> data=m.readData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2008-09/type-position.txt");
			
			//System.out.println(data.toString().replace(",", "").replace("[", "").replace("]", ""));
			
			//create array of unique particle names
			Set<String> typesSet = new LinkedHashSet<String>();
			for(DataFormat item : data){
				//For each recored animal get their code
				//check if the code already been put
				typesSet.add(item.getName());
			}

			
			
			//System.out.println(typesSet.toString().replace(",", "").replace("[", "").replace("]", ""));
			

			Object[] types = typesSet.toArray();
			ArrayList<RMS> rmsArray = new ArrayList<RMS>();
			int time=100;
			
			for(int i=0; i < types.length ; i++){
				double d2=0;
				double rms=0;
				double sum=0;
				int number=0;
				String name=null;
				for (DataFormat item: data){
					if(item.getName().equals(types[i])){
						name=item.getName();
						d2=(item.getX()*item.getX())+(item.getY()*item.getY())+(item.getZ()*item.getZ());
						sum=sum+d2;
						number=number+1;
					}
				}
				rms=Math.sqrt(sum/number);
				double d=rms/100;
				rmsArray.add(new RMS(name, d));
			}
			
		//	System.out.println(rmsArray.toString().replace(",", "").replace("[", "").replace("]", ""));
			
			
			//Using a custom comparator to sort in acceding order the collection 
			// object by  
			Collections.sort(rmsArray, new Comparator<RMS>() {
				@Override
				public int compare(RMS c1, RMS c2) {
					return Double.compare(c1.getRMS(), c2.getRMS());
				}
			});
		//	System.out.println(rmsArray.toString().replace(",", "").replace("[", "").replace("]", ""));
			System.out.println("The largest diffusion coeffcietn");
			System.out.println(rmsArray.get(rmsArray.size()-1).toString().replace(",", "").replace("[", "").replace("]", ""));
			
			
		}
		catch (IOException e){System.out.println("An error has occurred: "+e.getMessage());}
		finally {System.out.println("Task execution completed! Have a nice day!");}

	}

}
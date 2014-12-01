package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Minerals {
    private static final String urlLocations =
            "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt";
    private static final String urlSamples =
            "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt";

    // Find lightest and heaviest samples.
    public static void main(String[] args) {        
        try {
            HashMap<Integer, String> locations = readLocations(urlLocations);
            HashMap<Integer, Double> masses = readMasses(urlSamples);
            printMinMax(masses, locations);
        } catch (IOException e) {
            System.out.println("Error in Minerals: "+e.getMessage());
        }
    }

    // Print details of lightest and heaviest samples.
    private static void printMinMax(HashMap<Integer, Double> masses,
            HashMap<Integer, String> locations) {
            double massMin = 0.0;
            double massMax = 0.0;
            int sampleMin = 0;
            int sampleMax = 0;
            boolean first = true;
            for (int sample : masses.keySet()) {
                double mass = masses.get(sample);
                if (first || mass < massMin) {
                    massMin = mass;
                    sampleMin = sample;
                }
                if (first || mass > massMax) {
                    massMax = mass;
                    sampleMax = sample;
                }
                first = false;

            }
            System.out.println("Largest mass:");
            System.out.println("  sample   "+sampleMax);
            System.out.println("  mass [g] "+massMax);
            System.out.println("  location "+locations.get(sampleMax));
            System.out.println("Smallest mass:");
            System.out.println("  sample   "+sampleMin);
            System.out.println("  mass [g] "+massMin);
            System.out.println("  location "+locations.get(sampleMin));
    }

    // Get map from sample IDs to locations.
    private static HashMap<Integer, String> readLocations(String url) throws IOException {
        URL u = new URL(url);
        InputStream is = u.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        HashMap<Integer, String> locations = new HashMap<Integer, String>();
        String line;
        while ((line = br.readLine()) != null) {
            Scanner scanner = new Scanner(line);
            String location = scanner.next();
            int sample = scanner.nextInt();
            locations.put(sample, location);
            scanner.close();
        }
        return locations;
    }

    // Return map from sample IDs to masses.
    private static HashMap<Integer, Double> readMasses(String url) throws IOException {
        URL u = new URL(url);
        InputStream is = u.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        HashMap<Integer, Double> masses = new HashMap<Integer, Double>();
        String line;
        while ((line = br.readLine()) != null) {
            Scanner scanner = new Scanner(line);
            int sample = scanner.nextInt();
            double mass = scanner.nextDouble();
            masses.put(sample, mass);
            scanner.close();
        }
        return masses;
    }

}
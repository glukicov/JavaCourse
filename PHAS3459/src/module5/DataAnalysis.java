package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {
    // Check whether y = x^2 or y = x^4 matches given data better.
    public static void main(String[] args) {
        try {
            ArrayList<DataPoint> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
            Theory theory2 = new Theory(2);
            Theory theory4 = new Theory(4);
            double goodness2 = goodnessOfFit(theory2, data);
            double goodness4 = goodnessOfFit(theory4, data);
            System.out.format("Chi^2 for y = x^2: %f%n", goodness2);
            System.out.format("Chi^2 for y = x^4: %f%n", goodness4);
            if (goodness2 < goodness4) {
                System.out.println("y = x^2 is a better fit");
            } else if (goodness4 < goodness2) {
                System.out.println("y = x^4 is a better fit");
            } else {
                System.out.println("The theories fit the data equally well.");
            }
        } catch (IOException e) {
            System.out.println("Error in DataAnalysis: "+e.getMessage());
        }
    }

    // Returns list of data points from URL containing "x y ey" on each line.
    private static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
        URL u = new URL(url);
        InputStream is = u.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        ArrayList<DataPoint> data = new ArrayList<DataPoint>();
        String line;
        while ((line = br.readLine()) != null) {
            try {
                Scanner s = new Scanner(line);
                double x = s.nextDouble();
                double y = s.nextDouble();
                double ey = s.nextDouble();
                DataPoint dp = new DataPoint(x, y, ey);
                data.add(dp);
                s.close();
            }
            catch (RuntimeException e) {
                System.out.println("Error: "+e.getMessage());
                System.out.println("Skipping line: "+line);
            }
        }
        br.close();
        return data;
    }

    // Returns chi-squared for given function (Theory) and data points.
    private static double goodnessOfFit(Theory theory,
            ArrayList<DataPoint> data) {
        double chi2 = 0.0;
        for (DataPoint point : data) {
            double x = point.getX();
            double y = point.getY();
            double ey = point.getEy();
            double yTheory = theory.y(x);
            double sqrtDeltaChi2 = (y - yTheory) / ey;
            double deltaChi2 = sqrtDeltaChi2 * sqrtDeltaChi2;
            chi2 += deltaChi2;
        }
        return chi2;
    }
}
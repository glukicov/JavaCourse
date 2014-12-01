package module5;

public class TestSquareMatrix {

    // Carries out matrix operations as instructed for module 5 exercises:
    //   calculates commutator of A and B
    //   checks whether CD = I
    public static void main(String[] args) {
        // Can get away with a single try block for everything, since the input
        // is fixed, so an exception will only be thrown if there is a bug, which
        // I would then fix.
        try {
            double[][] elementsA = {
                    { 1,  0,  2},
                    { 0,  1,  0},
                    {-3,  0, -1}
            };
            double[][] elementsB = {
                    { 0,  0,  1},
                    { 0,  1,  0},
                    {-1,  0,  1}
            };
            double[][] elementsC = {
                    {4, 3},
                    {3, 2}
            };
            double[][] elementsD = {
                    {-2,  3},
                    { 3, -4}
            };
            SquareMatrix a = new SquareMatrix(elementsA);
            SquareMatrix b = new SquareMatrix(elementsB);
            SquareMatrix c = new SquareMatrix(elementsC);
            SquareMatrix d = new SquareMatrix(elementsD);
            System.out.println("A = ");
            System.out.println(a);
            System.out.println("B = ");
            System.out.println(b);

            System.out.println("A+B =");
            System.out.println(a.add(b));
            System.out.println("A-B =");
            System.out.println(a.subtract(b));

            SquareMatrix aTimesB = a.multiply(b);
            SquareMatrix bTimesA = b.multiply(a);
            System.out.println("AB = ");
            System.out.println(a.multiply(b));
            System.out.println("BA = ");
            System.out.println(bTimesA);
            System.out.println("[A,B] = AB-BA = ");
            System.out.println(aTimesB.subtract(bTimesA)); // commutator [A,B]

            SquareMatrix cTimesD = c.multiply(d);
            System.out.println("CD = ");
            System.out.println(cTimesD);
            String equals = cTimesD.equals(SquareMatrix.unitMatrix(2)) ? "" : " not";
            System.out.println("CD is"+equals+" equal to the identity matrix.");
        }
        catch (Exception e) {
            System.out.println("Error in TestSquareMatrix.");
            System.out.println("This should not happen since the inputs are all fixed, so here is a stack trace for debugging:");
            e.printStackTrace();
        }

    }
}
package module5;

// Represents function y = x^n
public class Theory {
    private double n;

    // Constructs Theory with given index n.
    public Theory(double n) {
        this.n = n;
    }

    // Calculates y(x) = x^n
    public double y(double x) {
        return Math.pow(x, n);
    }
}
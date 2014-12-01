package module5;

// Represents data point with x and y values, and error on y.
public class DataPoint {
    private double x;
    private double y;
    private double ey;

    // Construct data point: (x, y +- ey)
    public DataPoint(double x, double y, double ey) {
        this.x = x;
        this.y = y;
        this.ey = ey;
    }

    // Returns x value of point
    public double getX() {
        return x;
    }

    // Returns y value of point
    public double getY() {
        return y;
    }

    // Returns error on y
    public double getEy() {
        return ey;
    }
}
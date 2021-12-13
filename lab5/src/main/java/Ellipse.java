import java.util.Objects;

/**
 * Class intended to store data about an ellipse
 */

public class Ellipse implements Curve {

    private double a, b;

    Ellipse(double a, double b)
    {
        if(a == 0 || b == 0)
            throw new ArithmeticException("a and b cannot be zero");

        this.a = a;
        this.b = b;
    }

    public void setA(double a)
    {
        if(a == 0)
            throw new ArithmeticException("a cannot be zero");
        this.a = a;
    }
    public double getA() { return a; }

    public void setB(double b)
    {
        if(b == 0)
            throw new ArithmeticException("b cannot be zero");
        this.b = b;
    }
    public double getB() { return b; }

    /**
     * Calculate x by y using canonical ellipse formula
     * @param y coordinate
     * @return x coordinate
     */
    public double calculateX(double y)
    {
        return a * Math.sqrt(1 - Math.pow(y, 2) / Math.pow(b, 2));
    }

    /**
     * Calculate y by x using canonical ellipse formula
     * @param x coordinate
     * @return y coordinate
     */
    public double calculateY(double x)
    {
        return b * Math.sqrt(1 - Math.pow(x, 2) / Math.pow(a, 2));
    }

    /**
     * Print semi-major axis of an ellipse "a" and semi-minor axis of an ellipse "b"
     */
    public void print()
    {
        System.out.printf("a: %.2f\tb: %.2f\n", a, b);
    }

    @Override
    public String toString() {
        return String.format("a: %.2f\tb: %.2f\n", a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Ellipse compObj = (Ellipse) obj;
        return a == compObj.a && b == compObj.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

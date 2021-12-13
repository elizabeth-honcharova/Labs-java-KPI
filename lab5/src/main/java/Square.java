import java.util.Objects;

/**
 * Class intended to store data of square
 */
public class Square implements Figure {

    private int side;

    Square(int side) throws IllegalAccessException {
        if(side <= 0)
            throw new IllegalAccessException("side must be > 0");
        this.side = side;
    }

    public void setSide(int side) throws IllegalAccessException {
        if(side <= 0)
            throw new IllegalAccessException("side must be > 0");
        this.side = side;
    }
    public int getSide() {
        return side;
    }

    public int getPerimeter() {
        return 4 * side;
    }

    public int getSquare() { return side * side; }

    @Override
    public String toString() {
        return String.format("side: %d", side);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Square compObj = (Square) obj;
        return side == compObj.side;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

}

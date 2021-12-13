import java.awt.*;
import java.util.Arrays;

/**
 * class that represents arc
 * responsible for drawing the arc by the given parameters
 */

class Arc extends Component {

    private int[] data;

    /**
     * a constructor that accepts nothing and fills all fields with zeros.
     * needed for the first initialization of the object
     */

    public Arc() {

        data = new int[6];
        Arrays.fill(data, 0);
    }

    /**
     * the constructor takes parameters as input and parses them and checks
     */

    public Arc(TextField x, TextField y, TextField width,
               TextField height, TextField startAngle, TextField endAngle) {

        data = AutoParse(x, y, width, height, startAngle, endAngle);
    }

    private int[] AutoParse(TextField... textFields) {
        int[] values = new int[textFields.length];
        for (int i = 0; i < textFields.length; i++) {
            values[i] = Integer.parseInt(textFields[i].getText());
        }
        validateValue(Arrays.copyOfRange(values, 0, 4));
        validateAngle(Arrays.copyOfRange(values, 3, values.length));
        return values;
    }

    private void validateValue(int... values) {

        for (int value : values)
            if (value < 0)
                throw new NumberFormatException();
    }

    private void validateAngle(int... values) {
        for (int value : values)
            if (Math.abs(value) > 360)
                throw new NumberFormatException();
    }

    /**
     * method draws the arc
     * @param g
     */

    public void paint(Graphics g) {
        g.drawArc(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    /**
     * method update arc parameters and redraws arc
     * @param x the x-coordinate where the rectangle begins which is circumscribed around the circle of which the arc is a part
     * @param y the y-coordinate where the rectangle begins which is circumscribed around the circle of which the arc is a part
     * @param width width of a rectangle that is circumscribed around a circle of which the arc is a part
     * @param height heigth of a rectangle that is circumscribed around a circle of which the arc is a part
     * @param startAngle angle of the arc
     * @param endAngle angle of the arc
     */

    public void update(TextField x, TextField y, TextField width,
                       TextField height, TextField startAngle, TextField endAngle) {
        data = AutoParse(x, y, width, height, startAngle, endAngle);
        repaint();
    }
}
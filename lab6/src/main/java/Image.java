import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * class that represents image
 * responsible for drawing image by the given parameters
 */

public class Image extends Component {

    int[] size;
    BufferedImage image;

    /**
     * the constructor takes parameters as input and parses them and checks
     * @param width width of image
     * @param height height of image
     * @param path path of image
     * @throws IOException if wrong path specified
     */

    public Image(TextField width, TextField height, TextField path) throws IOException {
        size = AutoParse(width, height);
        image = ImageIO.read(new File(path.getText()));
    }

    /**
     * a constructor that accepts nothing and fills all fields with zeros.
     * needed for the first initialization of the object
     */

    public Image() {
        size = new int[2];
        Arrays.fill(size, 0);
        image = null;
    }

    private int[] AutoParse(TextField... textFields) {
        int[] values = new int[textFields.length];
        for (int i = 0; i < textFields.length; i++) {
            values[i] = Integer.parseInt(textFields[i].getText());
            if(values[i] <= 0)
                throw new NumberFormatException();
        }
        return values;
    }

    /**
     * method draws the image
     * @param g
     */

    public void paint(Graphics g) {
        g.drawImage(image, 20, 20, size[0], size[1],null);
    }

    /**
     * method update arc parameters and redraws image
     * @param newWidth new width of image
     * @param newHeight new height of image
     * @param path new path of image
     * @throws IOException if wrong path specified
     */

    public void update(TextField newWidth, TextField newHeight, TextField path) throws IOException {
        size = AutoParse(newWidth, newHeight);
        image = ImageIO.read(new File(path.getText()));
        repaint();
    }
}

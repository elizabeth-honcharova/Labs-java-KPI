import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * the main frame for task29
 */

public class ImageForm extends Frame implements ActionListener {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 500;
    Panel sizeMenu;
    TextField path, width, height;
    Image image;

    /**
     * constructor creates and initializes the main frame components
     */

    public ImageForm() {

        super("Вывод изображения");

        setSize(WIDTH, HEIGHT);
        setLocation(200, 300);

        sizeMenu = new Panel();
        initializeMenu();
        path = new TextField("Введите путь к изображению");
        image = new Image();

        add(sizeMenu, BorderLayout.NORTH);
        add(image, BorderLayout.CENTER);
        add(path, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void initializeMenu() {

        sizeMenu.add(new Label("Ширина:"));
        width = new TextField();
        width.addActionListener(this);
        sizeMenu.add(width);

        sizeMenu.add(new Label("Высота:"));
        height = new TextField();
        height.addActionListener(this);
        sizeMenu.add(height);

        Button drawImage = new Button("Вывести изображение");
        drawImage.addActionListener(this);
        sizeMenu.add(drawImage);
    }

    /**
     * action listener for adding text or clicking on a button
     * @param e the action of adding text or clicking on a button
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (areEmpty(width, height, path))
            return;

        try {
            image.update(width, height, path);
        } catch (NumberFormatException | IOException ex) {
            new WrongInputDialog(this);
        }
    }

    private boolean areEmpty(TextField... textFields) {
        for (TextField field : textFields) {
            if (field.getText().isEmpty())
                return true;
        }
        return false;
    }
}

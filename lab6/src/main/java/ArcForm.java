import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * the main frame of task17
 */

public class ArcForm extends Frame implements ActionListener {

    private final Panel parameters;
    private TextField coordinateX, coordinateY,
            width, height,
            startAngle, endAngle;
    private final Arc arc;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 500;

    /**
     * constructor creates and initializes the main frame components
     */

    public ArcForm() {

        super("Вывод дуги");

        setSize(WIDTH, HEIGHT);
        setLocation(200, 300);

        parameters = new Panel();
        arc = new Arc();

        initializeParameters();
        add(parameters, BorderLayout.SOUTH);
        add(arc);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);

    }

    private void initializeParameters() {

        parameters.add(new Label("Координата X:"));
        coordinateX = new TextField();
        coordinateX.addActionListener(this);
        parameters.add(coordinateX);

        parameters.add(new Label("Координата Y:"));
        coordinateY = new TextField();
        coordinateY.addActionListener(this);
        parameters.add(coordinateY);

        parameters.add(new Label("Ширина:"));
        width = new TextField();
        width.addActionListener(this);
        parameters.add(width);

        parameters.add(new Label("Высота:"));
        height = new TextField();
        height.addActionListener(this);
        parameters.add(height);

        parameters.add(new Label("Начальный угол:"));
        startAngle = new TextField();
        startAngle.addActionListener(this);
        parameters.add(startAngle);

        parameters.add(new Label("Конечный угол:"));
        endAngle = new TextField();
        endAngle.addActionListener(this);
        parameters.add(endAngle);

        Button printArc = new Button("Вывести дугу");
        printArc.addActionListener(this);
        parameters.add(printArc);
    }

    /**
     * action listener for adding text or clicking on a button
     * @param e the action of adding text or clicking on a button
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        if (areEmpty(coordinateX, coordinateY, width, height, startAngle, endAngle))
            return;

        try {
            arc.update(coordinateX, coordinateY, width, height, startAngle, endAngle);
        } catch (NumberFormatException ex) {
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


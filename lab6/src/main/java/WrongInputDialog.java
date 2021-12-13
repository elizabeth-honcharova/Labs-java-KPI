import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WrongInputDialog extends Dialog {

    Button closeWindow;

    public WrongInputDialog(Frame owner) {
        super(owner);

        setTitle("Input error");
        setLayout(new FlowLayout());
        setSize(200, 100);
        setLocation(500, 500);

        closeWindow = new Button("Close");
        closeWindow.setSize(50, 50);
        closeWindow.setBackground(Color.red);
        closeWindow.setForeground(Color.white);
        closeWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(new Label("Input Error. Please try again"), BorderLayout.NORTH);
        add(closeWindow, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}

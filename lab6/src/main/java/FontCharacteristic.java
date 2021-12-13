import java.awt.*;
import java.awt.event.*;

/**
 * the main frame for task2 and task13
 */

class FontCharacteristic extends Frame implements ItemListener, ActionListener{

    private final Panel fontSelectorPanel;
    private Choice choiceFont, choiceStyle, choiceColor;
    private Button size12, size14, size16;
    private final TextArea textArea;

    private String font = "Times New Roman";
    private int style = Font.PLAIN;
    private int size = 12;
    private Color color = Color.black;

    /**
     * constructor creates and initializes the main frame components
     */

    public FontCharacteristic() {

        super("Характеристики шрифта");

        setSize(1000, 300);
        setLocation(200, 300);

        fontSelectorPanel = new Panel();
        initializeFontPanel();
        add(fontSelectorPanel, BorderLayout.NORTH);

        textArea = new TextArea("Ввод текста");
        add(textArea, BorderLayout.CENTER);

        addWindowListener (new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void initializeFontPanel() {

        choiceFont = new Choice();
        choiceStyle = new Choice();
        choiceColor = new Choice();

        size12 = new Button("12 pt");
        size14 = new Button("14 pt");
        size16 = new Button("16 pt");

        choiceFont.add("Times New Roman");
        choiceFont.add("Arial");
        choiceFont.add("Serif");
        choiceFont.addItemListener(this);

        choiceStyle.add("Простой");
        choiceStyle.add("Жирный");
        choiceStyle.add("Курсив");
        choiceStyle.add("Жирный курсив");
        choiceStyle.addItemListener(this);

        choiceColor.add("Черный");
        choiceColor.add("Красный");
        choiceColor.add("Зеленый");
        choiceColor.add("Синий");
        choiceColor.addItemListener(this);

        size12.addActionListener(this);
        size14.addActionListener(this);
        size16.addActionListener(this);

        fontSelectorPanel.add(new Label("Шрифт: "));
        fontSelectorPanel.add(choiceFont);
        fontSelectorPanel.add(new Label("Стиль: "));
        fontSelectorPanel.add(choiceStyle);
        fontSelectorPanel.add(new Label("Цвет: "));
        fontSelectorPanel.add(choiceColor);

        fontSelectorPanel.add(size12);
        fontSelectorPanel.add(size14);
        fontSelectorPanel.add(size16);
    }

    /**
     * item listener to choices that user does
     * @param e the action of choice
     */

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }

        if (e.getSource() == choiceColor)
        {
            color = switch(choiceColor.getSelectedItem()) {
                case "Красный" -> Color.red;
                case "Зеленый" -> Color.green;
                case "Синий" -> Color.blue;
                default -> Color.black;
            };
        }
        if (e.getSource() == choiceFont) {
            font = (String)choiceFont.getSelectedItem();
        } else {
            style = choiceStyle.getSelectedIndex();
        }

        textArea.setForeground(color);
        textArea.setFont(new Font(font, style, size));
    }

    /**
     * action listener for clicking on a button
     * @param e the action of clicking on a button
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == size12)
            size = 12;
        else if(e.getSource() == size14)
            size = 14;
        else
            size = 16;
        textArea.setFont(new Font(font, style, size));
    }
}
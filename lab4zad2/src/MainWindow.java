import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JLabel label;
    private JTextField textfield;
    private JPanel jpanel;

    MainWindow() {
        super("Test ze staroaramejskiego");

        label = new JLabel();
        textfield = new JTextField();
        textfield.setColumns(30);

        jpanel = new JPanel();
        jpanel.setSize(100, 50);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setLayout(new GridLayout(3, 1));

        add(label);
        add(jpanel);
        add(textfield);

        pack();
        setVisible(true);
    }

    public void sendMessage(String message) {
        label.setText(message);
    }

    public void setListener(AnswerListener listener) {
        textfield.addActionListener(listener);
    }

    public String getAnswer() {
        return textfield.getText();
    }

    public void cleanTextfield() {
        textfield.setText("");
    }
}

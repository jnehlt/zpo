import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        Main window = new Main();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,300));
        window.add(panel, BorderLayout.CENTER);

        window.add(new BottomPanel(panel), BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
    }
}

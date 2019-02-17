import javax.swing.*;

public class Slider extends JPanel {
    private JSlider color_picker;

    public enum Color {
        RED,
        GREEN,
        BLUE
    }

    private Slider(){}
    public Slider(JPanel panel, Color color) {
        JLabel label = new JLabel();
        label.setText(color.name());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        color_picker = new JSlider(0, 255, 130);
        color_picker.addChangeListener(new ColorChanger(panel, color));

        add(label);
        add(color_picker);
    }

    public Integer getValue() { return color_picker.getValue(); }
}
import javax.swing.*;

public class Spinner extends JPanel {
    private JSpinner color_picker;

    private Spinner(){}
    public Spinner(JPanel panel, Slider.Color color) {
        JLabel label = new JLabel();
        label.setText(color.name());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        color_picker = new JSpinner(new SpinnerNumberModel(130, 0, 255, 1));
        color_picker.addChangeListener(new ColorChanger(panel, color));

        add(label);
        add(color_picker);
    }

    public Integer getValue() { return (Integer)color_picker.getValue(); }
}
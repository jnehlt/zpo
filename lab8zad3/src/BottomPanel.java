import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    JPanel color_panel;

    private BottomPanel(){}
    public BottomPanel(JPanel color_panel) {
        this.color_panel = color_panel;
        setLayout(
                new BoxLayout(
                        this, BoxLayout.Y_AXIS
                )
        );
        Slider red_slider = new Slider(color_panel, Slider.Color.RED);
        Slider green_slider = new Slider(color_panel, Slider.Color.GREEN);
        Spinner blue_slider = new Spinner(color_panel, Slider.Color.BLUE);

        add(red_slider);
        add(green_slider);
        add(blue_slider);

        color_panel.setBackground(
                new Color(
                        red_slider.getValue() << 16 |
                        green_slider.getValue() << 8 |
                        blue_slider.getValue()
                )
        );

        add(new ColorNamePrinter(color_panel));
    }
}

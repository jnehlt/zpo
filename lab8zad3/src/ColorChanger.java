import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorChanger implements ChangeListener {
    private JPanel panel;
    private Slider.Color color;

    private ColorChanger(){}
    public ColorChanger(JPanel panel, Slider.Color color) {
        this.panel = panel;
        this.color = color;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Integer prev_rgb = panel.getBackground().getRGB();
        Integer curr_color;
        if(e.getSource() instanceof JSlider) {
            curr_color = ((JSlider)(e.getSource())).getValue();
        }
        else {
            curr_color = (Integer)((JSpinner)(e.getSource())).getValue();
        }
        int mask = 0x00000000;
        switch(color) {
            case RED:
                mask = 0xFFFF0000;
                break;
            case GREEN:
                mask = 0xFF00FF00;
                break;
            case BLUE:
                mask = 0xFF0000FF;
                break;
            default:
                System.out.println("Something went really really wrong..");
                break;
        }
        curr_color = (curr_color << 16 | curr_color << 8 | curr_color) & mask;
        prev_rgb &= ~mask;
        curr_color = curr_color | prev_rgb;
        panel.setBackground(new Color(curr_color));
    }
}

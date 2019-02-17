import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class ColorNamePrinter extends JPanel {
    Field [] color_names;
    Checkbox checkbox;
    JLabel label;

    private ColorNamePrinter(){}
    public ColorNamePrinter(JPanel panel) {
        try {
            getColorNames();
        } catch (Exception e) {
            e.getMessage();
        }

        checkbox = new Checkbox();
        label = new JLabel();
        PropertyChangeListener pcl = e ->
                label.setText(
                        getColorName(
                                panel.getBackground().getRGB()
                        )
                );

        checkbox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.DESELECTED) {
                panel.removePropertyChangeListener("background", pcl);
            }
            else { panel.addPropertyChangeListener("background", pcl); }
        });

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(checkbox);
        add(label);
    }

    private void getColorNames() throws Exception {
        Class color = Class.forName("java.awt.Color");
        final Class temp = color;

        color_names = Stream.of(color.getDeclaredFields())
                .filter(x ->
                        Modifier.isStatic(x.getModifiers()) &&
                        Modifier.isFinal(x.getModifiers()) &&
                        x.getType() == temp
                ).filter(x ->
                        Character.isLowerCase(x.getName().charAt(0))
                ).toArray(Field[]::new);
    }

    private String getColorName(Integer rgb) {
        Color new_color = new Color(rgb);
        Integer temp = Integer.MAX_VALUE;
        Field best_color = color_names[0];

        for(Field f : color_names) {
            Color compare = null;
            try { compare = (Color)f.get(null); }
            catch (IllegalAccessException e) { e.getMessage(); }

            Integer temp2 = CompareColors(compare, new_color);
            if(temp2 < temp) {
                temp = temp2;
                best_color = f;
            }
        }
        return best_color.getName();
    }

    private static Integer CompareColors(Color first, Color second) {
        return  Math.abs(first.getRed() - second.getRed()) +
                Math.abs(first.getGreen() - second.getGreen()) +
                Math.abs(first.getBlue() - second.getBlue());
    }
}

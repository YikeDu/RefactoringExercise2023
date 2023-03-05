import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NavigateButtonBuilder {
    JButton jButton = null;

    public NavigateButtonBuilder(String iconFileName) {
        jButton = new JButton(new ImageIcon(
                new ImageIcon(iconFileName).getImage()
                        .getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH)));
    }

    public NavigateButtonBuilder setPreferredSize(Dimension preferredSize) {
        jButton.setPreferredSize(preferredSize);
        return this;
    }

    public NavigateButtonBuilder addActionListener(ActionListener l) {
        jButton.addActionListener(l);
        return this;
    }

    public NavigateButtonBuilder setToolTipText(String text) {
        jButton.setToolTipText(text);
        return this;
    }

    public JButton build() {
        return jButton;
    }
}

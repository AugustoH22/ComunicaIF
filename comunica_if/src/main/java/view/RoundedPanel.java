package view;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private int arcWidth = 40;
    private int arcHeight = 40;

    public RoundedPanel() {
        setOpaque(false);
    }

    public RoundedPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        g2.dispose();
        super.paintComponent(g);
    }
}

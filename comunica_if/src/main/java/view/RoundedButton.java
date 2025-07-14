package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private boolean hover = false;

    public RoundedButton(String text) {
        super(text);

        // Evita que o Swing pinte por cima
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false); // ESSENCIAL para sombra aparecer

        // Configurações visuais
        setFont(new Font("Arial", Font.BOLD, 14));
        setForeground(Color.BLACK);
        setPreferredSize(new Dimension(120, 35));

        // Detecta hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        int arc = 40;
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Sombra ao passar o mouse
        if (hover) {
            g2.setColor(new Color(0, 0, 0, 60)); // Sombra semitransparente
            g2.fillRoundRect(2, 3, getWidth() - 4, getHeight() - 4, arc, arc);
        }

        // Cor de fundo do botão
        Color corFundo = getModel().isArmed() ? new Color(160, 160, 160) : new Color(180, 180, 180);
        g2.setColor(corFundo);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        // Texto centralizado
        FontMetrics fm = g2.getFontMetrics();
        String texto = getText();
        int textWidth = fm.stringWidth(texto);
        int textHeight = fm.getAscent();
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2 - 3;

        g2.setColor(getForeground());
        g2.setFont(getFont());
        g2.drawString(texto, x, y);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Nenhuma borda visível
    }
}

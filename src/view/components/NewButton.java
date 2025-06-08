package src.view.components;

import javax.swing.*;
import java.awt.*;

public class NewButton extends JButton {

    public NewButton(String text , String iconPath){
        super(text);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource(iconPath));
        Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));

        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.TOP);

        setBackground(Color.WHITE);

        this.setBorder(BorderFactory.createEmptyBorder(20 ,20 , 20 ,20));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setFocusPainted(false);

        setIconTextGap(3);
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(getBackground());
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
//        g2.setColor(new Color(200, 200, 200));
//        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
//        g2.dispose();
//
//        super.paintComponent(g);
//    }
}

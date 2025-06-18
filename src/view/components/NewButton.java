package src.view.components;

import javax.swing.*;
import java.awt.*;

public class NewButton extends JButton {

    public NewButton(String text , String iconPath){
        super(text);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource(iconPath));
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));
        setIconTextGap(3);

        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.TOP);

        this.setMargin(new Insets(10, 10, 10, 10)); 
        this.setPreferredSize( new Dimension( 110 , 90));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setFocusPainted(false);
    }
}

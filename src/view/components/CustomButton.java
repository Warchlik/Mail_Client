package src.view.components;

import java.awt.Cursor;
import javax.swing.*;

public class CustomButton extends JButton {

    public CustomButton(String string){
        super(string);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}

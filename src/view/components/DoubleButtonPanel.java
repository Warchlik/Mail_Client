package src.view.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DoubleButtonPanel extends JPanel {
    private String firstButtonText;
    private String secoundButtonText;

    private CustomButton firstButton;
    private CustomButton secoundButton;

    public DoubleButtonPanel(String firstButtonText , String secoundButtonText){
        super();
        this.firstButtonText = firstButtonText;
        this.secoundButtonText = secoundButtonText;

        initComponent();
        setComponent();

        setVisible(true);
    }

    private void initComponent(){
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setBorder(new EmptyBorder(5, 0, 0, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    }

    private void setComponent(){
        this.firstButton = new CustomButton(this.firstButtonText);
        this.secoundButton = new CustomButton(this.secoundButtonText);

        add(this.firstButton);
        add(this.secoundButton);
    }

    public CustomButton getFirstButton() {
        return firstButton;
    }

    public CustomButton getSecoundButton() {
        return secoundButton;
    }
}

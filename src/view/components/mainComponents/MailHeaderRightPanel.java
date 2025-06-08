package src.view.components.mainComponents;

import src.view.components.TextLabel;

import javax.swing.*;
import java.awt.*;

public class MailHeaderRightPanel extends JPanel{

    private JTextField toTextField;
    private JTextField titleTextField;

    public MailHeaderRightPanel(){
        setLayout(new GridLayout(2,2, 5,5));

        this.toTextField = new JTextField();
        this.toTextField.setEditable(false);

        this.titleTextField = new JTextField();
        this.titleTextField.setEditable(false);

        add(new TextLabel("DO:"));
        add(toTextField);
        setEnabled(false);
        add(new TextLabel("TEMAT:"));
        add(titleTextField);
    }
}

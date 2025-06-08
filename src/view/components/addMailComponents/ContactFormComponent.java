package src.view.components.addMailComponents;

import src.view.components.TextLabel;

import javax.swing.*;
import java.awt.*;

public class ContactFormComponent extends JPanel {

    private TextLabel firstNameLabel;
    private TextLabel lastNameLabel;
    private TextLabel emailLabel;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;


    public ContactFormComponent(){
        initComponent();
        initVariables();
        setComponent();
    }

    private void initComponent(){
        setLayout(new GridLayout(3,2,5,5));
        setBorder(BorderFactory.createEmptyBorder(0 , 0 ,0 ,0));
    }

    private void initVariables(){
        firstNameLabel = new TextLabel("Imię: ");
        lastNameLabel = new TextLabel("Nazwisko: ");
        emailLabel = new TextLabel("Email: ");

        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        emailField = new JTextField(15);
    }

    private void setComponent(){
        add(this.firstNameLabel);
        add(this.firstNameField);

        add(this.lastNameLabel);
        add(this.lastNameField);

        add(this.emailLabel);
        add(this.emailField);
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }
}

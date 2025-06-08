package src.view;

import src.controllers.ContactController;
import src.view.components.CustomButton;
import src.view.components.TextLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ContactAddView extends JDialog{

    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField emailField;
    private final JButton addButton;
    private final JButton cancelButton;

    public ContactAddView(JFrame jFrame , ContactController controller) {
        super(jFrame, "Utwórz nowy kontakt", true);
        setLayout(new BorderLayout(10,10));

        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        emailField = new JTextField(15);

        JPanel form = new JPanel(new GridLayout(3,2,5,5));
        form.add(new TextLabel("Imię:"));   form.add(firstNameField);
        form.add(new TextLabel("Nazwisko:")); form.add(lastNameField);
        form.add(new TextLabel("Email:"));  form.add(emailField);
        add(form, BorderLayout.CENTER);

        addButton = new CustomButton("Dodaj");
        cancelButton = new CustomButton("Anuluj");

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
        buttons.add(addButton);
        buttons.add(cancelButton);
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(buttons, BorderLayout.SOUTH);

        addButton.addActionListener(event -> {
//            controller.saveContact();
            this.clearFields();
            controller.closeDialog(this);
        });

        cancelButton.addActionListener(event -> {
            this.clearFields();
            controller.closeDialog(this);
        });

        windowCloseListener();

        getRootPane().setDefaultButton(addButton);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
    }

    private void windowCloseListener(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                clearFields();
            }
        });
    }

    public JTextField getFirstNameField(){
        return this.firstNameField;
    }

    public JTextField getLastNameField(){
        return this.lastNameField;
    }

    public JTextField getEmailField(){
        return this.emailField;
    }
}

package src.view;

import src.controllers.ContactController;
import src.view.components.addMailComponents.ContactFormComponent;
import src.view.components.DoubleButtonPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ContactAddView extends JDialog{

    private ContactController contactController;
    private DoubleButtonPanel doubleButtonPanel;
    private ContactFormComponent contactFormComponent;

    public ContactAddView(JFrame jFrame , ContactController contactController) {
        super(jFrame, "Utwórz nowy kontakt", true);
        this.contactController = contactController;

        initComponent();
        initVariable();
        setComponent();
        clickListener();
    }

    public void initComponent(){
        setLayout(new BorderLayout(10,10));
        windowCloseListener();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void initVariable(){
        contactFormComponent = new ContactFormComponent();
        doubleButtonPanel = new DoubleButtonPanel("Dodaj" , "Anuluj");
    }

    public void setComponent(){
        add(contactFormComponent, BorderLayout.CENTER);
        add(doubleButtonPanel, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(doubleButtonPanel.getFirstButton());
    }

    private void clearFields() {
        contactFormComponent.getFirstNameField().setText("");
        contactFormComponent.getLastNameField().setText("");
        contactFormComponent.getEmailField().setText("");
    }

    private void clickListener(){

        doubleButtonPanel.getFirstButton().addActionListener(event -> {
            contactController.addCustomer(
                    contactFormComponent.getFirstNameField().getText(),
                    contactFormComponent.getLastNameField().getText(),
                    contactFormComponent.getEmailField().getText()
            );
            this.clearFields();
            contactController.closeDialog(this);
        });

        doubleButtonPanel.getSecoundButton().addActionListener(event -> {
            this.clearFields();
            contactController.closeDialog(this);
        });
    }

    private void windowCloseListener(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                clearFields();
            }
        });
    }

    public ContactFormComponent getContactFormComponent() {
        return contactFormComponent;
    }
}

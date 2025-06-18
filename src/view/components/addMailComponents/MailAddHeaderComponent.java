package src.view.components.addMailComponents;

import src.controllers.MailController;
import src.models.Contact;
import src.view.components.CustomButton;
import src.view.components.TextLabel;

import javax.swing.*;
import java.awt.*;

public class MailAddHeaderComponent extends JPanel {

    private final MailController mailController;
    private JLabel toLabel;
    private JTextField toField;
    private JButton choiceButton;
    private JLabel subjectLabel;
    private JTextField subjectField;

    private JPopupMenu popup;
    private JList<Contact> contactList;

    public MailAddHeaderComponent(MailController mailController) {
        this.mailController = mailController;
        initComponent();
        initVariables();
        initPopup();
        setComponent();
        clickListener();
    }

    public void initComponent(){
        setLayout(new GridLayout(2, 3, 5, 5));
    }

    private void initVariables() {
        toLabel = new TextLabel("DO:");
        toField = new JTextField(20);
        choiceButton = new CustomButton("WYBIERZ");
        subjectLabel = new TextLabel("TEMAT:");
        subjectField = new JTextField(20);
    }

    private void initPopup() {
        contactList = new JList<>(mailController.getContactListModel());
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(contactList);
        scroll.setPreferredSize(new Dimension( 220 , 120));

        popup = new JPopupMenu();
        popup.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        popup.add(scroll);
    }

    private void setComponent() {

        add(toLabel);
        add(toField);
        add(choiceButton);

        add(subjectLabel);
        add(subjectField);
        add(new JLabel());
    }

    public void clickListener(){

        choiceButton.addActionListener(event -> {
            mailController.refreshContactModel();
            popup.show(choiceButton, 0, choiceButton.getHeight());
        });

        contactList.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                mailController.popUpSelectEvent(contactList , toField);
                popup.setVisible(false);
            }
        });
    }

    public JTextField getToField() {
        return toField;
    }

    public JButton getChooseButton() {
        return choiceButton;
    }

    public JTextField getSubjectField() {
        return subjectField;
    }

    public void setSubjectField(String string) {
        subjectField.setText(string);
    }

    public void setToField(String string) {
        toField.setText(string);
    }

    public JPopupMenu getPopup() {
        return popup;
    }

    public JList<Contact> getContactList() {
        return contactList;
    }
}

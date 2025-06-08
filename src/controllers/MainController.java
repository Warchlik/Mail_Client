package src.controllers;

import src.models.Email;
import src.view.MainView;

import javax.swing.*;

public class MainController {
    private final MainView mainView;
    private final ContactController contactController;
    private final MailController mailController;
    private DefaultListModel<Email> emailListModel;

    public MainController() {

        this.mainView = new MainView(this);
        this.mailController = new MailController(mainView);
        this.contactController = new ContactController(mainView);

        mainView.getMailLeftPanel()
                .setEmailListModel(mailController.getEmailListModel());

        this.bindActions();
        this.mainView.setVisible(true);
    }

    private void bindActions(){
        this.mainView
                .getMailTopPanel()
                .getNewMailButton()
                .addActionListener(event -> {
                    mailController.showDialog();
                    mailController.refreshContactModel();
                });

        this.mainView
                .getMailTopPanel()
                .getNewContactButton()
                .addActionListener(event -> contactController.showDialog());
    }


    public void showSelectedValues(JTextField toField, JTextField titleField, JTextArea textArea , JList<Email> emailList){
        Email selectedEmail = emailList.getSelectedValue();
        if (selectedEmail != null){
            toField.setText(selectedEmail.getEmail());
            textArea.setText(selectedEmail.getText());
            titleField.setText(selectedEmail.getTitle());
        }
    }
}

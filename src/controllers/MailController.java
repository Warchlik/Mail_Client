package src.controllers;

import src.Services.ContactService;
import src.Services.EmailService;
import src.models.Contact;
import src.models.Email;
import src.view.EmailAddView;
import javax.swing.*;
import java.util.List;

public class MailController extends Controller<EmailAddView>{

    private final EmailAddView view;
    private final ContactService contactService = ContactService.getInstance();
    private final EmailService emailService = EmailService.getInstance();

    private DefaultListModel<Contact> contactListModel = new DefaultListModel<>();

    private DefaultListModel<Email> emailListModel = new DefaultListModel<>();

    public MailController(JFrame jFrame) {
        this.view = new EmailAddView(jFrame , this);
    }

    void showDialog(){
        view.pack();
        view.setLocationRelativeTo(view.getOwner());
        view.setVisible(true);
    }

    public List<Contact> getContactList(){
        return contactService.getUnmodifiableContactList();
    }

    public DefaultListModel<Contact> getContactListModel(){
        refreshContactModel();
        return contactListModel;
    }

    public void refreshContactModel(){
        contactListModel.clear();
        contactService.getContactList().forEach(contactListModel::addElement);
    }

    public void popUpSelectEvent(JList<Contact> contactJList , JTextField textField ){
        Contact selected = contactJList.getSelectedValue();
        if (selected != null) {
            textField.setText(selected.getEmail());
        }
    }

    public void sendMail(String toField , String title , String text){
        emailService.getEmailList().add(new Email(toField , title , text));
        refreshEmailModel();
        // tutaj jeszcze trzeba dodać obsługe wysyłania maila
    }

    public DefaultListModel<Email> getEmailListModel(){
        refreshEmailModel();
        return emailListModel;
    }

    public void refreshEmailModel(){
        emailListModel.clear();
        emailService.getUnmodifiableEmailList().forEach(emailListModel::addElement);
    }
}

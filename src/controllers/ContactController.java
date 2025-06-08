package src.controllers;

import src.Services.ContactService;
import src.models.Contact;
import src.view.ContactAddView;
import javax.swing.*;
import java.util.List;

public class ContactController extends Controller<ContactAddView> {

    private final ContactAddView view;
    private final ContactService contactService = ContactService.getInstance();
    private DefaultListModel<Contact> contactListModel = new DefaultListModel<>();

    public ContactController(JFrame frame) {
        this.view = new ContactAddView(frame , this);
    }

    public void showDialog(){
        view.pack();
        view.setLocationRelativeTo(view.getOwner());
        view.setVisible(true);
    }

    public void addCustomer(String firstName , String lastName , String email){
        Contact contact = new Contact(firstName , lastName , email);
        this.contactService.getContactList().add(contact);
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

    public List<Contact> getContactList(){
        return contactService.getUnmodifiableContactList();
    }
}

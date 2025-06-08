package src.Services;

import src.models.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactService {

    private static final ContactService INSTANCE = new ContactService();
    private List<Contact> contactList = new ArrayList<>();

    private ContactService(){}

    public static ContactService getInstance(){
        return INSTANCE;
    }

    public List<Contact> getUnmodifiableContactList(){
        return Collections.unmodifiableList(this.contactList);
    }

    public List<Contact> getContactList(){
        return this.contactList;
    }
}

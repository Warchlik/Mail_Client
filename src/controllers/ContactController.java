package src.controllers;

import src.view.ContactAddView;
import javax.swing.*;

public class ContactController extends Controller<ContactAddView> {

    private final ContactAddView view;

    public ContactController(JFrame frame) {
        this.view = new ContactAddView(frame , this);
    }

    void showDialog(){
        view.pack();
        view.setLocationRelativeTo(view.getOwner());
        view.setVisible(true);
    }

    public void saveCustomer(){

    }
}

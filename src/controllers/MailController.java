package src.controllers;

import src.view.ContactAddView;
import src.view.EmailAddView;

import javax.swing.*;

public class MailController extends Controller<EmailAddView>{

    private final EmailAddView view;

    public MailController(JFrame frame) {
        this.view = new EmailAddView(frame , this);
    }

    void showDialog(){
        view.pack();
        view.setLocationRelativeTo(view.getOwner());
        view.setVisible(true);
    }
}

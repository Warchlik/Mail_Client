package src.Services;

import src.models.Contact;
import src.models.Email;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmailService {

    private static final EmailService INSTANCE = new EmailService();
    private List<Email> emailList = new ArrayList<>();
    private final DefaultListModel<Email> emailDefaultListModel = new DefaultListModel<>();

    private EmailService(){}

    public static EmailService getInstance(){
        return INSTANCE;
    }

    public List<Email> getUnmodifiableEmailList(){
        return Collections.unmodifiableList(this.emailList);
    }

    public List<Email> getEmailList(){
        return this.emailList;
    }

    public DefaultListModel<Email> getDefaultEmailList(){
        emailDefaultListModel.clear();
        emailList.forEach(emailDefaultListModel::addElement);
        return emailDefaultListModel;
    }
}

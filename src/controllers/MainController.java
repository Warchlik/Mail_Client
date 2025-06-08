package src.controllers;

import src.view.ContactAddView;
import src.view.EmailAddView;
import src.view.MainView;

public class MainController {
    private final MainView mainView;
    private final ContactController contactController;
    private final MailController mailController;

    public MainController() {
        this.mainView = new MainView();

        this.contactController = new ContactController(mainView);
        this.mailController = new MailController(mainView);

        this.bindActions();

        this.mainView.setVisible(true);
    }

    private void bindActions(){
        this.mainView
                .getMailTopPanel()
                .getNewMailButton()
                .addActionListener(event -> mailController.showDialog());

        this.mainView
                .getMailTopPanel()
                .getNewContactButton()
                .addActionListener(event -> contactController.showDialog());
    }
}

package src.view;

import src.Helpers.ValidatorHelper;
import src.Services.ContactService;
import src.Services.EmailService;
import src.controllers.MailController;
import src.view.components.DoubleButtonPanel;
import src.view.components.addMailComponents.MailAddHeaderComponent;
import src.view.components.addMailComponents.TextAreaComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmailAddView extends JDialog {

    private MailAddHeaderComponent mailAddHeaderComponent;
    private DoubleButtonPanel doubleButtonPanel;
    private TextAreaComponent textAreaComponent;

    private ContactService contactService = ContactService.getInstance();

    private final MailController mailController;

    public EmailAddView(JFrame jFrame , MailController mailController) {
        super(jFrame, "Utwórz nowy mail", true);
        this.mailController = mailController;

        initComponent(jFrame);
        initVariable();
        setComponent();

        bindClickAction();

        windowCloseListener();
    }

    public void initComponent(JFrame frame){
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(frame);
    }

    public void initVariable(){
        mailAddHeaderComponent = new MailAddHeaderComponent(mailController);
        textAreaComponent = new TextAreaComponent();
        doubleButtonPanel = new DoubleButtonPanel("WYŚLIJ" , "ODRZUĆ");
    }

    public void setComponent(){
        add(mailAddHeaderComponent , BorderLayout.NORTH);
        add(textAreaComponent, BorderLayout.CENTER);
        add(doubleButtonPanel, BorderLayout.SOUTH);
    }

    private void clearFields() {
        mailAddHeaderComponent.setToField("");
        mailAddHeaderComponent.setSubjectField("");
        textAreaComponent.setTextArea("");
    }

    private void bindClickAction(){
        doubleButtonPanel.getFirstButton().addActionListener(event -> {

            String toField = mailAddHeaderComponent.getToField().getText();
            String title = mailAddHeaderComponent.getSubjectField().getText();
            String text = textAreaComponent.getTextArea().getText();

            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Czy na pewno chcesz wysłać maila? ",
                    "Potwierdź",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null
            );

            if (result == JOptionPane.YES_OPTION){
                boolean isValidate = ValidatorHelper.validateMailInput(this, toField, title, text);
                if (isValidate){
                    mailController.sendMail(toField, title, text);
                    System.out.println(EmailService.getInstance().getEmailList());
                    System.out.println(EmailService.getInstance().getDefaultEmailList());
                    this.clearFields();
                    this.setVisible(false);
                }
            }
        });

        doubleButtonPanel.getSecoundButton().addActionListener(event -> {
            clearFields();
            this.setVisible(false);
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

    public MailAddHeaderComponent getMailAddHeaderComponent() {
        return mailAddHeaderComponent;
    }

    public TextAreaComponent getTextAreaComponent() {
        return textAreaComponent;
    }
}

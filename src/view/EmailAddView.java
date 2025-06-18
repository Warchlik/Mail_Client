package src.view;

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

        doubleButtonPanel.getFirstButton().addActionListener(event -> {
            mailController.sendMail(
                    mailAddHeaderComponent.getToField().getText(),
                    mailAddHeaderComponent.getSubjectField().getText(),
                    textAreaComponent.getTextArea().getText()
            );
            System.out.println(EmailService.getInstance().getEmailList());
            System.out.println(EmailService.getInstance().getDefaultEmailList());
            clearFields();
            this.setVisible(false);
        });

        doubleButtonPanel.getSecoundButton().addActionListener(event -> {
            clearFields();
            this.setVisible(false);
        });

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

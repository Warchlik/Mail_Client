package src.view.components.mainComponents;

import src.Services.EmailService;
import src.controllers.MainController;
import src.models.Email;
import src.view.components.TextLabel;

import javax.swing.*;
import java.awt.*;

public class MailLeftPanel extends JPanel {

    private JScrollPane scrollList;
    private TextLabel textLabel;
    private JList<Email> emailList;
    private DefaultListModel<Email> emailDefaultListModel;
    private MainController mainController;
    private MailPreviewRightPanel previewRightPanel;

    public MailLeftPanel(MainController mainController , MailPreviewRightPanel mailPreviewRightPanel) {
        this.mainController = mainController;
        this.previewRightPanel = mailPreviewRightPanel;
        this.emailDefaultListModel = EmailService.getInstance().getDefaultEmailList();
        initComponent();
        initVariable();
        setComponent();
        clickListener();
    }

    public void initComponent() {
        setLayout(new BorderLayout(5, 5));
        setPreferredSize(new Dimension(150, 0));
        setFont(getFont().deriveFont(Font.BOLD));
    }

    public void initVariable() {
        emailList = new JList<>(emailDefaultListModel);
        scrollList = new JScrollPane(emailList);
        textLabel = new TextLabel("Wysłane wiadomości:");
    }

    public void setComponent() {
        add(textLabel, BorderLayout.NORTH);
        add(scrollList, BorderLayout.CENTER);
    }

    public void setEmailListModel(DefaultListModel<Email> emailList) {
        this.emailDefaultListModel = emailList;
    }

    public void clickListener(){
        emailList.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                mainController.showSelectedValues(
                        previewRightPanel.getMailHeaderRightPanel().getToTextField(),
                        previewRightPanel.getMailHeaderRightPanel().getTitleTextField(),
                        previewRightPanel.getTextArea(),
                        emailList
                );
            }
        });
    }
}

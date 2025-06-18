package src.view.components.mainComponents;

import src.controllers.MainController;

import javax.swing.*;
import java.awt.*;

public class MailPreviewRightPanel extends JPanel {

    private MailHeaderRightPanel mailHeaderRightPanel;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public MailPreviewRightPanel(MainController mainController){
        initComponent();
        initVariables();
        uploadElement();
    }

    private void initComponent(){
        setLayout(new BorderLayout(5,5));
    }
    
    private void initVariables(){
        this.mailHeaderRightPanel = new MailHeaderRightPanel();
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);

        this.scrollPane = new JScrollPane(this.textArea);
        this.scrollPane.setBorder(null);
    }

    private void uploadElement(){
        this.add(mailHeaderRightPanel, BorderLayout.NORTH);
        this.add(this.scrollPane, BorderLayout.CENTER);
    }


    public MailHeaderRightPanel getMailHeaderRightPanel() {
        return mailHeaderRightPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}

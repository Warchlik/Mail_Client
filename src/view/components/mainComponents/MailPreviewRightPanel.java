package src.view.components.mainComponents;

import src.controllers.MainController;

import javax.swing.*;
import java.awt.*;

public class MailPreviewRightPanel extends JPanel {

    private MailHeaderRightPanel mailHeaderRightPanel;
    private JTextArea textArea;

    public MailPreviewRightPanel(MainController mainController){
        this.mailHeaderRightPanel = new MailHeaderRightPanel();
        setLayout(new BorderLayout(5,5));

        this.add(mailHeaderRightPanel, BorderLayout.NORTH);
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setDoubleBuffered(true);
        this.add(new JScrollPane(this.textArea), BorderLayout.CENTER);
    }

    public MailHeaderRightPanel getMailHeaderRightPanel() {
        return mailHeaderRightPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}

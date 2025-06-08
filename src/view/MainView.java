package src.view;

import javax.swing.*;
import java.awt.*;

import src.view.components.mainComponents.MailLeftPanel;
import src.view.components.mainComponents.MailPreviewRightPanel;
import src.view.components.mainComponents.MailTopPanel;

public class MainView extends JFrame {
    private DefaultListModel<String> sentModel;
    private JList<String> sentList;

    private final MailTopPanel mailTopPanel;
    private final MailPreviewRightPanel mailPreviewRightPanel;
    private final MailLeftPanel mailLeftPanel;

    public MainView() {
        super("PJATK Mail");

        this.sentModel = new DefaultListModel<>();
        this.sentList = new JList<>(sentModel);

        this.mailTopPanel =  new MailTopPanel();
        this.mailLeftPanel = new MailLeftPanel(sentList);
        this.mailPreviewRightPanel = new MailPreviewRightPanel();


        getContentPane().add(mailTopPanel , BorderLayout.NORTH);
        getContentPane().add(mailLeftPanel, BorderLayout.WEST);
        getContentPane().add(mailPreviewRightPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public MailTopPanel getMailTopPanel(){
        return this.mailTopPanel;
    }

    public MailLeftPanel getMailLeftPanel(){
        return this.mailLeftPanel;
    }

    public MailPreviewRightPanel getMailPreviewRightPanel(){
        return this.mailPreviewRightPanel;
    }

    public DefaultListModel<String> getSentModel(){
        return this.sentModel;
    }

    public JList<String> getSentList(){
        return this.sentList;
    }
}

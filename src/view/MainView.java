package src.view;

import javax.swing.*;
import java.awt.*;

import src.controllers.MainController;
import src.view.components.mainComponents.MailLeftPanel;
import src.view.components.mainComponents.MailPreviewRightPanel;
import src.view.components.mainComponents.MailTopPanel;

public class MainView extends JFrame {
    private MainController mainController;

    private MailTopPanel mailTopPanel;
    private MailPreviewRightPanel mailPreviewRightPanel;
    private MailLeftPanel mailLeftPanel;

    public MainView(MainController mainController) {
        super("PJATK Mail");
        this.mainController = mainController;
        initComponent();
        initVariable();
        setComponent();
    }

    private void initComponent(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void initVariable(){
        this.mailTopPanel =  new MailTopPanel(mainController);
        this.mailPreviewRightPanel = new MailPreviewRightPanel(mainController);
        this.mailLeftPanel = new MailLeftPanel(mainController , mailPreviewRightPanel);
    }

    private void setComponent(){
        add(mailTopPanel , BorderLayout.NORTH);
        add(mailLeftPanel, BorderLayout.WEST);
        add(mailPreviewRightPanel, BorderLayout.CENTER);
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
}

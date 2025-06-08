package src.view.components.mainComponents;

import javax.swing.*;
import java.awt.*;

public class MailPreviewRightPanel extends JPanel {

    private JTextArea textArea;

    public MailPreviewRightPanel(){
        setLayout(new BorderLayout(5,5));
        this.add(new MailHeaderRightPanel(), BorderLayout.NORTH);
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setDoubleBuffered(true);
        this.add(new JScrollPane(this.textArea), BorderLayout.CENTER);
    }
}

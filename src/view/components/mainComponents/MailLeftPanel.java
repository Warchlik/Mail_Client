package src.view.components.mainComponents;

import src.view.components.TextLabel;

import javax.swing.*;
import java.awt.*;

public class MailLeftPanel extends JPanel {

    public MailLeftPanel(JList<String> list){
        setLayout(new BorderLayout(5, 5));
        this.add( new TextLabel("Wysłane wiadomości:") , BorderLayout.NORTH);
        this.add(new JScrollPane(list) , BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(150 , 0));
        this.setFont(getFont().deriveFont(Font.BOLD));
    }
}

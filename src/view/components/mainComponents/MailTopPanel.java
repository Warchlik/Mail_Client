package src.view.components.mainComponents;

import src.view.components.ClockLabel;
import src.view.components.NewButton;

import javax.swing.*;
import java.awt.*;

public class MailTopPanel extends JPanel {

    private NewButton newMailButton;
    private NewButton newContactButton;
    private ClockLabel clockLabel;

    public MailTopPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        this.newMailButton = new NewButton("Utwórz Mail", "/src/images/mail.png");
        this.newContactButton = new NewButton("Utwórz Kontakt", "/src/images/add.png");
        this.clockLabel = new ClockLabel();

        this.add(Box.createHorizontalStrut(15));
        this.add(this.newMailButton);
        this.add(Box.createHorizontalStrut(15));
        this.add(this.newContactButton);
        this.add(Box.createHorizontalGlue());
        this.add(this.clockLabel);
    }

    public NewButton getNewMailButton() {
        return this.newMailButton;
    }

    public NewButton getNewContactButton() {
        return this.newContactButton;
    }
}

package src.view.components;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockLabel extends JLabel {

    private Timer timer;

    public ClockLabel() {
        super();
        setFont(getFont().deriveFont(Font.BOLD, 48f));
        this.startTimer();
    }

    private void startTimer() {
        updateTime();
        this.timer = new Timer(1000, e -> updateTime());
        this.timer.start();
    }

    private void updateTime() {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        setText(time);
    }
}

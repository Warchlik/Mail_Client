package src.images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame {
    private DefaultListModel<String> sentModel;
    private JList<String> sentList;
    private JLabel clockLabel;

    public Main() {
        super("PJATK Mail");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Top toolbar with buttons and clock
        JToolBar toolBar = new JToolBar();
        JButton newMailBtn = new JButton("Utwórz mail");
        JButton newContactBtn = new JButton("Utwórz kontakt");
        clockLabel = new JLabel();
        toolBar.add(newMailBtn);
        toolBar.add(newContactBtn);
        toolBar.add(Box.createHorizontalGlue());
        toolBar.add(clockLabel);

        // Left list of sent messages
        sentModel = new DefaultListModel<>();
        sentList = new JList<>(sentModel);
        JScrollPane listScroll = new JScrollPane(sentList);

        // Right panel for message preview
        JPanel previewPanel = new JPanel(new BorderLayout(5,5));
        JPanel header = new JPanel(new GridLayout(2,2, 5,5));
        header.add(new JLabel("Odbiorca:"));
        header.add(new JTextField());
        header.add(new JLabel("Temat:"));
        header.add(new JTextField());
        JTextArea bodyArea = new JTextArea();
        bodyArea.setEditable(false);
        JScrollPane bodyScroll = new JScrollPane(bodyArea);
        previewPanel.add(header, BorderLayout.NORTH);
        previewPanel.add(bodyScroll, BorderLayout.CENTER);

        // Split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScroll, previewPanel);
//        splitPane.setDividerLocation(200);

        getContentPane().add(toolBar, BorderLayout.NORTH);
        getContentPane().add(splitPane, BorderLayout.CENTER);

        // Start clock update
        startClock();
    }

    private void startClock() {
        Timer t = new Timer(1000, (ActionEvent e) -> {
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
            clockLabel.setText(time);
        });
        t.start();
    }

    // For testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}

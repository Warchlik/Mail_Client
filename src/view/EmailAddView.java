package src.view;

import src.controllers.MailController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmailAddView extends JDialog {
    private final JTextField toField;
    private final JButton chooseButton;
    private final JTextField subjectField;
    private final JTextArea textArea;
    private final JButton sendButton;
    private final JButton cancelButton;

    public EmailAddView(JFrame frame , MailController mailController) {
        super(frame, "Utwórz nowy mail", true);

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(content);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel north = new JPanel(new BorderLayout(5, 5));
        north.setBorder(new EmptyBorder(0, 0, 5, 0));
        north.add(new JLabel("DO:"), BorderLayout.WEST);
        toField = new JTextField(20);
        north.add(toField, BorderLayout.CENTER);
        chooseButton = new JButton("WYBIERZ");
        north.add(chooseButton, BorderLayout.EAST);
        content.add(north, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel subjPanel = new JPanel(new BorderLayout(5, 5));
        subjPanel.add(new JLabel("TEMAT:"), BorderLayout.WEST);
        subjectField = new JTextField(20);
        subjPanel.add(subjectField, BorderLayout.CENTER);
        center.add(subjPanel);

        center.add(Box.createVerticalStrut(8));

        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        center.add(new JScrollPane(textArea));

        content.add(center, BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        south.setBorder(new EmptyBorder(5, 0, 0, 0));
        sendButton = new JButton("WYŚLIJ");
        cancelButton = new JButton("ODRZUĆ");
        south.add(sendButton);
        south.add(cancelButton);
        content.add(south, BorderLayout.SOUTH);


        sendButton.addActionListener(event -> {
//            mailController.sendMail(this.toField , this.subjectField , this.textArea);
            clearFields();
            setVisible(false);
        });

        cancelButton.addActionListener(event -> {
            clearFields();
            setVisible(false);
        });

        windowCloseListener();

        pack();
        setLocationRelativeTo(frame);
    }

    private void clearFields() {
        toField.setText("");
        subjectField.setText("");
        textArea.setText("");
    }

    private void windowCloseListener(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                clearFields();
            }
        });
    }

    public JTextField getToField() {
        return toField;
    }

    public JButton getChooseButton() {
        return chooseButton;
    }

    public JTextField getSubjectField() {
        return subjectField;
    }

    public JTextArea  getBodyArea() {
        return textArea;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

}

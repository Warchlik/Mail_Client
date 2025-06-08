package src.view.components.addMailComponents;

import javax.swing.*;

public class TextAreaComponent extends JPanel {

    private JTextArea textArea;

    public TextAreaComponent(){
        super();

        initComponent();
        initVariable();
        setComponent();
    }

    private void initComponent(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void initVariable(){
        textArea = new JTextArea(10, 30);
    }

    private void setComponent(){
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(String string){
        textArea.setText(string);
    }
}

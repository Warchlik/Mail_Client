package src.controllers;

import javax.swing.*;

public abstract class Controller<T extends JDialog> {

    public void closeDialog(T view){
        view.setVisible(false);
//        view.dispose();
    }

    public void showDialog(T view){
        view.pack();
        view.setLocationRelativeTo(view.getOwner());
        view.setVisible(true);
    }
}

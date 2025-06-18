package src.Helpers;

import javax.swing.*;

public class ValidatorHelper {
    private ValidatorHelper(){}

    public static boolean validateMailInput(JDialog view, String toField, String title, String text) {
        if (toField == null || toField.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "Pole 'DO' nie może być puste!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (!toField.matches(".+@.+\\..+")) {
            JOptionPane.showMessageDialog(
                    view,
                    "Nieprawidłowy adres email!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (title == null || title.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "Temat nie może być pusty!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (text == null || text.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "Treść wiadomości nie może być pusta!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        return true;
    }

    public static boolean validContactInput(JDialog view, String name, String lastname, String email) {
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "Pole 'Imię' nie może być puste!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (lastname == null || lastname.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "Pole 'Nazwisko' nie może być puste!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (!email.matches(".+@.+\\..+")) {
            JOptionPane.showMessageDialog(
                    view,
                    "Nieprawidłowy adres email!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        return true;
    }
}

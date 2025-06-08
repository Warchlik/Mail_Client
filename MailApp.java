import src.controllers.MainController;
import javax.swing.*;

public class MailApp {
    public static void main(String[] args){
        SwingUtilities.invokeLater(MainController::new);
    }
}

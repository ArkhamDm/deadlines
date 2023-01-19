package app;

import javax.swing.*;

public class AuthFrame extends JDialog {
    boolean is_admin;
    public AuthFrame(){
        JTextField login = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JCheckBox guest = new JCheckBox();
        Object[] message = {
                "Логин:", login,
                "Пароль:", passwordField,
                "Быть гостем:", guest
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (login.getText().equals("Dmitry") && passwordField.getText().equals("Leti_1773")){
                is_admin = true;
            } else if (guest.isSelected()){
                is_admin = false;
            } else{
               new AuthFrame();
            }
        }
    }

    boolean getAdmin(){
        return is_admin;
    }
}

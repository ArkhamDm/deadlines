package app;

import data.Client;

import javax.swing.*;

public class AuthFrame extends JDialog {
    int is_admin = 0;
    public AuthFrame(){
        JTextField login = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JCheckBox guest = new JCheckBox();
        Object[] message = {
                "Логин:", login,
                "Пароль:", passwordField
        };

        Object[] options = {"Войти", "Зарегистрироваться"};

        int option = JOptionPane.showOptionDialog(this,
                message,
                "Login",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (option == JOptionPane.OK_OPTION){
            Client client = ServiceManager.getInstance().getServices().getClient(login.getText(), passwordField.getText());
            if (client != null && client.getPassword().equals(passwordField.getText())){
                if (client.isIs_admin()){
                    is_admin = 1;
                } else is_admin = 2;
            } else {
                new AuthFrame();
            }
        }
        if (option == JOptionPane.NO_OPTION){
            new RegisterFrame();
        }
    }

    int getAdmin(){
        return is_admin;
    }
}

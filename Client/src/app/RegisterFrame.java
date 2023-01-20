package app;

import data.Client;

import javax.swing.*;
import java.util.ArrayList;

public class RegisterFrame extends JFrame {
    public RegisterFrame(){
        JTextField login = new JTextField();
        JTextField email = new JTextField();
        JPasswordField passwordField1 = new JPasswordField();
        JPasswordField passwordField2 = new JPasswordField();
        JCheckBox guest = new JCheckBox();
        Object[] message = {
                "Логин:", login,
                "Email: ", email,
                "Пароль:", passwordField1,
                "Повторите пароль", passwordField2
        };

        Object[] options = {"Зарегистрироваться", "Назад"};

        int option = JOptionPane.showOptionDialog(this,
                message,
                "Register",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title

        if (option == JOptionPane.OK_OPTION){
            if (login.getText().equals("") || email.getText().equals("") || passwordField1.getText().equals("")){
                new RegisterFrame();
            }
            if (passwordField1.getText().equals(passwordField2.getText())){
                ArrayList<Client> clients = ServiceManager.getInstance().getServices().getClients();
                for (Client client : clients){
                    if (client.getLogin().equals(login.getText())){
                        new RegisterFrame();
                        break;
                    }
                }

                Client client = new Client();
                client.setLogin(login.getText());
                client.setPassword(passwordField1.getText());
                client.setEmail(email.getText());

                ServiceManager.getInstance().getServices().addClient(client);
            }
            else {
                new RegisterFrame();
            }
        }

        new AuthFrame();
    }
}

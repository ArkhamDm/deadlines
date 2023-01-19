package app;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Application {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Error: NimbusLookAndFeel");
        }
        AuthFrame authFrame = new AuthFrame();
        boolean is_admin = authFrame.is_admin;

        MainFrame frame = new MainFrame(is_admin);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

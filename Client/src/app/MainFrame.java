package app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(boolean is_admin) throws HeadlessException{
        super("Major base");
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Majors", new MajorsPanel(is_admin));
        setLayout(new BorderLayout());


        add(tabbedPane);
    }


}

package app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(int is_admin) throws HeadlessException{
        super("Major base");
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Majors", new MajorsPanel(is_admin));
        if (is_admin == 1) tabbedPane.addTab("Clients", new ClientsPanel());

        setLayout(new BorderLayout());
        add(tabbedPane);
    }


}

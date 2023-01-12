import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException{
        super("Product base");
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Products", new ProductsPanel());
        setLayout(new BorderLayout());
        add(tabbedPane);
    }


}

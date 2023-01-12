import javax.swing.*;
import java.awt.*;

public class ProductsPanel extends JPanel {
    public ProductsPanel() {
        JList list = new JList();
        JTextField priceField = new JTextField();
        JTextArea aboutArea = new JTextArea();
        JButton addButton = new JButton("Add");
        JButton delButton = new JButton("Del");

        JToolBar toolBar = new JToolBar();
        toolBar.add(addButton);
        toolBar.add(delButton);



        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(toolBar, BorderLayout.NORTH);
        leftPanel.add(list, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(priceField, BorderLayout.NORTH);
        rightPanel.add(aboutArea, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(200);

        setLayout(new BorderLayout());

    }
}

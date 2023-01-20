package app.models.client;

import data.Client;
import data.Deadline;

import javax.swing.*;
import java.awt.*;

public class ClientRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setText(((Client) value).getLogin() + " Email: " + ((Client) value).getEmail());
        return this;
    }
}

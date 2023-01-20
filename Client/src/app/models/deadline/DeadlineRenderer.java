package app.models.deadline;

import data.Deadline;

import javax.swing.*;
import java.awt.*;

public class DeadlineRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setText(((Deadline)value).getDescription() + "  |  ДАТА: " + ((Deadline)value).getDate());
        return this;
    }
}
package app.models.major;

import data.Major;


import javax.swing.*;
import java.awt.*;

public class MajorRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String exam = new String();
        if (((Major)value).isIs_exam()) exam = " (Экзамен)";
        else exam = " (Зачет)";
        setText(((Major)value).getName() + exam);
        return this;
    }
}

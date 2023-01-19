package models;

import data.Deadline;
import javax.swing.*;

public class DeadlineList extends JList<Deadline> {
    public DeadlineList() {
        super(new DeadlineModel<>());
        setCellRenderer(new DeadlineRenderer());
    }

    public DeadlineModel getDeadlineModel() {
        return (DeadlineModel) getModel();
    }
}
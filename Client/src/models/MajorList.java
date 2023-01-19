package models;

import data.Major;

import javax.swing.*;

public class MajorList extends JList<Major> {
    public MajorList() {
        super(new MajorModel<>());
        setCellRenderer(new MajorRenderer());
    }

    public MajorModel getMajorModel() {
        return (MajorModel) getModel();
    }
}

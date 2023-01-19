package models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MajorModel<Major> extends AbstractListModel<Major> {
    private List<Major> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Major getElementAt(int index) {
        return list.get(index);
    }

    public void setMajorList(List<Major> majorList) {
        list = majorList;
    }
    /*
    *

    postgresql jdbc

    *
    * */
    public void addMajor(Major major) {
        list.add(major);
        fireIntervalAdded(major,list.size()-1, list.size()-1);

    }

    public void delMajor(Major major) {
        list.remove(major);
        fireIntervalRemoved(major, list.size(), list.size());
    }

}

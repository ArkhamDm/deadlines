package app.models.deadline;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DeadlineModel<Deadline> extends AbstractListModel<Deadline> {
    private List<Deadline> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Deadline getElementAt(int index) {
        return list.get(index);
    }

    public void setDeadlineList(List<Deadline> deadlineList) {
        list = deadlineList;
    }

    /*
    *

    postgresql jdbc

    *
    * */

    public void addDeadline(Deadline deadline) {
        list.add(deadline);
        fireIntervalAdded(deadline, list.size() - 1, list.size() - 1);
    }

    public void delDeadline(Deadline deadline) {
        list.remove(deadline);
        fireIntervalRemoved(deadline, list.size(), list.size());
    }
}
package app.models.client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClientModel<Client> extends AbstractListModel<Client> {
    private List<Client> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Client getElementAt(int index) {
        return list.get(index);
    }

    public void setClientList(List<Client> clientList) {
        list = clientList;
    }

    /*
    *

    postgresql jdbc

    *
    * */

    public void addClient(Client client) {
        list.add(client);
        fireIntervalAdded(client, list.size() - 1, list.size() - 1);
    }

    public void delClient(Client client) {
        list.remove(client);
        fireIntervalRemoved(client, list.size(), list.size());
    }
}
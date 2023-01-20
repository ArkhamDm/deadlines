package app.models.client;

import data.Client;

import javax.swing.*;

public class ClientList extends JList<Client> {
    public ClientList() {
        super(new ClientModel<>());
        setCellRenderer(new ClientRenderer());
    }

    public ClientModel getClientModel() {
        return (ClientModel) getModel();
    }
}
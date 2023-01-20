package app;

import app.models.client.ClientList;
import data.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientsPanel extends JPanel {
    public ClientsPanel(){
        ClientList clients = new ClientList();

        JButton delClient = new JButton("Удалить пользователя");
        JToolBar toolBar = new JToolBar();
        toolBar.add(delClient);

        //database update
        ArrayList<Client> client = ServiceManager.getInstance().getServices().getClients();
        for (Client cl : client){
            clients.getClientModel().addClient(cl);
        }

        delClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = clients.getSelectedValue();
                ServiceManager.getInstance().getServices().delClient(client.getLogin());
                clients.getClientModel().delClient(client);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(clients, BorderLayout.CENTER);
        panel.add(toolBar, BorderLayout.NORTH);

        setLayout(new BorderLayout());
        add(panel);
    }
}

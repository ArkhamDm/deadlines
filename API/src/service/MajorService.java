package service;

import data.Client;
import data.Deadline;
import data.Major;

import java.util.ArrayList;

public interface MajorService {
    String addMajor(Major major);
    String addDeadline(Deadline deadline, String id);
    void addClient(Client client);
    void delMajor(String id);
    void delDeadline(String id);
    void changeMajor(Major major);
    void changeDeadline(Deadline deadline);
    ArrayList<Deadline> getDeadlines(String id);
    ArrayList<Major> getMajors();
    ArrayList<Client> getClients();
    Client getClient(String login, String password);

}

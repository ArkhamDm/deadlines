package service;

import data.Deadline;
import data.Major;

import java.util.ArrayList;

public interface MajorService {
    String addMajor(Major major);
    String addDeadline(Deadline deadline, String id);
    void delMajor(String id);
    void delDeadline(String id);
    void changeMajor(Major major);
    void changeDeadline(Deadline deadline);
    ArrayList<Deadline> getDeadlines(String id);
    ArrayList<Major> getMajors();
}

import data.Deadline;
import data.Major;
import service.MajorService;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class  MajorServiceImpl implements MajorService {
    @Override
    public String addMajor(Major major) {
        try {
            String id = UUID.randomUUID().toString();
            major.setId(id);

            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();
            String sql =  "INSERT INTO majors VALUES " +
                    "(\'" + major.getId() + "\', \'" + major.getName() + "\', " + major.isIs_exam() + ")";
            statement.execute(sql);
            statement.close();
            conn.close();
            return id;
        } catch (SQLException e) {
            System.out.println("fffffffff");
            throw new RuntimeException(e);
        }
    }

    @Override
    public String addDeadline(Deadline deadline, String id) {
        try {
            deadline.setId(id);

            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();
            String sql =  "INSERT INTO deadlines VALUES " +
                    "(\'" + deadline.getId() + "\', \'" + deadline.getDate() + "\', \'" + deadline.getDescription() + "\')";
            statement.execute(sql);
            statement.close();
            conn.close();
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delMajor(String id) {
        try {
            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();

            String sql = "DELETE FROM majors WHERE id='" + id + "';" +
                    "DELETE FROM deadlines WHERE id='" + id + "';";
            statement.execute(sql);
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delDeadline(String id) {
        try {
            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();

            String sql = "DELETE FROM deadlines WHERE id='" + id + "'";
            statement.execute(sql);
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeMajor(Major major) {
        try {
            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();

            String sql = "UPDATE majors SET name = " + "\'" + major.getName() + "\', is_exam = " + major.isIs_exam()
                    + " where id = " + "\'" + major.getId() + "\'";
            statement.execute(sql);
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeDeadline(Deadline deadline) {
        try {
            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();

            String sql = "UPDATE deadlines SET name = \'" + deadline.getDate() + "\', is_exam = \'" + deadline.getDescription() + "\'"
                    + " where id = " + "\'" + deadline.getId() + "\'";
            statement.execute(sql);
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Deadline> getDeadlines(String id) {
        try {
            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();

            String sql = "SELECT * FROM deadlines WHERE id = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Deadline> deadlines = new ArrayList<Deadline>();
            while (resultSet.next()){
                Deadline deadline = new Deadline();
                deadline.setId(id);
                deadline.setDate(resultSet.getString("date"));
                deadline.setDescription(resultSet.getString("description"));

                deadlines.add(deadline);
            }
            statement.close();
            conn.close();

            return deadlines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Major> getMajors() {
        try {
            Connection conn = DatabaseManager.getInstance().getCon();
            Statement statement = conn.createStatement();

            String sql = "SELECT * FROM majors";
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Major> majors = new ArrayList<Major>();
            while (resultSet.next()){
                Major major = new Major();
                major.setId(resultSet.getString("id"));
                major.setName(resultSet.getString("name"));
                major.setIs_exam(resultSet.getBoolean("is_exam"));

                majors.add(major);
            }
            statement.close();
            conn.close();

            return majors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

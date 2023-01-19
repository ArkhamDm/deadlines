import data.Major;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public static List<Major> getAllMajors(){
        ArrayList<Major> majors = new ArrayList<>();

        try {
            Connection con = DatabaseManager.getInstance().getCon();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from majors");
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Major major = new Major();
                major.setName(name);
                majors.add(major);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return majors;
    }
    //todo это в serviceimpl next delete it

    public Major getMajorbyName(String name){
        Connection con = DatabaseManager.getInstance().getCon();
        return null;
    }

    public void saveMajor(Major major){
        Connection con = DatabaseManager.getInstance().getCon();
    }

}

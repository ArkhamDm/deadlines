import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/Deadlines";
        String login = "postgres";
        String password = "Leti_1773";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        try {
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            String sql = "CREATE TABLE majors (name varchar(20) NOT NULL, PRIMARY KEY (name));";
            statement.execute(sql);
            statement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

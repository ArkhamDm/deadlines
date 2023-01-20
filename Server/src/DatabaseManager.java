import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static DatabaseManager dm;
    private DatabaseManager(){
        /*String username = System.getProperty("user.home");
        String config = username + "./Deadlines/database.xml";
        File file = new File(config);
        XStream xStream = new XStream();
        xStream.alias("DatabaseConf", DatabaseConf.class);
        DatabaseConf databaseConf;
        if (file.exists()){
            databaseConf = new DatabaseConf();
            try {
                xStream.toXML(databaseConf, new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else{
            databaseConf = new DatabaseConf();
            try {
                file.getParentFile().mkdirs();
                xStream.toXML(databaseConf, new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }*/

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        try {
            String url = "jdbc:postgresql://localhost/Deadlines";
            Connection con = DriverManager.getConnection(url, "postgres", "Leti_1773");
            Statement statement = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS majors " +
                    "(id VARCHAR(60) PRIMARY KEY, name VARCHAR(60) NOT NULL, is_exam BOOLEAN NOT NULL);" +
                    "CREATE TABLE IF NOT EXISTS deadlines " +
                    "(id VARCHAR(60), date DATE NOT NULL, description VARCHAR(255) NOT NULL);" +
                    "CREATE TABLE IF NOT EXISTS clients " +
                    "(login VARCHAR(60) PRIMARY KEY, email VARCHAR(60) NOT NULL, password VARCHAR(20) NOT NULL, is_admin BOOLEAN NOT NULL);";
            statement.execute(sql);
            statement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseManager getInstance(){
        if (dm == null){
            dm = new DatabaseManager();
        }
        return dm;
    }

    public Connection getCon(){
        try {
            String url = "jdbc:postgresql://localhost/Deadlines";
            return DriverManager.getConnection(url, "postgres", "Leti_1773");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

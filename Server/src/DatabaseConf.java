import java.io.Serializable;

public class DatabaseConf implements Serializable{
    private String host = "127.0.0.1";
    private int port = 8080;
    private String base = "Deadlines";
    private String login = "postgres";
    private String password = "Leti_1773";

    public DatabaseConf(){
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

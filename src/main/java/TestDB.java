import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestDB {
    private static final String URL = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASS = "root";
    public Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public TestDB(){
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

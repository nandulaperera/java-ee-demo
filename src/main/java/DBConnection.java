import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final String host = "localhost";
    private final String port = "3306";
    private final String database = "employee";
    private final String username = "root";
    private final String password = "";

    private Connection connection;
    private static DBConnection dbConnection;

    public DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //jdbc:mysql://localhost:3306/employee
        String url = "jdbc:mysql://"+host+":"+port+"/"+database;
        connection = DriverManager.getConnection(url, username, password);
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }

}

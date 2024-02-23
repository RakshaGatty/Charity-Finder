
package charityfinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/CharityFinder";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwerty@123!";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

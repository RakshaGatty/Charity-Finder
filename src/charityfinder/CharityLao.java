package charityfinder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author deeks_5t46200
 */
public class CharityLao {
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CharityFinder";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwerty@123!";
    /**
     * Creates new form CharityLao
     */
    public static boolean validate(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM donors_login WHERE username=? AND password=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Returns true if a matching record is found
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
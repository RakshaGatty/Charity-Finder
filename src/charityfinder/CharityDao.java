package charityfinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class CharityDao {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CharityFinder";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "qwerty@123!";

    // Insert Charity data into the database
    public static boolean insertCharity(int chid, String chname, String mission, String location, long contact) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO charity (chid, chname, mission, location, contact) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, chid);
                preparedStatement.setString(2, chname);
                preparedStatement.setString(3, mission);
                preparedStatement.setString(4, location);
                preparedStatement.setLong(5, contact);
               
                int rowsAffected = preparedStatement.executeUpdate();

                // If rowsAffected > 0, the insertion was successful
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception according to your needs
        }
        return false;
    }
    
    
    public static boolean updateCharity(int chid, String chname, String mission, String location, long contact) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "UPDATE charity SET chname=?, mission=?, location=?, contact=? WHERE chid=?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, chname);
                preparedStatement.setString(2, mission);
                preparedStatement.setString(3, location);
                preparedStatement.setLong(4, contact);
             
                preparedStatement.setInt(5, chid);
                
                int rowsAffected = preparedStatement.executeUpdate();
                
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteCharity(int chid) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM charity WHERE chid=?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, chid);
                
                int rowsAffected = preparedStatement.executeUpdate();
                
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public static boolean insertDonation(int id,int chid,int amt) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO donate (id, chid, amt) VALUES (?, ?, ?)";


            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, chid);
                preparedStatement.setInt(3, amt);
               
                int rowsAffected = preparedStatement.executeUpdate();

                // If rowsAffected > 0, the insertion was successful
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception according to your needs
        }
        return false;
    }
    
}



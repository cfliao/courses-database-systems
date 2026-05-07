package nccu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Demo1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "nccutest";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to MySQL successfully: " + !connection.isClosed());
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

}

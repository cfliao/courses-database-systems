package nccu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "nccutest";
        // Step 1: 載入JDBC驅動程式
        // Step 2: 取得資料庫連結
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to MySQL successfully: " + !connection.isClosed());

            // Step 3: 建立Statement物件
            Statement stmt = connection.createStatement();

            // Step 4: 下SQL
            ResultSet rs = stmt.executeQuery(
                    "SELECT * from department");

            // Step 5: 處理查詢結果
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 印出所有 column name
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + (i < columnCount ? "\t" : "\n"));
            }

            while (rs.next()) {
                // 以System.out.println()，將結果印出來
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + (i < columnCount ? "\t" : "\n"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}

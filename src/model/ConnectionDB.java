package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

        public static Connection testConnection() throws SQLException{
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "12345678");
            System.out.println("Database connected!");
            connection.close();
        } catch (Exception e) {
            System.out.println("Database not connected!");
            System.out.println(e);    
        }
        return null;
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "12345678");
    }
   
}

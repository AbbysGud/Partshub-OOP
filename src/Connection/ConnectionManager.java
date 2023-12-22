package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/partshub?zeroDateTimeBehavior=convertToNull";
    private Connection c;
    
    public Connection getConnection() {     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                c = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }        
        if (c != null) {
            System.out.println("Database connected");
        } else {
            System.out.println("Database not connected");
        }
        return c;
    }
    
    public void closeConnection(){     
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int checkConnection(){
        c = null;
        int hasil = 0;
        try {
            c = DriverManager.getConnection(url, user, password);
            hasil = 1;
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        } finally {
            // Close the connection if it was successfully established
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return hasil;
    }
}

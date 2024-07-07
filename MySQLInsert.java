package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLInsert {
    public void show() {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "SriHasini@2005");
            System.out.println("Connection established");
            
            s = c.createStatement();
            s.executeUpdate("CREATE TABLE IF NOT EXISTS emp12(name VARCHAR(20), salary INT)");
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MySQLInsert insertData = new MySQLInsert();
        insertData.show();
    }
}

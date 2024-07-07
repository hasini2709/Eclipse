package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveData {
    public void retrieveData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "SriHasini@2005");
            System.out.println("Connection established");

            // Create a statement
            statement = connection.createStatement();

            // Execute the SQL query
            String selectSQL = "SELECT * FROM emp12";
            resultSet = statement.executeQuery(selectSQL);

            // Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RetrieveData retrieveData = new RetrieveData();
        retrieveData.retrieveData();
    }
}

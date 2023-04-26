import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

// Name: Apoorv Gupta
// PRN: 21070126018
// Batch: AIML-A1
// Assignment 9: Write a Java program to insert, update and display records from the 'student_jdbc' table using JDBC.


public class As9 {
    public static void main(String[] args) {
        // JDBC connection details
        String url = "jdbc:mysql://localhost:3306/jdbcdemo"; // URL of the database
        String username = "root"; // Username for the database
        String password = "1234"; // Password for the database

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement to execute SQL queries
            Statement statement = connection.createStatement();

            // Insert a new record into the 'student_jdbc' table
            int result = statement.executeUpdate("INSERT INTO student_jdbc (name, age, gender) VALUES ('Arjun', 19,'Male')");

            // Update an existing record in the 'student_jdbc' table
            int result2 = statement.executeUpdate("UPDATE student_jdbc SET name='Arjun Tyagi', age=20, gender='Male' WHERE id=3");

            // Display the contents of the 'student_jdbc' table
            display(statement);

            // Close the database connection
            connection.close();
        }
        catch (Exception e) {
            // Print an error message if there is a problem with the JDBC connection
            System.out.println("Where is your MySQL JDBC Driver?" + "\n" + e);
            e.printStackTrace();
            return;
        }
    }

    public static void display(Statement statement){
        try{
            // Execute a SELECT query and get the result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student_jdbc");

            // Iterate over the result set and display each record
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));
            }
        } catch (Exception e) {
            // Print an error message if there is a problem with displaying the data
            System.out.println("Error displaying data: " + e.getMessage());
        }
    }
}

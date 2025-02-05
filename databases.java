import java.sql.*;

public class databases{
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            System.out.println("List of students:");
            String selectQuery = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Age: " + resultSet.getInt("age") +
                        ", Major: " + resultSet.getString("major"));
            }
            String insertQuery = "INSERT INTO students (name, age, major) VALUES ('John', 20, 'Computer Science')";
            int rowsInserted = statement.executeUpdate(insertQuery);
            if (rowsInserted > 0) {
                System.out.println("New student added successfully.");
            }
            String updateQuery = "UPDATE students SET age = 21 WHERE name = 'John'";
            int rowsUpdated = statement.executeUpdate(updateQuery);
            if (rowsUpdated > 0) {
                System.out.println("Student information updated successfully.");
            }
            String deleteQuery = "DELETE FROM students WHERE name = 'John'";
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


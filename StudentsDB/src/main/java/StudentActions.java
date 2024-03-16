import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// This class provides the function implementations of the operations requested in the specs
public class StudentActions {
    // The following is an instance variable (as opposed to a static one) so that these functions can be used on multiple databases (by creating a separate instance of this class for each DB)
    // In other words, each instance of this class will have its own connection variable so that each one can connect to and query its own (specified) DB
    // If this was static, every instance of this class would connect to the same DB (which didn't feel useful)
    Connection connection;

    // Constructor that takes in a url, user and password and sets up a connection to the DB
    public StudentActions(String url, String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            // Print out a message indicating whether the connection was successful
            if (connection != null) {
                System.out.println("Connected \n");
            } else {
                System.out.println("Failed to connect \n");
            }
        } catch (Exception e) {
            // If an exception is raised at any point, catch it and print it out
            System.out.println(e);
        }
    }

    // Prints all rows of the Students table
    public void getAllStudents() {
        try {
            Statement statement = connection.createStatement();
            // Use SELECT * to get all the records stored in the Students table
            statement.executeQuery("SELECT * FROM students");

            ResultSet resultSet = statement.getResultSet();
            // Print out a header specifying the columns names
            System.out.println("student_id | first_name | last_name | email | enrollment_date \n");

            // Iterate through all the records and print out each one in a single line
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("student_id") + " \t");
                System.out.print(resultSet.getString("first_name") + " \t");
                System.out.print(resultSet.getString("last_name") + " \t");
                System.out.print(resultSet.getString("email") + " \t");
                System.out.println(resultSet.getDate("enrollment_date"));
            }
        } catch (Exception e) {
            // If an exception is raised at any point, catch it and print it out
            System.out.println(e);
        }
    }

    // Adds a record to the Students table using the specified input variables
    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        try {
            Statement statement = connection.createStatement();

            // Format the input variables as a tuple
            // Note: If this was a larger scale application, I'd use a more secure approach to avoid SQL injection
            String rowToAdd = "('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')";

            // Use INSERT to add the tuple to the table and save the result of the executeUpdate() function in a variable
            int numRowsAdded = statement.executeUpdate(
                "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES " + rowToAdd
            );

            // Print out a message indicating whether the addition was successful (based on how many rows were added by executeUpdate())
            if (numRowsAdded == 1) {
                System.out.println("Student added successfully \n");
            } else {
                System.out.println("Failed to add student \n");
            }
        } catch (Exception e) {
            // If an exception is raised at any point, catch it and print it out
            System.out.println(e);
        }
    }

    // Updates the email of a record (specified by student_id) in the Students table
    // Note: I'm assuming that the student_id input variable is of type int
    public void updateStudentEmail(int student_id, String new_email) {
        try {
            Statement statement = connection.createStatement();

            // Use UPDATE and WHERE to update the email of the specified student and save the result of the executeUpdate() function in a variable
            // Note: If this was a larger scale application, I'd use a more secure approach to avoid SQL injection
            int numRowsUpdated = statement.executeUpdate(
                "UPDATE students SET email = '" + new_email + "' WHERE student_id = " + student_id
            );

            // Print out a message indicating whether the update was successful (based on how many rows were updated by executeUpdate())
            if (numRowsUpdated == 1) {
                System.out.println("Student updated successfully \n");
            } else {
                System.out.println("Failed to update student \n");
            }
        } catch (Exception e) {
            // If an exception is raised at any point, catch it and print it out
            System.out.println(e);
        }
    }

    // Deletes a record (specified by student_id) from the Students table
    // Note: I'm assuming that the student_id input variable is of type int
    public void deleteStudent(int student_id) {
        try {
            Statement statement = connection.createStatement();

            // Use DELETE and WHERE to delete the specified student and save the result of the executeUpdate() function in a variable
            // Note: If this was a larger scale application, I'd use a more secure approach to avoid SQL injection
            int numRowsDeleted = statement.executeUpdate(
                "DELETE FROM students WHERE student_id = " + student_id
            );

            // Print out a message indicating whether the deletion was successful (based on how many rows were deleted by executeUpdate())
            if (numRowsDeleted == 1) {
                System.out.println("Student deleted successfully \n");
            } else {
                System.out.println("Failed to delete student \n");
            }
        } catch (Exception e) {
            // If an exception is raised at any point, catch it and print it out
            System.out.println(e);
        }
    }
}

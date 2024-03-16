// This class creates an instance of the StudentActions class and tests its various functions
public class Main {
    public static void main (String[] args) {
        // IMPORTANT: Update the following variables if you'd like to connect to your own DB
        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "admin";

        // Create an instance of the StudentActions class, passing in the necessary variables to connect to the DB
        StudentActions actions = new StudentActions(url, user, password);

        // Testing the getAllStudents() function
        System.out.println("--- Testing getAllStudents() ---");
        actions.getAllStudents();

        // Testing the addStudent() function
        System.out.println("--- Testing addStudent() ---");
        actions.addStudent("Jack", "Son", "test.email@gmail.com", "2024-01-01");
        actions.getAllStudents();
        // The following should fail since the email isn't unique
        actions.addStudent("Jill", "Ian", "test.email@gmail.com", "2024-01-02");

        // Testing the updateStudentEmail() function
        System.out.println("--- Testing updateStudentEmail() ---");
        actions.updateStudentEmail(4, "new.email@gmail.com");
        actions.getAllStudents();
        // The following should fail since the student_id doesn't exist
        actions.updateStudentEmail(5, "new.email@gmail.com");

        // Testing the deleteStudent() function
        System.out.println("--- Testing deleteStudent() ---");
        actions.deleteStudent(4);
        actions.getAllStudents();
        // The following should fail since the student_id doesn't exist
        actions.deleteStudent(4);
    }
}

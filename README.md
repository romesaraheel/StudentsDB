# StudentsDB
This Java application connects to a PostgreSQL database containing a single relation, `Students`. This repo contains two SQL files to create and populate this table:
- [`tableCreation.sql`](StudentsDB/src/main/resources/tableCreation.sql): Creates a `Students` table consisting of 5 columns (student_id, first_name, last_name, email and enrollment_date)
- [`tableInsertion.sql`](StudentsDB/src/main/resources/tableInsertion.sql): Inserts 3 records into the `Students` table as a starting point

The app itself contains two classes that connect to the database and perform specific CRUD actions:
- [`StudentActions.java`](StudentsDB/src/main/java/StudentActions.java): Provides the function implementations of the actions/operations requested in the specs
    - `getAllStudents()`
    - `addStudent(addStudent(first_name, last_name, email, enrollment_date)`
    - `updateStudentEmail(student_id, new_email)`
    - `deleteStudent(student_id)`
- [`Main.java`](StudentsDB/src/main/java/Main.java): Creates an instance of the `StudentActions` class and tests its various functions

## Running the application
Note: The following instructions rely on the IntelliJ IDE and the pgAdmin4 PostgreSQL management tool. 

**Step 1: Creating and populating the database**
1. Clone this repo
2. Open pgAdmin4
3. Click _Servers_ (in the menu on the left)
4. Login using your password for the `postgres` user
5. Right click _Databases_ (in the menu on the left) > _Create_ > _Database_
6. Name the database `students`
7. Click _Save_
8. Locate the newly created database under _Databases_ (in the menu on the left)
9. Right click _students_ > _Query Tool_
10. Copy the contents of the [`tableCreation.sql`](StudentsDB/src/main/resources/tableCreation.sql) file and paste it into the query tool in pgAdmin4
11. Click the _Execute/Refresh_ button (in the top menu bar). You should then see the following message confirming that the query was successful:
    ```
    CREATE TABLE

    Query returned successfully in X msec.
    ```
12. Erase the query
13. Copy the contents of the[`tableInsertion.sql`](StudentsDB/src/main/resources/tableInsertion.sql) file and paste it into the query tool in pgAdmin4
14. Click the _Execute/Refresh_ button (in the top menu bar). You should then see the following message confirming that the query was successful:
    ```
    INSERT 0 3
    
    Query returned successfully in X msec.
    ```
15. Click _Schemas_ (in the menu on the left) > _public_ > _Tables_
16. You should see one table here titled `students`. To once again confirm that the data has been inserted, right click on _students_ > _View/Edit Data_ > _All Rows_. You should then see the three records in the Data Output tab.

**Step 2: Running the application**
1. Open the application in IntelliJ
2. Open [`Main.java`](StudentsDB/src/main/java/Main.java) in the IDE
3. Click _Build Project_ (in the top menu bar)
4. Once the build is finished, click _Run Main.java_ (in the top menu bar)
5. You should see the program output/results in the console

## Demo video
The demo video can be accessed here.

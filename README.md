Project Description:
This project is a Java-based desktop application designed for faculty and students. It enables registered faculty members to create quizzes and allows registered students to attempt the available quizzes.

Folder Descriptions
DBConnect

Contents:
databaseConnect.java: This file contains the logic for establishing a connection to the database. It ensures all other modules can interact with the database seamlessly.
Purpose: To manage and establish the connection between the application and the database.
StudentDatabase

Contents:
StudentDB_Connect.java: This file manages operations related to the student database, such as fetching student details or storing their quiz results.
Purpose: To handle all database-related operations for student data.
afterStudentLogin

Contents:
fillInB.java, multiChoice.java, selectQuiz.java, singleChoice.java, studentFinal.java
Purpose:
These files manage the functionality available to students after they log in, such as selecting quizzes and attempting questions (multiple-choice, single-choice, or fill-in-the-blank).
Notable Features:
Each file corresponds to a specific question type or action during quiz attempts.
createPageChoices

Contents:
FillInBlankFrame.java, finalPage.java, multiChoiceFrame.java, singleChoiceFrame.java
Purpose:
To provide the graphical user interface (GUI) for creating various types of quiz questions, like multiple-choice, single-choice, and fill-in-the-blank.
createPageQuestionTypes

Contents:
questionTypePage.java
Purpose:
Defines the interface or GUI for selecting the type of questions (e.g., multiple-choice, single-choice) while creating a quiz.
facultyLogin

Contents:
facultyLoginPage.java
Purpose:
Manages the login functionality for faculty members.
quiz

Contents:
Quiz.java: Contains the main quiz logic, including question navigation and scoring.
resources (Folder): Likely contains supporting files like images or text files for the quizzes.
Purpose:
The core logic of quizzes, including the backend and possible resource files.
quizAttemptBuffer

Contents:
bufferClass.java: Manages temporary storage of quiz attempts or ongoing quiz session details.
Purpose:
To ensure data is saved during a quiz attempt and possibly restore sessions in case of interruptions.
quizCreatePage1

Contents:
createPage1.java
Purpose:
Provides the starting interface for quiz creation by faculty.
Root Files

LICENSE: Details the licensing for using the project.
README.md: Contains an overview and instructions for setting up and running the application.
SE_Quiz.zip: Likely a compressed version of the entire project for easy sharing.
Usage Instructions
Set Up Database:

Ensure the required database is created and configured.
Use the DBConnect/databaseConnect.java file to verify or modify the database connection settings.
Faculty Usage:

Faculty members should log in through the facultyLogin/facultyLoginPage.java interface.
After logging in, they can create quizzes using createPageQuestionTypes/questionTypePage.java and corresponding files in createPageChoices.
Student Usage:

Students log in through the appropriate interface and can view available quizzes (afterStudentLogin/selectQuiz.java).
They can then attempt quizzes with support for different question types (handled by files in afterStudentLogin).
Compile and Run:

Use an IDE like IntelliJ IDEA or Netbeans to open the project. I suggest to use NetBeans.
Ensure all dependencies are resolved.

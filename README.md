# Java Desktop Application for Faculty and Students

## Project Description
This project is a Java-based desktop application designed for faculty and students. It enables registered faculty members to create quizzes and allows registered students to attempt the available quizzes.
Below you'll find the images of the project's GUI and the description of all the project files along with description of database that's associated with this project.

---
## Images
![All classes](https://github.com/user-attachments/assets/4a057373-0b99-4896-a51e-37d1bf26e2d4)
![All quizzes](https://github.com/user-attachments/assets/61c3c850-c291-40d7-93df-4104c2f6ee5e)
![User login](https://github.com/user-attachments/assets/6cae50f9-02c0-4ecd-b0c5-5e827e71caed)
![Login](https://github.com/user-attachments/assets/12a27ca9-4d6f-470c-814c-8d494a27c36b)
![invalid](https://github.com/user-attachments/assets/edaf319e-b624-4942-9b60-fee88cad5248)
![Sample question](https://github.com/user-attachments/assets/b1e19f87-de93-4178-abc7-eb57c9fd641c)
![student final](https://github.com/user-attachments/assets/9add180d-3734-4701-838f-73bc4b2df810)
![teacher create page](https://github.com/user-attachments/assets/6eaebbe6-b424-4e7c-b824-44080baf3ad9)
![types of questions](https://github.com/user-attachments/assets/aa2c41d7-e9a8-490b-a12a-aa29f7db64c1)



## Folder Descriptions

### **1. DBConnect**
- **Contents**:
  - `databaseConnect.java`: This file contains the logic for establishing a connection to the database. It ensures all other modules can interact with the database seamlessly.
- **Purpose**: To manage and establish the connection between the application and the database.

---

### **2. StudentDatabase**
- **Contents**:
  - `StudentDB_Connect.java`: This file manages operations related to the student database, such as fetching student details or storing their quiz results.
- **Purpose**: To handle all database-related operations for student data.

---

### **3. afterStudentLogin**
- **Contents**:
  - `fillInB.java`, `multiChoice.java`, `selectQuiz.java`, `singleChoice.java`, `studentFinal.java`
- **Purpose**: These files manage the functionality available to students after they log in, such as selecting quizzes and attempting questions (multiple-choice, single-choice, or fill-in-the-blank).
- **Notable Features**: Each file corresponds to a specific question type or action during quiz attempts.

---

### **4. createPageChoices**
- **Contents**:
  - `FillInBlankFrame.java`, `finalPage.java`, `multiChoiceFrame.java`, `singleChoiceFrame.java`
- **Purpose**: To provide the graphical user interface (GUI) for creating various types of quiz questions, like multiple-choice, single-choice, and fill-in-the-blank.

---

### **5. createPageQuestionTypes**
- **Contents**:
  - `questionTypePage.java`
- **Purpose**: Defines the interface or GUI for selecting the type of questions (e.g., multiple-choice, single-choice) while creating a quiz.

---

### **6. facultyLogin**
- **Contents**:
  - `facultyLoginPage.java`
- **Purpose**: Manages the login functionality for faculty members.

---

### **7. quiz**
- **Contents**:
  - `Quiz.java`: Contains the main quiz logic, including question navigation and scoring.
  - **resources (Folder)**: Likely contains supporting files like images or text files for the quizzes.
- **Purpose**: The core logic of quizzes, including the backend and possible resource files.

---

### **8. quizAttemptBuffer**
- **Contents**:
  - `bufferClass.java`: Manages temporary storage of quiz attempts or ongoing quiz session details.
- **Purpose**: To ensure data is saved during a quiz attempt and possibly restore sessions in case of interruptions.

---

### **9. quizCreatePage1**
- **Contents**:
  - `createPage1.java`
- **Purpose**: Provides the starting interface for quiz creation by faculty.

---

### **10. Root Files**
- **LICENSE**: Details the licensing for using the project.
- **README.md**: Contains an overview and instructions for setting up and running the application.
- **SE_Quiz.zip**: Likely a compressed version of the entire project for easy sharing.

---

## Usage Instructions

### **Set Up Database**
1. Ensure the required database is created and configured.
2. Use the `DBConnect/databaseConnect.java` file to verify or modify the database connection settings.

### **Faculty Usage**
1. Faculty members should log in through the `facultyLogin/facultyLoginPage.java` interface.
2. After logging in, they can create quizzes using `createPageQuestionTypes/questionTypePage.java` and corresponding files in `createPageChoices`.

### **Student Usage**
1. Students log in through the appropriate interface and can view available quizzes (`afterStudentLogin/selectQuiz.java`).
2. They can then attempt quizzes with support for different question types (handled by files in `afterStudentLogin`).

### **Compile and Run**
1. Use an IDE like IntelliJ IDEA or NetBeans to open the project. (NetBeans is recommended.)
2. Ensure all dependencies are resolved.

---

## Database Structure Description

### **Database: `questionsdb`**
This is the primary database containing all tables required for the project.

---

### **Tables Description**

#### **1. Table: `attempted`**
- **Purpose**: Tracks quizzes that have been attempted by students.
- **Columns**:
  - `sno`: A unique identifier for each record.
  - `roll`: The roll number of the student who attempted the quiz.
  - `testname`: The name of the quiz attempted.
  - `attempt`: The number of attempts made by the student.

#### **2. Table: `faculty`**
- **Purpose**: Stores login credentials for registered faculty members.
- **Columns**:
  - `sno`: A unique identifier for each faculty member.
  - `roll`: A unique identifier or username for the faculty.
  - `password`: The password for faculty login.

#### **3. Table: `marks`**
- **Purpose**: Records the scores of students for completed quizzes.
- **Columns**:
  - `sno`: A unique identifier for each record.
  - `name`: The name of the student.
  - `score`: The score obtained by the student.

#### **4. Table: `quizzes`**
- **Purpose**: Maintains information about quizzes created by faculty.
- **Columns**:
  - `sno`: A unique identifier for each quiz.
  - `tablename`: The name of the table storing quiz questions.
  - `totalquestions`: Total number of questions in the quiz.
  - `hour`, `minute`, `second`: Duration of the quiz.
  - `published`: A flag indicating whether the quiz is available for students.

#### **5. Table: `student_info`**
- **Purpose**: Stores login credentials for registered students.
- **Columns**:
  - `sno`: A unique identifier for each student.
  - `roll`: A unique identifier or username for the student.
  - `password`: The password for student login.

---


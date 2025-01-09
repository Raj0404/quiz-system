/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz;

/**
 *
 * @author rajdi
 */
import afterStudentLogin.*;
import javax.swing.*;
import java.awt.event.*;
import StudentDatabase.StudentDB_Connect;
import quizCreatePage1.createPage1;
import DBConnect.*;
import java.sql.Connection;
import java.awt.*;
import javax.swing.SwingUtilities;


class CheckStudentDetails {
    Boolean LoginChecker(String[] GivenStudentDetails) {
        StudentDB_Connect obj = new StudentDB_Connect();
        String[] buffer = new String[2];
        String attribute1 = "roll";
        String query1 = "Select " + attribute1 + " From student_info";
        String attribute2 = "password";
        String query2 = "Select " + attribute2 + " From student_info";
        buffer[0] = obj.StudentDB_Details(query1, attribute1);
        buffer[1] = obj.StudentDB_Details(query2, attribute2);
        if ((buffer[0].equals(GivenStudentDetails[0])) && (buffer[1].equals(GivenStudentDetails[1]))) {
            return true;
        }
        return false;
    }
}


class CheckStudentDetails2 {
    Boolean LoginChecker2(String[] GivenStudentDetails) {
        StudentDB_Connect obj = new StudentDB_Connect();
        String[] buffer = new String[2];
        String attribute1 = "roll";
        String query1 = "Select " + attribute1 + " From faculty";
        String attribute2 = "password";
        String query2 = "Select " + attribute2 + " From faculty";
        buffer[0] = obj.StudentDB_Details(query1, attribute1);
        buffer[1] = obj.StudentDB_Details(query2, attribute2);
        System.out.println(buffer[0]);
        System.out.println(buffer[1]);
        System.out.println(GivenStudentDetails[0]);
        System.out.println(GivenStudentDetails[1]);
        if ((buffer[0].equals(GivenStudentDetails[0])) && (buffer[1].equals(GivenStudentDetails[1]))) {
            return true;
        }
        return false;
    }
}

class StudentMain {
    void StudentMain_Page1() {
        
        JFrame QuizSelect = new JFrame();
        QuizSelect.setTitle("Quizzy");
        QuizSelect.setVisible(true);
        QuizSelect.setLayout(null);
        QuizSelect.setSize(1500, 800);

    }
}

class FirstPage {

    void page1() {
         GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame frame_page1 = new JFrame();
        frame_page1.setTitle("Quizzy");
        frame_page1.setVisible(true);
        frame_page1.setLayout(null);
        //frame_page1.setSize(1500, 800);
        frame_page1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel background=new JLabel(new ImageIcon("C:/Users/rajdi/OneDrive/Desktop/16183196_NEUMORPHIC_CIRCLES_BACKGROUND.jpg"));
        background.setLayout(new FlowLayout());
        background.setSize(1520,850);
        
        JLabel Heading = new JLabel("User Login");
        Heading.setBounds(700, 230, 400, 50);
        Heading.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        Heading.setForeground(Color.WHITE);
        
        
        
        frame_page1.add(Heading);
        JButton Student = new JButton("Student");
        
        
        
        JButton Teacher = new JButton("Teacher");
        Student.setBounds(730, 360, 150, 70);
        //Student.setBackground(Color.WHITE);
        Student.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Teacher.setFont(new Font("Times New Roman", Font.PLAIN, 20));
       
        Teacher.setBounds(730, 460, 150, 70);
        frame_page1.add(Student);
        frame_page1.add(Teacher);
        frame_page1.add(background);
        frame_page1.revalidate();
        
        Student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame_page1.dispose();
                FirstPage ob = new FirstPage();
                ob.StudentPage();
            }
        });
        
        Teacher.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                FirstPage ob = new FirstPage();
                ob.FacultyPage();
                frame_page1.dispose();
            }
        
        });

        
        device.setFullScreenWindow(frame_page1);
        //device.setFullScreenWindow(background);
    }

    void StudentPage() {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame frame_StudentLogin = new JFrame();
        frame_StudentLogin.setTitle("Student Login Page");
        frame_StudentLogin.setVisible(true);
        frame_StudentLogin.setLayout(null);
        //frame_StudentLogin.setSize(1500, 800);
        frame_StudentLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel background=new JLabel(new ImageIcon("C:/Users/rajdi/OneDrive/Desktop/16183196_NEUMORPHIC_CIRCLES_BACKGROUND.jpg"));
        background.setLayout(new FlowLayout());
        background.setSize(1520,850);
        
        
        
        
        JLabel StudentUserName = new JLabel();
        JLabel StudentPassWord = new JLabel();
        JTextField StudentUserName_Enter = new JTextField();
        JPasswordField StudentPassWord_Enter = new JPasswordField();
        
        
        JButton StudentLoginSubmit = new JButton();
        JLabel LoginError = new JLabel();
        LoginError.setText("INVALID DETAILS. PLEASE TRY AGAIN.");
        LoginError.setBounds(600, 310, 600, 30);
        LoginError.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        LoginError.setForeground(Color.RED);
        LoginError.setVisible(false);
        
        
        frame_StudentLogin.add(LoginError);
        
        
        
        StudentUserName.setText("Username: ");
        StudentPassWord.setText("Password: ");
        StudentLoginSubmit.setText("Submit");
        
        
        
        StudentUserName.setBounds(650, 380, 500, 30);
        StudentUserName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        StudentUserName.setForeground(Color.WHITE);
        
        
        StudentPassWord.setBounds(650, 430, 500, 30);
        StudentPassWord.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        StudentPassWord.setForeground(Color.WHITE);
        
        
        
        StudentUserName_Enter.setBounds(800, 380, 200, 30);
        StudentPassWord_Enter.setBounds(800, 430, 200, 30);
        
        
        StudentLoginSubmit.setBounds(730, 490, 200, 50);
        StudentLoginSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        StudentLoginSubmit.setForeground(Color.BLACK);

        StudentLoginSubmit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] GivenStudent_Details = new String[2];
                GivenStudent_Details[0] = StudentUserName_Enter.getText();
                GivenStudent_Details[1] = StudentPassWord_Enter.getText();
                // System.out.println(GivenStudent_Details[1]);
                CheckStudentDetails check = new CheckStudentDetails();
                if (check.LoginChecker(GivenStudent_Details) == true) {

                    selectQuiz ob = new selectQuiz();
                    frame_StudentLogin.dispose();
                    ob.chooseQuiz();
                } else {
                    LoginError.setVisible(true);

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            };

            public void mousePressed(MouseEvent e) {
            };

            public void mouseReleased(MouseEvent e) {
            };

            public void mouseExited(MouseEvent e) {
            };
        });

        // StudentLoginSubmit.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // String[] GivenStudent_Details = new String[2];
        // GivenStudent_Details[0] = StudentUserName_Enter.getText();
        // GivenStudent_Details[1] = StudentPassWord_Enter.getText();
        // CheckStudentDetails check = new CheckStudentDetails();
        // if (check.LoginChecker(GivenStudent_Details)) {
        // // new Frame
        // StudentMain StudentMainObject = new StudentMain();
        // StudentMainObject.StudentMain_Page1();
        // } else {
        // JLabel LoginError = new JLabel();
        // LoginError.setText("INVALID DETAILS. PLEASE TRY AGAIN.");
        // LoginError.setBounds(120, 100, 100, 20);
        // frame_StudentLogin.add(LoginError);
        // }
        // }
        // });
        frame_StudentLogin.add(StudentUserName);
        frame_StudentLogin.add(StudentPassWord);
        frame_StudentLogin.add(StudentUserName_Enter);
        frame_StudentLogin.add(StudentPassWord_Enter);
        frame_StudentLogin.add(StudentLoginSubmit);
        frame_StudentLogin.add(background);
        device.setFullScreenWindow(frame_StudentLogin);
    }






void FacultyPage() {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame frame_StudentLogin = new JFrame();
        frame_StudentLogin.setTitle("Teacher Login");
        frame_StudentLogin.setVisible(true);
        frame_StudentLogin.setLayout(null);
        //frame_StudentLogin.setSize(1500, 800);
        frame_StudentLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel background=new JLabel(new ImageIcon("C:/Users/rajdi/OneDrive/Desktop/16183196_NEUMORPHIC_CIRCLES_BACKGROUND.jpg"));
        background.setLayout(new FlowLayout());
        background.setSize(1520,850);
        
        
        
        
        JLabel StudentUserName = new JLabel();
        JLabel StudentPassWord = new JLabel();
        JTextField StudentUserName_Enter = new JTextField();
        StudentUserName_Enter.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JPasswordField StudentPassWord_Enter = new JPasswordField();
        StudentPassWord_Enter.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        
        JButton StudentLoginSubmit = new JButton();
        JLabel LoginError = new JLabel();
        LoginError.setText("INVALID DETAILS. PLEASE TRY AGAIN.");
        LoginError.setBounds(600, 310, 600, 30);
        LoginError.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        LoginError.setForeground(Color.RED);
        LoginError.setVisible(false);
        
        
        frame_StudentLogin.add(LoginError);
        
        
        
        StudentUserName.setText("Username: ");
        StudentPassWord.setText("Password: ");
        StudentLoginSubmit.setText("Submit");
        
        
        
        StudentUserName.setBounds(650, 380, 500, 30);
        StudentUserName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        StudentUserName.setForeground(Color.WHITE);
        
        
        StudentPassWord.setBounds(650, 430, 500, 30);
        StudentPassWord.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        StudentPassWord.setForeground(Color.WHITE);
        
        
        
        StudentUserName_Enter.setBounds(800, 380, 200, 30);
        StudentPassWord_Enter.setBounds(800, 430, 200, 30);
        
        
        StudentLoginSubmit.setBounds(730, 490, 200, 50);
        StudentLoginSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        StudentLoginSubmit.setForeground(Color.BLACK);

        StudentLoginSubmit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] GivenStudent_Details = new String[2];
                GivenStudent_Details[0] = StudentUserName_Enter.getText();
                GivenStudent_Details[1] = StudentPassWord_Enter.getText();
                // System.out.println(GivenStudent_Details[1]);
                CheckStudentDetails2 check = new CheckStudentDetails2();
                if (check.LoginChecker2(GivenStudent_Details) == true) {

                    Connection con;
                databaseConnect dbcObject = new databaseConnect();
                con = dbcObject.dbc();
                
                frame_StudentLogin.dispose();
                createPage1 ob = new createPage1();
                
                ob.testPage1(con);
                } else {
                    LoginError.setVisible(true);

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            };

            public void mousePressed(MouseEvent e) {
            };

            public void mouseReleased(MouseEvent e) {
            };

            public void mouseExited(MouseEvent e) {
            };
        });

        // StudentLoginSubmit.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // String[] GivenStudent_Details = new String[2];
        // GivenStudent_Details[0] = StudentUserName_Enter.getText();
        // GivenStudent_Details[1] = StudentPassWord_Enter.getText();
        // CheckStudentDetails check = new CheckStudentDetails();
        // if (check.LoginChecker(GivenStudent_Details)) {
        // // new Frame
        // StudentMain StudentMainObject = new StudentMain();
        // StudentMainObject.StudentMain_Page1();
        // } else {
        // JLabel LoginError = new JLabel();
        // LoginError.setText("INVALID DETAILS. PLEASE TRY AGAIN.");
        // LoginError.setBounds(120, 100, 100, 20);
        // frame_StudentLogin.add(LoginError);
        // }
        // }
        // });
        frame_StudentLogin.add(StudentUserName);
        frame_StudentLogin.add(StudentPassWord);
        frame_StudentLogin.add(StudentUserName_Enter);
        frame_StudentLogin.add(StudentPassWord_Enter);
        frame_StudentLogin.add(StudentLoginSubmit);
        frame_StudentLogin.add(background);
        device.setFullScreenWindow(frame_StudentLogin);
    }

}


public class Quiz {

    public static void main(String args[]) {
        FirstPage oFirstPage = new FirstPage();
        oFirstPage.page1();
    }

}

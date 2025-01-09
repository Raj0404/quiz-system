package quizCreatePage1;


import java.io.*;
import javax.swing.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.sql.*;
import createPageQuestionTypes.*;
import createPageChoices.*;
import java.awt.Font;


public class createPage1 {
    public void testPage1(Connection con) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame createTestPage1 = new JFrame();
        createTestPage1.setTitle("Quizzy");
        createTestPage1.setVisible(true);
        createTestPage1.setLayout(null);
        createTestPage1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font f = new Font("Times New Roman", Font.PLAIN, 30);
        
        
        // createTestPage1.setSize(1500, 800);
        JLabel testName = new JLabel("Test Name:");
        testName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        //JLabel timeLimit = new JLabel("Time Limit:");
        JLabel typeOfQuestions = new JLabel("Type Of Questions:");
        typeOfQuestions.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        //JLabel totalQuestions = new JLabel("Total Questions:");
       // JLabel marksToEachQuestion = new JLabel("Marks to each question:");
        JTextField testNameField = new JTextField();
        testNameField.setFont(f);
        //JTextField timeLimitField = new JTextField();
        //JLabel specifyMarks = new JLabel("Specify Marks: ");
        // JTextField typeOfQuestionsField = new JTextField();
        //JTextField totalQuestionsField = new JTextField();
        // JTextField marksToEachQuestionField = new JTextField();
        //JTextField specifyMarksField = new JTextField();
        JCheckBox singleChoice = new JCheckBox("Single Option Correct", true);
        singleChoice.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JCheckBox multipleChoice = new JCheckBox("Multiple Option Correct");
        multipleChoice.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JCheckBox FillInTheBlank = new JCheckBox("Fill in the blank");
        FillInTheBlank.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JCheckBox Descriptive = new JCheckBox("Descriptive");
        Descriptive.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        //JRadioButton fixed = new JRadioButton("Fixed");
        //JRadioButton vary = new JRadioButton("Vary");
        JButton next = new JButton("Next");

        testName.setBounds(550, 20, 400, 30);
        testNameField.setBounds(700, 20, 200, 30);
        //timeLimit.setBounds(20, 40, 100, 20);
        //timeLimitField.setBounds(100, 40, 100, 20);
        typeOfQuestions.setBounds(550, 60, 400, 30);
        // typeOfQuestionsField.setBounds(40, 60, 100, 20);
        singleChoice.setBounds(550, 100, 400, 30);
        multipleChoice.setBounds(550, 130, 400, 30);
        FillInTheBlank.setBounds(550, 160, 400, 30);
        Descriptive.setBounds(20, 190, 400, 30);
        //marksToEachQuestion.setBounds(20, 180, 200, 20);
        // marksToEachQuestionField.setBounds(40, 180, 10, 20);
        //fixed.setBounds(220, 180, 100, 20);
        //vary.setBounds(320, 180, 100, 20);
        //totalQuestions.setBounds(20, 160, 100, 20);
        //totalQuestionsField.setBounds(120, 160, 30, 20);
        //specifyMarks.setBounds(20, 200, 100, 20);
        //specifyMarksField.setBounds(120, 200, 30, 20);
        // specifyMarks.setVisible(false);
        // specifyMarksField.setVisible(false);
        next.setBounds(550, 200, 100, 30);
        next.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        next.addActionListener(new ActionListenerImpl(createTestPage1,singleChoice, multipleChoice, FillInTheBlank, Descriptive, con, testNameField));

        
        
        createTestPage1.add(testName);
        //createTestPage1.add(timeLimit);
        createTestPage1.add(typeOfQuestions);
        //createTestPage1.add(totalQuestions);
        //createTestPage1.add(marksToEachQuestion);
        createTestPage1.add(singleChoice);
        createTestPage1.add(multipleChoice);
        createTestPage1.add(FillInTheBlank);
       // createTestPage1.add(Descriptive);
        //createTestPage1.add(fixed);
        //createTestPage1.add(vary);
        createTestPage1.add(testNameField);
       // createTestPage1.add(timeLimitField);
        // createTestPage1.add(typeOfQuestionsField);
        // createTestPage1.add(marksToEachQuestionField);
        //createTestPage1.add(totalQuestionsField);
        //createTestPage1.add(specifyMarks);
       // createTestPage1.add(specifyMarksField);
        createTestPage1.add(next);
        device.setFullScreenWindow(createTestPage1);

    }

    private static class ActionListenerImpl  implements ActionListener  {

        private final JFrame createTestPage1;
        private final JCheckBox singleChoice;
        private final JCheckBox multipleChoice;
        private final JCheckBox FillInTheBlank;
        private final JCheckBox Descriptive;
        //private final JTextField timeLimitField;
        //private final JRadioButton fixed;
        //private final JTextField specifyMarksField;
        private final Connection con;
        private final JTextField testNameField;

        public ActionListenerImpl(JFrame createTestPage1,JCheckBox singleChoice, JCheckBox multipleChoice, JCheckBox FillInTheBlank, JCheckBox Descriptive,  Connection con, JTextField testNameField) {
            this.createTestPage1= createTestPage1;
            this.singleChoice = singleChoice;
            this.multipleChoice = multipleChoice;
            this.FillInTheBlank = FillInTheBlank;
            this.Descriptive = Descriptive;
            //this.timeLimitField = timeLimitField;
            //this.fixed = fixed;
            //this.specifyMarksField = specifyMarksField;
            this.con = con;
            this.testNameField = testNameField;
        }

        @Override
        public void actionPerformed(ActionEvent e)  {
            JLabel invalid = new JLabel();
         if(testNameField.getText().isBlank()){
             
             invalid.setText("Invalid Quiz Name");
             invalid.setBounds(220,20,200,30);
             createTestPage1.add(invalid);
             createTestPage1.repaint();
         }
         else if(testNameField.getText().contains(" ")){
            
             invalid.setText("Invalid Quiz Name");
             invalid.setBounds(220,20,300,30);
             createTestPage1.add(invalid);
             createTestPage1.repaint();
         }
         else{
                try {
                int sno = 1, questionType = 0,timeLimit=0,marksAssociated=0;
                if (singleChoice.isSelected()) {
                    questionType++;
                }
                if (multipleChoice.isSelected()) {
                    questionType++;
                }
                if (FillInTheBlank.isSelected()) {
                    questionType++;
                    
                }
                if (Descriptive.isSelected()) {
                    questionType++;
                    
                }
                
//                timeLimit = Integer.parseInt(timeLimitField.getText().strip());
//                if (fixed.isEnabled()) {
//                    marksAssociated = Integer.parseInt(specifyMarksField.getText().strip());
//                }
                Statement stmt = con.createStatement();
                String createTableStmt;
                String updateQuizzes;
       
                
                if(questionType > 1){
                    questionTypePage ob = new questionTypePage();
                    ob.questionTypPage(con,testNameField.getText().strip(),sno);
                    createTestPage1.dispose();
                }
                else{
                    if(singleChoice.isSelected()){
                        singleChoiceFrame ob = new singleChoiceFrame();
                        ob.singleChoicePage(con,testNameField.getText().strip(),sno);
                         createTestPage1.dispose();
                    }
                    if(multipleChoice.isSelected()){
                         createTestPage1.dispose();
                    }
                    if (FillInTheBlank.isSelected()) {
                        FillInBlankFrame ob = new FillInBlankFrame();
                        ob.FillInBlankPage(con,testNameField.getText().strip(),sno);
                         createTestPage1.dispose();
                    }
                    if (Descriptive.isSelected()) {
                         createTestPage1.dispose();
                    }
                }
                
                
                
                createTableStmt = "CREATE TABLE " + testNameField.getText().strip()
                        + "(sno INT, qtype INT, qname varchar(100), op1 varchar(50),op2 varchar(50), op3 varchar(50), op4 varchar(50), cop varchar(50), marks INT, cop2 varchar(50),cop3 varchar(50),cop4 varchar(50))";
                stmt.executeUpdate(createTableStmt);
                
                String getMaxSno = "SELECT max  (sno) FROM quizzes";
                ResultSet r = stmt.executeQuery(getMaxSno);
                r.next();
                int maxSno = r.getInt("max(sno)");
                maxSno++;
                
                updateQuizzes = "INSERT INTO quizzes VALUES("+Integer.toString(maxSno)+","+"'"+ testNameField.getText().strip()+"'"+"null,null,null,null"+","+"0"+");";
                stmt.executeUpdate(updateQuizzes);
         
                
            } catch (NumberFormatException | SQLException except) {
                JLabel error = new JLabel("Sorry but the server is busy or the quiz name is already in use. Please try using a different name or try back later.");
                error.setBounds(220, 20, 500, 20);
                System.out.println(except);
            }
                }
        }
    }

}
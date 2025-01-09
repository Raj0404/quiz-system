/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package createPageChoices;

import DBConnect.databaseConnect;
import javax.swing.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class finalPage {
    public void finalPageFrame(Connection con,String testName,int totQues,int sno){
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame FPF = new JFrame();
        FPF.setTitle("Finish");
        FPF.setVisible(true);
        FPF.setLayout(null);
        
        
        JLabel quizName = new JLabel("Quiz Name: ");
        JLabel questions = new JLabel("Total questions: ");
        JLabel actualQuizName = new JLabel(testName);
        JLabel totalQuestions = new JLabel(Integer.toString(totQues));
        JLabel status = new JLabel("Status");
        JLabel timeLimit = new JLabel("Time Limit(H:M:S)");
        JButton active = new JButton("Active");
        JButton inactive = new JButton("Inactive");
        JButton finish = new JButton("Finish");
        JTextField hourTextField = new JTextField(5);  
        JTextField minuteTextField = new JTextField(5);
        JTextField secondTextField = new JTextField(5);
        
        
        quizName.setBounds(20,20,100,30);
        questions.setBounds(20,40,100,30);
        actualQuizName.setBounds(130,20,100,30);
        totalQuestions.setBounds(130,40,100,30);
        status.setBounds(20,80,100,30);
        active.setBounds(130,80,100,30);
        inactive.setBounds(240,80,100,30);
        timeLimit.setBounds(20,120,100,30);
        hourTextField.setBounds(130,120,30,30);
        minuteTextField.setBounds(160,120,30,30);
        secondTextField.setBounds(190,120,30,30);
        finish.setBounds(142,180,100,30);
        
        
        active.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    databaseConnect ob = new databaseConnect();
        Connection con = ob.dbc();
        Statement stmt = con.createStatement();
        String SelectStmt;
        SelectStmt = "SELECT sno FROM quizzes Where tablename=" + "'"+ testName + "';";
        System.out.println(SelectStmt);
        ResultSet resultSet =stmt.executeQuery(SelectStmt);
        //System.out.println(resultSet);
        resultSet.next();
        
        int sno=resultSet.getInt("sno");
                    
                    
                    
                    
                    Statement stmt2 = con.createStatement();
                    String s = "UPDATE quizzes SET published=1 WHERE sno="+Integer.toString(sno)+";";
                    stmt2.executeUpdate(s);
                    
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        
        
        });
        
        
        
              inactive.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    databaseConnect ob = new databaseConnect();
        Connection con = ob.dbc();
        Statement stmt = con.createStatement();
        String SelectStmt;
        SelectStmt = "SELECT sno FROM quizzes Where tablename=" + "'"+ testName + "';";
        System.out.println(SelectStmt);
        ResultSet resultSet =stmt.executeQuery(SelectStmt);
        //System.out.println(resultSet);
        resultSet.next();
        
        int sno=resultSet.getInt("sno");
                    
                    
                    
                    
                    Statement stmt2 = con.createStatement();
                    String s = "UPDATE quizzes SET published=0 WHERE sno="+Integer.toString(sno)+";";
                    stmt2.executeUpdate(s);
                    
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        
        
        });
        
        finish.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                Statement stmt = con.createStatement();
                String s = "UPDATE quizzes SET hour=" + hourTextField.getText().strip()+",minute="+ minuteTextField.getText().strip()+",second=" + secondTextField.getText().strip()+" WHERE tablename=" + "'"+ testName + "';";
                stmt.executeUpdate(s);
                s="UPDATE quizzes SET totalquestions="+Integer.toString(totQues)+" WHERE tablename=" + "'"+ testName + "';";
                stmt.executeUpdate(s);
                
                s="INSERT INTO "+"'"+testName+"'" +" VALUES("+Integer.toString(sno+1)+",2,'',null,null,null,null,null,null,null,null,null);";
                stmt.executeUpdate(s);
                
                System.exit(0);
                
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });
        
        
        FPF.add(quizName);
        FPF.add(questions);
        FPF.add(actualQuizName);
        FPF.add(totalQuestions);
        FPF.add(status);
        FPF.add(active);
        FPF.add(inactive);
        FPF.add(hourTextField);
        FPF.add(minuteTextField);
        FPF.add(secondTextField);
        FPF.add(finish);
        FPF.add(timeLimit);
        
        
        
        
        
        
        
        
        
        
        device.setFullScreenWindow(FPF);
    }
}

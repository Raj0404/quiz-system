/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package createPageChoices;

import createPageQuestionTypes.questionTypePage;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rajdi
 */
public class FillInBlankFrame {
    public void FillInBlankPage(Connection con,String testName,int sno) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame FIB = new JFrame();
        FIB.setTitle("Fill In the Blank ");
        FIB.setVisible(true);
        FIB.setLayout(null);

        JLabel question = new JLabel("Enter Question:");
        question.setBounds(20, 20, 100, 20);
        JTextArea questionField = new JTextArea();
        questionField.setBounds(20, 40, 1480, 300);
        questionField.setLineWrap(true);
        JLabel answer = new JLabel("Enter the answer: ");
        answer.setBounds(20, 350, 150, 30);
        JTextField answerField = new JTextField();
        answerField.setBounds(130, 350, 100, 30);
        JButton next = new JButton("Next");
        JButton finish = new JButton("Finish");
        next.setBounds(20,410,100,30);
        finish.setBounds(20,450,100,30);
        
        int newSNO = sno+1;
        
        
        
        
        finish.addActionListener(new ActionListenerImp2(con, testName, sno, questionField, answerField, FIB,newSNO));
        next.addActionListener(new ActionListenerImpl(con, testName, sno, questionField, answerField, FIB,newSNO));

        FIB.add(answerField);
        FIB.add(answer);
        FIB.add(questionField);
        FIB.add(question);
        FIB.add(next);
        FIB.add(finish);
        device.setFullScreenWindow(FIB);
    
}

    private static class ActionListenerImpl implements ActionListener {

        private final Connection con;
        private final String testName;
        private final int sno;
        private final int newSNO;
        private final JTextArea questionField;
        private final JTextField answerField;
        private final JFrame FIB;

        public ActionListenerImpl(Connection con, String testName, int sno, JTextArea questionField, JTextField answerField, JFrame FIB,int newSNO) {
            this.con = con;
            this.testName = testName;
            this.sno = sno;
            this.questionField = questionField;
            this.answerField = answerField;
            this.FIB = FIB;
            this.newSNO = newSNO;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            try{
                Statement stmt = con.createStatement();
                String a ="INSERT INTO "+ testName+" VALUES("+Integer.toString(sno)+",3,"+"'"+ questionField.getText().strip()+"'" +","+ "null" +"," + "null" +"," + "null" +","+ "null" +"," + "'"+ answerField.getText().strip()+"'" +"," + "null" +","+"null," +"null," +"null"+");";
                questionTypePage ob = new questionTypePage();
                ob.questionTypPage(con,testName,newSNO);
                FIB.dispose();
                stmt.executeUpdate(a);
                
                
                
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
    
    
    
    
    
    private static class ActionListenerImp2 implements ActionListener {

        private final Connection con;
        private final String testName;
        private final int sno;
        private final int newSNO;
        private final JTextArea questionField;
        private final JTextField answerField;
        private final JFrame FIB;

        public ActionListenerImp2(Connection con, String testName, int sno, JTextArea questionField, JTextField answerField, JFrame FIB,int newSNO) {
            this.con = con;
            this.testName = testName;
            this.sno = sno;
            this.questionField = questionField;
            this.answerField = answerField;
            this.FIB = FIB;
            this.newSNO = newSNO;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            try{
                Statement stmt = con.createStatement();
                String a ="INSERT INTO "+ testName+" VALUES("+Integer.toString(sno)+",3,"+"'"+ questionField.getText().strip()+"'" +","+ "null" +"," + "null" +"," + "null" +","+ "null" +"," + "'"+ answerField.getText().strip()+"'" +"," + "null" +","+"null," +"null," +"null"+");";
                finalPage ob = new finalPage();
                ob.finalPageFrame(con,testName,sno,sno);
                FIB.dispose();
                stmt.executeUpdate(a);
                
                
                
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
}

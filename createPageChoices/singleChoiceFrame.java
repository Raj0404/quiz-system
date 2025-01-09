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
import javax.swing.SwingUtilities;
import java.sql.*;

/**
 *
 * @author rajdi
 */
public class singleChoiceFrame {
    int y = 430,i=1;

   public void singleChoicePage(Connection con,String tableName,int sno) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame singleChoice = new JFrame();
        singleChoice.setTitle("Single Choice ");
        singleChoice.setVisible(true);
        singleChoice.setLayout(null);

        JLabel question = new JLabel("Enter Question:");
        
        JTextArea questionField = new JTextArea();
        JButton next = new JButton("Next");
        JButton finish = new JButton("Finish");
        JLabel marks = new JLabel("Enter Marks");
        JTextField marksField = new JTextField();
        JTextField op1 = new JTextField(null);
        JLabel error = new JLabel("Please Enter previous option first");
        JLabel correctOption = new JLabel("Enter the correct option");
        
        JTextField op2 = new JTextField(null);
        JTextField op3 = new JTextField(null);
        JTextField op4 = new JTextField(null);
        JTextField cop = new JTextField(null);
        
        error.setVisible(false);
        
        
        question.setBounds(20, 20, 100, 20);
        questionField.setBounds(20, 40, 1480, 300);
        
        next.setBounds(20,720,100,30);
        finish.setBounds(130,720,100,30);
        marks.setBounds(20,590,100,30);
        marksField.setBounds(130,590,40,30);
        op1.setBounds(20,390,100,30);
        op2.setBounds(20,430,100,30);
        op3.setBounds(20,470,100,30);
        op4.setBounds(20,510,100,30);
        correctOption.setBounds(20,550,200,30);
        cop.setBounds(240,550,100,30);
        
        
        
  
        
        
        questionField.setLineWrap(true);
        singleChoice.add(question);
        
        singleChoice.add(questionField);
        singleChoice.add(next);
        singleChoice.add(finish);
        singleChoice.add(marks);
        singleChoice.add(marksField);
        singleChoice.add(op1);
        singleChoice.add(op2);
        singleChoice.add(op3);
        singleChoice.add(op4);
        singleChoice.add(error);
        singleChoice.add(correctOption);
        singleChoice.add(cop);

      
        int newSNO = sno+1;
        
         finish.addActionListener(new ActionListenerImp2(con, tableName, sno, op1, op2, op3, op4, cop, marksField, singleChoice,newSNO,questionField)
        );
        
        
        next.addActionListener(new ActionListenerImpl(con, tableName, sno, op1, op2, op3, op4, cop, marksField, singleChoice,newSNO,questionField)
        );

        device.setFullScreenWindow(singleChoice);
    }

    private static class ActionListenerImpl implements ActionListener {

        private final Connection con;
        private final String tableName;
        private final int sno;
        private final JTextField op1;
        private final JTextField op2;
        private final JTextField op3;
        private final JTextField op4;
        private final JTextField cop;
        private final JTextField marksField;
        private final JFrame singleChoice;
        private final int newSNO;
        private final JTextArea questionField;

        public ActionListenerImpl(Connection con, String tableName, int sno, JTextField op1, JTextField op2, JTextField op3, JTextField op4, JTextField cop, JTextField marksField, JFrame singleChoice,int newSNO,JTextArea questionField) {
            this.con = con;
            this.tableName = tableName;
            this.sno = sno;
            this.op1 = op1;
            this.op2 = op2;
            this.op3 = op3;
            this.op4 = op4;
            this.cop = cop;
            this.marksField = marksField;
            this.singleChoice = singleChoice;
            this.newSNO=newSNO;
            this.questionField = questionField;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            
            try{
                Statement stmt = con.createStatement();
                String a ="INSERT INTO "+ tableName+" VALUES("+Integer.toString(sno)+",1,"+"'"+ questionField.getText().strip()+"'" +","+"'"+ op1.getText().strip()+"'"+","+"'" + op2.getText().strip() +"'"+","+"'" + op3.getText().strip() +"'"+","+"'"+ op4.getText().strip() +"'"+","+"'" + cop.getText().strip() +"'"+","+"'" + marksField.getText().strip() +"'"+","+"null," +"null," +"null"+");";
                 stmt.executeUpdate(a);
                
                questionTypePage ob = new questionTypePage();
                ob.questionTypPage(con,tableName,newSNO);
                singleChoice.dispose();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }





private static class ActionListenerImp2 implements ActionListener {

        private final Connection con;
        private final String tableName;
        private final int sno;
        private final JTextField op1;
        private final JTextField op2;
        private final JTextField op3;
        private final JTextField op4;
        private final JTextField cop;
        private final JTextField marksField;
        private final JFrame singleChoice;
        private final int newSNO;
        private final JTextArea questionField;

        public ActionListenerImp2(Connection con, String tableName, int sno, JTextField op1, JTextField op2, JTextField op3, JTextField op4, JTextField cop, JTextField marksField, JFrame singleChoice,int newSNO,JTextArea questionField) {
            this.con = con;
            this.tableName = tableName;
            this.sno = sno;
            this.op1 = op1;
            this.op2 = op2;
            this.op3 = op3;
            this.op4 = op4;
            this.cop = cop;
            this.marksField = marksField;
            this.singleChoice = singleChoice;
            this.newSNO=newSNO;
            this.questionField = questionField;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            
            try{
                Statement stmt = con.createStatement();
                //String b ="INSERT INTO "+ tableName+" VALUES("+Integer.toString(sno)+",3,"+"'"+ questionField.getText().strip()+"'" +","+ "null" +"," + "null" +"," + "null" +","+ "null" +"," + "'"+ answerField.getText().strip()+"'" +"," + "null" +","+"null," +"null," +"null"+");";
                String a ="INSERT INTO "+ tableName+" VALUES("+Integer.toString(sno)+",1,"+"'"+ questionField.getText().strip()+"'" +","+"'"+ op1.getText().strip()+"'"+","+"'" + op2.getText().strip() +"'"+","+"'" + op3.getText().strip() +"'"+","+"'"+ op4.getText().strip() +"'"+","+"'" + cop.getText().strip() +"'"+","+"'" + marksField.getText().strip() +"'"+","+"null," +"null," +"null"+");";
                System.out.println(a);
                stmt.executeUpdate(a);
                
                finalPage ob = new finalPage();
                ob.finalPageFrame(con,tableName,sno,sno);
                singleChoice.dispose();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
}


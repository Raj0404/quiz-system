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
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.sql.*;

/**
 *
 * @author rajdi
 */
public class multiChoiceFrame {
    int y = 430,i=1;

   public void multiChoicePage(Connection con,String tableName,int sno) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame singleChoice = new JFrame();
        singleChoice.setTitle("Multi choice");
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
        
        
        JTextField op2 = new JTextField(null);
        JTextField op3 = new JTextField(null);
        JTextField op4 = new JTextField(null);
   
        
        
        JCheckBox cop1 = new JCheckBox("");
        JCheckBox cop2 = new JCheckBox("");
        JCheckBox cop3 = new JCheckBox("");
        JCheckBox cop4 = new JCheckBox("");
        
        error.setVisible(false);
        
        
        question.setBounds(20, 20, 100, 20);
        questionField.setBounds(20, 40, 1480, 300);
        
        next.setBounds(20,720,100,30);
        finish.setBounds(120,720,100,30);
        marks.setBounds(500,350,100,30);
        marksField.setBounds(500,390,20,30);
        op1.setBounds(50,390,100,30);
        op2.setBounds(50,430,100,30);
        op3.setBounds(50,470,100,30);
        op4.setBounds(50,510,100,30);
        cop1.setBounds(20,390,20,30);
        cop2.setBounds(20,430,20,30);
        cop3.setBounds(20,470,20,30);
        cop4.setBounds(20,510,20,30);
        
        
        
  
        
        
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
        singleChoice.add(cop1);
        singleChoice.add(cop2);
        singleChoice.add(cop3);
        singleChoice.add(cop4);

      
        int newSNO = sno+1;
        
         finish.addActionListener(new ActionListenerImp2(con, tableName, sno, op1, op2, op3, op4, cop1,cop2,cop3,cop4, marksField, singleChoice,newSNO,questionField)
        );
        
        
        next.addActionListener(new ActionListenerImpl(con, tableName, sno, op1, op2, op3, op4, cop1,cop2,cop3,cop4, marksField, singleChoice,newSNO,questionField)
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
        private final JCheckBox cop1;
        private final JCheckBox cop2;
        private final JCheckBox cop3;
        private final JCheckBox cop4;
        private final JTextField marksField;
        private final JFrame singleChoice;
        private final int newSNO;
        private final JTextArea questionField;

        public ActionListenerImpl(Connection con, String tableName, int sno, JTextField op1, JTextField op2, JTextField op3, JTextField op4, JCheckBox cop1,JCheckBox cop2,JCheckBox cop3,JCheckBox cop4, JTextField marksField, JFrame singleChoice,int newSNO,JTextArea questionField) {
            this.con = con;
            this.tableName = tableName;
            this.sno = sno;
            this.op1 = op1;
            this.op2 = op2;
            this.op3 = op3;
            this.op4 = op4;
            this.cop1 = cop1;
            this.cop2 = cop2;
            this.cop3 = cop3;
            this.cop4 = cop4;
            this.marksField = marksField;
            this.singleChoice = singleChoice;
            this.newSNO=newSNO;
            this.questionField = questionField;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            
            try{
               
                Statement stmt = con.createStatement();
                String a ="INSERT INTO "+ tableName+" VALUES("+Integer.toString(sno)+",2,"+"'"+ questionField.getText().strip()+"'" +","+"'"+ op1.getText().strip()+"'"+","+"'" + op2.getText().strip() +"'"+","+"'" + op3.getText().strip() +"'"+","+"'"+ op4.getText().strip() +"'"+"," + "null"+","+ marksField.getText().strip() +","+"null," +"null," +"null"+");";
                System.out.println(a); 
                stmt.executeUpdate(a);
                
                  if(!cop1.isSelected()){
                    op1.setText("null");
                }
                  if(!cop2.isSelected()){
                    op2.setText("null");
                }
                  if(!cop3.isSelected()){
                    op3.setText("null");
                }
                  if(!cop4.isSelected()){
                    op4.setText("null");
                }
                   a ="UPDATE "+ tableName+ " SET cop="+"'"+op1.getText().strip()+"'"+",cop2="+"'"+op2.getText().strip()+"'"+",cop3="+"'"+op3.getText().strip()+"'"+",cop4="+"'"+op4.getText().strip()+"'"+" WHERE sno="+Integer.toString(sno)+";";
                  System.out.println(a);
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
        private final JCheckBox cop;
        private final JCheckBox cop2;
        private final JCheckBox cop3;
        private final JCheckBox cop4;
        private final JTextField marksField;
        private final JFrame singleChoice;
        private final int newSNO;
        private final JTextArea questionField;

        public ActionListenerImp2(Connection con, String tableName, int sno, JTextField op1, JTextField op2, JTextField op3, JTextField op4, JCheckBox cop,JCheckBox cop2,JCheckBox cop3,JCheckBox cop4, JTextField marksField, JFrame singleChoice,int newSNO,JTextArea questionField) {
            this.con = con;
            this.tableName = tableName;
            this.sno = sno;
            this.op1 = op1;
            this.op2 = op2;
            this.op3 = op3;
            this.op4 = op4;
            this.cop = cop;
            this.cop2 = cop2;
            this.cop3 = cop3;
            this.cop4 = cop4;
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
                String a ="INSERT INTO "+ tableName+" VALUES("+Integer.toString(sno)+",2,"+"'"+ questionField.getText().strip()+"'" +","+"'"+ op1.getText().strip()+"'"+","+"'" + op2.getText().strip() +"'"+","+"'" + op3.getText().strip() +"'"+","+"'"+ op4.getText().strip() +"'"+"," + null +"," + marksField.getText().strip() +","+"null," +"null," +"null"+");";
                System.out.println(a);
                stmt.executeUpdate(a);
                
                 if(!cop.isSelected()){
                    op1.setText("null");
                }
                  if(!cop2.isSelected()){
                    op2.setText("null");
                }
                  if(!cop3.isSelected()){
                    op3.setText("null");
                }
                  if(!cop4.isSelected()){
                    op4.setText("null");
                }
                   a ="UPDATE "+ tableName+ " SET cop="+"'"+op1.getText().strip()+"'"+",cop2="+"'"+op2.getText().strip()+"'"+",cop3="+"'"+op3.getText().strip()+"'"+",cop4="+"'"+op4.getText().strip()+"'"+" WHERE sno="+Integer.toString(sno)+";";
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


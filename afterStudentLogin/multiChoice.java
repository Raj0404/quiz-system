
package afterStudentLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import quizAttemptBuffer.*;
import java.util.Calendar;
import java.lang.*;

public class multiChoice extends bufferClass {
    
    
    public int k ;
    public int H ;
    public int M ;
    public int S ;
    public JLabel l = new JLabel();
    Timer ti ;
   
    public void sc(String QName, String op1, String op2, String op3, String op4,String cop,String cop2,String cop3,String cop4,int sno,int cMarks,int marks,int corr,String table,int hour,int minute,int second,Calendar startInstance){
        int sno1=sno+1;
        
       
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame singleChoice = new JFrame();
        singleChoice.setTitle("Quizzy");
        singleChoice.setVisible(true);
        singleChoice.setLayout(null);
        singleChoice.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        
        
        JLabel question = new JLabel("Question "+ Integer.toString(sno));
        JButton addOption = new JButton("Next");
        JLabel questionField = new JLabel(QName);
        JCheckBox choice1 = new JCheckBox(op1);
        JCheckBox choice2 = new JCheckBox(op2);
        JCheckBox choice3 = new JCheckBox(op3);
        JCheckBox choice4 = new JCheckBox(op4);
        JButton show = new JButton("Show Answer");
        
        
        question.setBounds(40, 20, 400, 50);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        question.setForeground(Color.BLACK);
        //question.setHorizontalAlignment(100);
        questionField.setBounds(40, 60, 1480, 50);
        questionField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        questionField.setForeground(Color.BLACK);
        
        
        choice1.setBounds(40,120,800,50);
        choice1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        choice1.setForeground(Color.BLACK);
        
        
        choice2.setBounds(40,160,800,50);
         choice2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        choice2.setForeground(Color.BLACK);
        choice3.setBounds(40,200,800,50);
         choice3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        choice3.setForeground(Color.BLACK);
        
        choice4.setBounds(40,240,800,50);
         choice4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        choice4.setForeground(Color.BLACK);
        
        
        addOption.setBounds(40, 300, 300, 50);
        addOption.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        addOption.setForeground(Color.BLACK);
        
        
        show.setBounds(360,300,300,50);
        show.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        show.setForeground(Color.BLACK);
        
        
        
        
        //questionField.setLineWrap(true);
        
        
        singleChoice.add(question);
        singleChoice.add(addOption);
        singleChoice.add(questionField);
        singleChoice.add(choice1);
        singleChoice.add(choice2);
        singleChoice.add(choice3);
        singleChoice.add(choice4);
        singleChoice.add(show);
        
        
        JLabel l = new JLabel();
        l.setBounds(900, 700, 500, 40);
        l.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        singleChoice.add(l);
        
         singleChoice o = new singleChoice();
         
         Calendar now = Calendar.getInstance();
          System.out.println(now);
         System.out.println(startInstance);
         int nowHour=now.get(Calendar.HOUR);
         int nowMin=now.get(Calendar.MINUTE);
         int nowSec=now.get(Calendar.SECOND);
         
         
         int thenHour=startInstance.get(Calendar.HOUR);
         int thenMin=startInstance.get(Calendar.MINUTE);
         int thenSec=startInstance.get(Calendar.SECOND);
         
         if(nowSec < thenSec){
             nowSec=60;
             nowMin--;
         }
         if(nowMin < thenMin){
             nowMin=60;
             nowHour--;
         }
         
         
         int diffHour = nowHour - thenHour;
         int diffMin= nowMin - thenMin;
         int diffSec= nowSec - thenSec;
         
        /* if(diffHour<0){
             diffHour= diffHour-(2*diffHour);
         }
         if(diffMin<0){
             diffMin= diffMin-(2*diffMin);
         }
         if(diffSec<0){
             diffSec= diffSec-(2*diffSec);
         }*/
        
        if(hour>diffHour){
            o.H=hour-diffHour;
        }
        else{
            o.H=diffHour-hour;
        }
        
        if(minute>diffMin){
            o.M=minute-diffMin;
        }
        else{
            o.M=diffMin-minute;
        }
        
        if(second>diffSec){
            o.S=second-diffSec;
        }
        else{
            o.S=diffSec-second;
        }
         
         
        this.ti = new Timer(1000,new ActionListener(){
           
            public void actionPerformed(ActionEvent ae){
                
                l.setText(Integer.toString(o.H)+":"+Integer.toString(o.M)+":"+Integer.toString(o.S));
                singleChoice.revalidate();
                
                if(o.H == 0 &&o.M == 0 &&o.S == 0 ){
                    ti.stop();
                    System.exit(0);
                }
                if(o.S!=0){
                    o.S--;
                }else{
                    o.M--;
                    o.S=59;
                }
                 if(o.M==0 && o.S==0 &&o.H!=0){
                    o.H--;
                    o.M=59;
                }
            }
        });
        
        
        
        calculatedMarks=cMarks;
        correct = corr;
        
        
        addOption.addActionListener(new ActionListenerImpl(choice1, cop,cop2,cop3,cop4, marks, choice2, choice3, choice4, sno1, singleChoice,table,o.H,o.M,o.S,startInstance));
        show.addActionListener(new ActionListenerImp2(choice1, cop,cop2,cop3,cop4, marks, choice2, choice3, choice4, sno1, singleChoice,table,o.H,o.M,o.S,startInstance));
        
        
        
        
        
        
        device.setFullScreenWindow(singleChoice);
    }

    private class ActionListenerImpl implements ActionListener {

        private final JCheckBox choice1;
        private final String cop;
        private final String cop2;
        private final String cop3;
        private final String cop4;
        private final String table;
        private final int marks;
        private final JCheckBox choice2;
        private final JCheckBox choice3;
        private final JCheckBox choice4;
        private final int sno1;
         private final int hour;
        private final int min;
        private final int sec;
        private final Calendar startInstance;
        private final JFrame singleChoice;

        public ActionListenerImpl(JCheckBox choice1, String cop,String cop2,String cop3,String cop4, int marks, JCheckBox choice2, JCheckBox choice3, JCheckBox choice4, int sno1, JFrame singleChoice,String table,int hour,int min,int sec,Calendar startInstance) {
            this.choice1 = choice1;
            this.cop = cop;
            this.cop2 = cop2;
            this.cop3 = cop3;
            this.cop4 = cop4;
            this.table = table;
            this.marks = marks;
            this.choice2 = choice2;
            this.choice3 = choice3;
            this.choice4 = choice4;
            this.sno1 = sno1;
            this.hour = hour;
            this.min = min;
            this.sec = sec;
            this.singleChoice = singleChoice;
            this.startInstance = startInstance;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(choice1.isSelected() && (choice1.getText().strip().equals(cop.strip()) || choice1.getText().strip().equals(cop2.strip())||choice1.getText().strip().equals(cop3.strip())||choice1.getText().strip().equals(cop4.strip())) ){
                calculatedMarks += marks;
                correct++;
            }
             if(choice2.isSelected() && (choice2.getText().strip().equals(cop.strip()) || choice2.getText().strip().equals(cop2.strip())||choice2.getText().strip().equals(cop3.strip())||choice2.getText().strip().equals(cop4.strip())) ){
                calculatedMarks += marks;
                correct++;
            }
             if(choice3.isSelected() && (choice3.getText().strip().equals(cop.strip()) || choice3.getText().strip().equals(cop2.strip())||choice3.getText().strip().equals(cop3.strip())||choice3.getText().strip().equals(cop4.strip())) ){
                calculatedMarks += marks;
                correct++;
            }
             if(choice4.isSelected() && (choice4.getText().strip().equals(cop.strip()) || choice4.getText().strip().equals(cop2.strip())||choice4.getText().strip().equals(cop3.strip())||choice4.getText().strip().equals(cop4.strip())) ){
                calculatedMarks += marks;
                correct++;
            }
            else{
                System.out.println("Error");
            }
            
            
            
            
            bufferClass ob = new bufferClass();
            ob.call(sno1,calculatedMarks,correct,table,hour,min,sec,startInstance);
            singleChoice.dispose();
            
            
        }
    }
}


class ActionListenerImp2 implements ActionListener {

        private final JCheckBox choice1;
        private final String cop;
        private final String cop2;
        private final String cop3;
        private final String cop4;
        private final String table;
        private final int marks;
        private final JCheckBox choice2;
        private final JCheckBox choice3;
        private final JCheckBox choice4;
        private final int sno1;
         private final int hour;
        private final int min;
        private final int sec;
        private final Calendar startInstance;
        private final JFrame singleChoice;

        public ActionListenerImp2(JCheckBox choice1, String cop,String cop2,String cop3,String cop4, int marks, JCheckBox choice2, JCheckBox choice3, JCheckBox choice4, int sno1, JFrame singleChoice,String table,int hour,int min,int sec,Calendar startInstance) {
            this.choice1 = choice1;
            this.cop = cop;
            this.cop2 = cop2;
            this.cop3 = cop3;
            this.cop4 = cop4;
            this.table = table;
            this.marks = marks;
            this.choice2 = choice2;
            this.choice3 = choice3;
            this.choice4 = choice4;
            this.sno1 = sno1;
            this.hour = hour;
            this.min = min;
            this.sec = sec;
            this.singleChoice = singleChoice;
            this.startInstance = startInstance;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            
        
            
            
            
            choice1.setForeground(Color.RED);
                choice2.setForeground(Color.RED);
                choice3.setForeground(Color.RED);
                choice4.setForeground(Color.RED);
                
            if( (choice1.getText().strip().equals(cop.strip()) || choice1.getText().strip().equals(cop2.strip())||choice1.getText().strip().equals(cop3.strip())||choice1.getText().strip().equals(cop4.strip())) ){
                choice1.setForeground(Color.GREEN);
            }
             if((choice2.getText().strip().equals(cop.strip()) || choice2.getText().strip().equals(cop2.strip())||choice2.getText().strip().equals(cop3.strip())||choice2.getText().strip().equals(cop4.strip())) ){
               choice2.setForeground(Color.GREEN);
            }
             if((choice3.getText().strip().equals(cop.strip()) || choice3.getText().strip().equals(cop2.strip())||choice3.getText().strip().equals(cop3.strip())||choice3.getText().strip().equals(cop4.strip())) ){
                choice3.setForeground(Color.GREEN);
            }
             if((choice4.getText().strip().equals(cop.strip()) || choice4.getText().strip().equals(cop2.strip())||choice4.getText().strip().equals(cop3.strip())||choice4.getText().strip().equals(cop4.strip())) ){
                choice4.setForeground(Color.GREEN);
            }
            else{
                System.out.println("Error");
            }
            
            
            
            
            
            
            
        }
    }







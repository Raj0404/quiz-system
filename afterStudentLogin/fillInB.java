
package afterStudentLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import quizAttemptBuffer.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.Timer;
import javax.swing.WindowConstants;



public class fillInB extends bufferClass{
        
    Timer ti;
    int H;
    int M;
    int S;
    
    public void fib(int sno,String QName,String cop, int cMarks,int mark,int corr, String table,int hour,int minute,int second,Calendar startInstance){
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame FIB = new JFrame();
        FIB.setTitle("Quizzy");
        FIB.setVisible(true);
        FIB.setLayout(null);
        FIB.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        String s = Integer.toString(sno);
        
        int sno1=sno+1;
        
        
        JLabel question = new JLabel("Question "+s);
        question.setBounds(40, 20, 500, 40);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        JLabel questionField = new JLabel(QName);
        questionField.setBounds(40, 50, 1480, 40);
        questionField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        JLabel answer = new JLabel("Enter the answer: ");
        answer.setBounds(40,110,380,30);
        answer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        JTextField answerField = new JTextField("");
        answerField.setBounds(40,150,180,30);
        answerField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        JButton next = new JButton("Next");
        next.setBounds(20,270,100,50);
        next.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        JLabel invalid = new JLabel("Please Enter an answer");
        invalid.setBounds(130,360,100,20);
        invalid.setVisible(false);
        invalid.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        
        
        
        
        JButton show = new JButton("Show Answer");
        
        show.setBounds(140,270,100,50);
        show.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        show.setForeground(Color.BLACK);
        
        
        calculatedMarks=cMarks;
        correct = corr;
        
        
        JLabel l = new JLabel();
        l.setBounds(900, 700, 500, 40);
        l.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        FIB.add(l);
        
         fillInB o = new fillInB();
         
         Calendar now = Calendar.getInstance();
          System.out.println(now);
         System.out.println("Start Instance FRom selectQuiz"+startInstance);
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
                FIB.revalidate();
                
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
        
        
        
        
        
        
        next.addActionListener(new ActionListenerImpl(answerField, invalid, cop, mark, sno1, FIB,table,o.H,o.M,o.S,startInstance));
        show.addActionListener(new ActionListenerImp2(answerField, invalid, cop, mark, sno1, FIB,table,o.H,o.M,o.S,startInstance));

        FIB.add(answerField);
        FIB.add(answer);
        FIB.add(questionField);
        FIB.add(question);
        FIB.add(next);
        FIB.add(l);
        FIB.add(show);
        device.setFullScreenWindow(FIB);
    }

    private class ActionListenerImpl implements ActionListener {

        private final JTextField answerField;
        private final JLabel invalid;
        private final String cop;
        private final String table;
        private final int mark;
        private final int sno1;
        private final int hour;
        private final int min;
        private final int sec;
        private final JFrame FIB;
        private final Calendar startInstance;

        public ActionListenerImpl(JTextField answerField, JLabel invalid, String cop, int mark, int sno1, JFrame FIB,String table,int hour,int min,int sec,Calendar startInstance) {
            this.answerField = answerField;
            this.invalid = invalid;
            this.cop = cop;
            this.mark = mark;
            this.sno1 = sno1;
            this.FIB = FIB;
            this.hour = hour;
            this.min = min;
            this.sec = sec;
            this.table = table;
            this.startInstance = startInstance;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if("".equals(answerField.getText())){
                invalid.setVisible(true);
            }
            else{
                if(cop.strip().equals(answerField.getText().strip())){
                    calculatedMarks+=mark;
                    correct++;
                }
            }
            bufferClass ob = new bufferClass();
            ob.call(sno1,calculatedMarks,correct,table,hour,min,sec,startInstance);
            FIB.dispose();
        }
    }
    
    
    
    private class ActionListenerImp2 implements ActionListener {

        private final JTextField answerField;
        private final JLabel invalid;
        private final String cop;
        private final String table;
        private final int mark;
        private final int sno1;
        private final int hour;
        private final int min;
        private final int sec;
        private final JFrame FIB;
        private final Calendar startInstance;

        public ActionListenerImp2(JTextField answerField, JLabel invalid, String cop, int mark, int sno1, JFrame FIB,String table,int hour,int min,int sec,Calendar startInstance) {
            this.answerField = answerField;
            this.invalid = invalid;
            this.cop = cop;
            this.mark = mark;
            this.sno1 = sno1;
            this.FIB = FIB;
            this.hour = hour;
            this.min = min;
            this.sec = sec;
            this.table = table;
            this.startInstance = startInstance;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            JLabel ans = new JLabel(cop);
            ans.setBounds(40,350,200,40);
            ans.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            ans.setForeground(Color.GREEN);
            FIB.add(ans);
            answerField.setEditable(false);
            FIB.repaint();
            }
            
        }
    }


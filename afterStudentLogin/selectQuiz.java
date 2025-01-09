/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package afterStudentLogin;


import javax.swing.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import quizAttemptBuffer.*;
import DBConnect.*;
import java.awt.Font;
import java.util.Calendar;



public class selectQuiz {
    public void chooseQuiz(){
        try{
            Integer maxQuizzes;
            Integer publish[] = new Integer[5];
            Integer hour[] = new Integer[5];
            Integer minute[] = new Integer[5];
            Integer second[] = new Integer[5];
            String name[] = new String[5];
            
            
            databaseConnect ob = new databaseConnect();
            Connection con = ob.dbc();
            Statement stmt = con.createStatement();
            String s = "SELECT MAX(sno) FROM quizzes;";
            
            ResultSet r1 = stmt.executeQuery(s);
            r1.next();
            maxQuizzes = r1.getInt("max(sno)");
            r1.close();
                    
            
            
            s = "SELECT * FROM quizzes;";
            r1 = stmt.executeQuery(s);
            r1.next();
            for(int i=0;i<5;i++){
                name[i] = r1.getString("tablename");
                publish[i] = r1.getInt("published");
                hour[i] = r1.getInt("hour");
                minute[i] = r1.getInt("minute");
                second[i] = r1.getInt("second");
                if(!r1.next()){
                    break;
                }
            }
            
            
            
            System.out.println(name[4]);
            
            
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame quizOptions = new JFrame();
        quizOptions.setTitle("Quizzy");
        quizOptions.setVisible(true);
        quizOptions.setLayout(null);
        quizOptions.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
        
        
        
        
        JLabel label1 = new JLabel(name[0]);
        JLabel label2 = new JLabel(name[1]);
        JLabel label3 = new JLabel(name[2]);
        JLabel label4 = new JLabel(name[3]);
        JLabel label5 = new JLabel(name[4]);
        
        label1.setBounds(120, 140, 400, 50);
        label2.setBounds(120, 200, 400, 50);
        label3.setBounds(120, 260, 400, 50);
        label4.setBounds(120, 320, 400, 50);
        label5.setBounds(120, 380, 400, 50);
        
        
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        JLabel timeLabel1 = new JLabel(Integer.toString(hour[0])+":"+Integer.toString(minute[0])+":"+Integer.toString(second[0]));
        JLabel timeLabel2 = new JLabel(Integer.toString(hour[1])+":"+Integer.toString(minute[1])+":"+Integer.toString(second[1]));
        JLabel timeLabel3 = new JLabel(Integer.toString(hour[2])+":"+Integer.toString(minute[2])+":"+Integer.toString(second[2]));
        JLabel timeLabel4 = new JLabel(Integer.toString(hour[3])+":"+Integer.toString(minute[3])+":"+Integer.toString(second[3]));
        JLabel timeLabel5 = new JLabel(Integer.toString(hour[4])+":"+Integer.toString(minute[4])+":"+Integer.toString(second[4]));
        
      
        timeLabel1.setBounds(540, 140, 400, 50);
        timeLabel2.setBounds(540, 200, 400, 50);
        timeLabel3.setBounds(540, 260, 400, 50);
        timeLabel4.setBounds(540, 320, 400, 50);
        timeLabel5.setBounds(540, 380, 400, 50);
        
        
        
        timeLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        timeLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        timeLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        timeLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        timeLabel5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        
        
        
        
        JButton start1 = new JButton();
        JButton start2 = new JButton();
        JButton start3 = new JButton();
        JButton start4 = new JButton();
        JButton start5 = new JButton();
        
        
        start1.setBounds(960, 140, 400, 50);
        start2.setBounds(960, 200, 400, 50);
        start3.setBounds(960, 260, 400, 50);
        start4.setBounds(960, 320, 400, 50);
        start5.setBounds(960, 380, 400, 50);
        
        
        
        
        start1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        start2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        start3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        start4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        start5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        
        
        if(publish[0] == 1){
            start1.setText("Start");
        }
        else{
            start1.setText("Inactive");
        }
        
        
        if(publish[1] == 1){
            start2.setText("Start");
        }
        else{
            start2.setText("Inactive");
        }
        
        
        if(publish[2] == 1){
            start3.setText("Start");
        }
        else{
            start3.setText("Inactive");
        }
        
        
        if(publish[3] == 1){
            start4.setText("Start");
        }
        else{
            start4.setText("Inactive");
        }
        
        
        if(publish[4] == 1){
            start5.setText("Start");
        }
        else{
            start5.setText("Inactive");
        }
        
        
        
        
        
        start1.addActionListener(new ActionListenerImpl(quizOptions,name[0],publish[0],hour[0],minute[0],second[0]));
        
        start2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   if(publish[1] == 1){
                       Calendar startInstance = Calendar.getInstance();
                        bufferClass ob = new bufferClass();
                        ob.call(1,0,0,name[1],hour[1],minute[1],second[1],startInstance);
                        quizOptions.dispose();
                   }
                }
        });
        
        
           start3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   if(publish[2] == 1){
                       Calendar startInstance = Calendar.getInstance();
                        bufferClass ob = new bufferClass();
                        ob.call(1,0,0,name[2],hour[2],minute[2],second[2],startInstance);
                        quizOptions.dispose();
                   }
                }
        });
           
            start4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(publish[3] == 1){
                        Calendar startInstance = Calendar.getInstance();
                        bufferClass ob = new bufferClass();
                        ob.call(1,0,0,name[3],hour[3],minute[3],second[3],startInstance);
                        quizOptions.dispose();
                    }
                }
        });
              
              
            start5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   if(publish[4] == 1){
                       Calendar startInstance = Calendar.getInstance();
                       System.out.println("Start Instance FRom selectQuiz"+startInstance);
                        bufferClass ob = new bufferClass();
                        ob.call(1,0,0,name[4],hour[4],minute[4],second[4],startInstance);
                        quizOptions.dispose();
                   }
                }
        });
        
        quizOptions.add(label1);
        quizOptions.add(label2);
        quizOptions.add(label3);
        quizOptions.add(label4);
        quizOptions.add(label5);
        quizOptions.add(start1);
        quizOptions.add(start2);
        quizOptions.add(start3);
        quizOptions.add(start4);
        quizOptions.add(start5);
        quizOptions.add(timeLabel1);
        quizOptions.add(timeLabel2);
        quizOptions.add(timeLabel3);
        quizOptions.add(timeLabel4);
        quizOptions.add(timeLabel5);
        
        
        
        device.setFullScreenWindow(quizOptions);
        }catch(Exception e){
            System.out.println(e);
        }
    } 

    private static class ActionListenerImpl implements ActionListener {

        private final JFrame quizOptions;
        private final String name;
        private final int publish;
        private final int hour;
        private final int minute;
        private final int second;
        //private final Calendar startInstance;

        public ActionListenerImpl(JFrame quizOptions,String name,int publish,int hour,int minute,int second) {
            this.quizOptions = quizOptions;
            this.name = name;
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            this.publish = publish;
           // this.startInstance = startInstance;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(publish == 1){
                Calendar startInstance = Calendar.getInstance();
                bufferClass ob = new bufferClass();
                ob.call(1,0,0,name,hour,minute,second,startInstance);
                quizOptions.dispose();
            }
            
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package afterStudentLogin;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.WindowConstants;

/**
 *
 * @author rajdi
 */
public class studentFinal {
    
    public void StudentFinalPage(int total,int marks,int corr){
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame frame_page1 = new JFrame();
        frame_page1.setTitle("Quizzy");
        frame_page1.setVisible(true);
        frame_page1.setLayout(null);
        //frame_page1.setSize(1500, 800);
        frame_page1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Times New Roman", Font.PLAIN, 30);
        
        JLabel heading = new JLabel("Performance");
        JLabel totalQuestions = new JLabel("Total Questions: "+ Integer.toString(total));
        //JLabel attempted = new JLabel();
        JLabel correct = new JLabel("Correct: " + Integer.toString(corr));
        JLabel incorrect = new JLabel("Incorrect: " + Integer.toString(total-corr));
        JLabel timeTaken = new JLabel("Time taken: 0 hour 10 min 13 sec");
        JButton finish = new JButton("Finish");
        timeTaken.setVisible(false);
        
        
        
        
        heading.setBounds(600,20,400,40);
        totalQuestions.setBounds(600,70,400,40);
        //attempted.setBounds(40,110,40,400);
        correct.setBounds(600,160,400,40);
        incorrect.setBounds(600,210,400,40);
        timeTaken.setBounds(600,260,400,40);
        finish.setBounds(600,310,400,40);
        
        
        heading.setFont(f);
        totalQuestions.setFont(f);
        correct.setFont(f);
        incorrect.setFont(f);
        timeTaken.setFont(f);
        finish.setFont(f);
        
        
        finish.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                System.exit(0);
            }
        });
        
        
        
        
        frame_page1.add(heading);
        frame_page1.add(totalQuestions);
        //frame_page1.add(attempted);
        frame_page1.add(correct);
        frame_page1.add(incorrect);
        frame_page1.add(timeTaken);
        frame_page1.add(finish);
        
        
        
        
        
        
        
        
        
        
        
        device.setFullScreenWindow(frame_page1);
    }
    
}

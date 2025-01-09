/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facultyLogin;

import afterStudentLogin.selectQuiz;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 *
 * @author rajdi
 */
public class facultyLoginPage {
    void facultyLogin(){
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame frame_StudentLogin = new JFrame();
        frame_StudentLogin.setTitle("Teacher Login");
        frame_StudentLogin.setVisible(true);
        frame_StudentLogin.setLayout(null);
        //frame_StudentLogin.setSize(1500, 800);
        frame_StudentLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel background=new JLabel(new ImageIcon("Give absolute path to some image stored locally"));
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

        StudentLoginSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
               
             
        });

        
        frame_StudentLogin.add(StudentUserName);
        frame_StudentLogin.add(StudentPassWord);
        frame_StudentLogin.add(StudentUserName_Enter);
        frame_StudentLogin.add(StudentPassWord_Enter);
        frame_StudentLogin.add(StudentLoginSubmit);
        frame_StudentLogin.add(background);
        device.setFullScreenWindow(frame_StudentLogin);
    }

}
    

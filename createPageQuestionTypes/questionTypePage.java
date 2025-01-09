/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package createPageQuestionTypes;

import createPageChoices.FillInBlankFrame;
import createPageChoices.singleChoiceFrame;
import createPageChoices.multiChoiceFrame;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.WindowConstants;

/**
 *
 * @author rajdi
 */
public class questionTypePage {
    public void questionTypPage(Connection con,String testName,int sno) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame questionTypFrame = new JFrame();
        questionTypFrame.setTitle("Quizzy");
        questionTypFrame.setVisible(true);
        questionTypFrame.setLayout(null);
        questionTypFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Times New Roman", Font.PLAIN, 30);

        JLabel enterQType = new JLabel("Select the type of question");
        JRadioButton singleChoice = new JRadioButton("Single Option Correct");
        JRadioButton multipleChoice = new JRadioButton("Multiple Option Correct");
        JRadioButton FillInTheBlank = new JRadioButton("Fill in the blank");
        JRadioButton Descriptive = new JRadioButton("Descriptive");
        JButton next = new JButton("Next");
        enterQType.setBounds(640, 20, 400, 30);
        singleChoice.setBounds(640, 60, 400, 30);
        multipleChoice.setBounds(640, 90, 400, 30);
        FillInTheBlank.setBounds(640, 120, 400, 30);
        Descriptive.setBounds(40, 110, 200, 20);
        Descriptive.setVisible(false);
        next.setBounds(640, 150, 100, 50);
        
        
        
        enterQType.setFont(f);
        singleChoice.setFont(f);
        multipleChoice.setFont(f);
        FillInTheBlank.setFont(f);
        next.setFont(f);
      

       
        
        
        
        
        next.addActionListener(new ActionListenerImpl(con,testName,sno,singleChoice, questionTypFrame, multipleChoice, FillInTheBlank, Descriptive));
        
        
        questionTypFrame.add(enterQType);
        questionTypFrame.add(singleChoice);
        questionTypFrame.add(multipleChoice);
        questionTypFrame.add(FillInTheBlank);
        questionTypFrame.add(Descriptive);
        questionTypFrame.add(next);
        device.setFullScreenWindow(questionTypFrame);
    }

    private static class ActionListenerImpl implements ActionListener {

        private final JRadioButton singleChoice;
        private final JFrame questionTypFrame;
        private final JRadioButton multipleChoice;
        private final JRadioButton FillInTheBlank;
        private final JRadioButton Descriptive;
        private final Connection con;
        private final String testName;
        private final int sno;

        public ActionListenerImpl(Connection con,String testName,int sno,JRadioButton singleChoice, JFrame questionTypFrame, JRadioButton multipleChoice, JRadioButton FillInTheBlank, JRadioButton Descriptive) {
            this.singleChoice = singleChoice;
            this.questionTypFrame = questionTypFrame;
            this.multipleChoice = multipleChoice;
            this.FillInTheBlank = FillInTheBlank;
            this.Descriptive = Descriptive;
            this.con = con;
            this.testName = testName;
            this.sno = sno;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(singleChoice.isSelected()){
                singleChoiceFrame ob = new singleChoiceFrame();
                questionTypFrame.dispose();
                ob.singleChoicePage(con,testName,sno);
                
            }
            if(multipleChoice.isSelected()){
                multiChoiceFrame ob = new multiChoiceFrame();
                ob.multiChoicePage(con, testName, sno);
                questionTypFrame.dispose();
            }
            if (FillInTheBlank.isSelected()) {
                FillInBlankFrame ob = new FillInBlankFrame();
                questionTypFrame.dispose();
                ob.FillInBlankPage(con,testName,sno);
            }
            if (Descriptive.isSelected()) {
                questionTypFrame.dispose();
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import controllers.ProgramTesterCntl;
import programtester.models.ProgramTesterViewModel;

/**
 *
 * @author Shawn
 */

public class ProgramTesterUI extends JFrame{
    
    ProgramTesterCntl theProgramTesterCntl;

  
    
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    
     public ProgramTesterUI(ProgramTesterCntl parentProgramTesterCntl){
        theProgramTesterCntl = parentProgramTesterCntl;
        //initComponents(parentProgramTesterCntl.getCurrentViewModel());
        
         setTitle("Program Tester");
         setSize(600, 400);
         setBackground(Color.gray);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        JPanel topPanel = new JPanel();
        topPanel.setLayout (new BorderLayout());
        getContentPane().add(topPanel);
         
         setFiles();
         //createTab2();
         Runs();
         scnrAndCmdInputs();
         output();
         
        
         tabbedPane = new JTabbedPane();
         tabbedPane.addTab("Set Files", panel1);
         //tabbedPane.addTab("Tab 2", panel2);
         tabbedPane.addTab("Runs", panel3);
         tabbedPane.addTab("Scanner and CMD Inputs", panel4);
         tabbedPane.addTab("Output", panel5);
         topPanel.add(tabbedPane,BorderLayout.CENTER);
         
     } 
     
     public void setFiles(){
         
         panel1 = new JPanel();
         panel1.setLayout(null);
         
         JFileChooser  field1 = new JFileChooser();
         field1.setBounds(40, 15, 400, 50);
         panel1.add(field1);
         
         JFileChooser fileField2 = new JFileChooser();
         fileField2.setBounds(100, 270, 260, 50);
         panel1.add(fileField2);
         
         JTextField field2 = new JTextField();
         field2.setBounds(100, 240, 400, 30);
         panel1.add(field2);
         
         JLabel label1 = new JLabel();
         label1.setBounds(40, 280, 200, 20);
         label1.setText("Files Type");
         panel1.add(label1);
         
         JLabel label2 = new JLabel();
         label2.setBounds(40, 240, 200, 20);
         label2.setText("File Name");
         panel1.add(label2);
         
         JLabel label3 = new JLabel();
         label3.setBounds(40, 25, 100, 20);
         label3.setText("Look In:");
         panel1.add(label3);
         
         JButton oButton = new JButton();
         oButton.setBounds(360, 300, 75, 25);
         oButton.setText("Open");
         panel1.add(oButton);
         
         JButton cButton = new JButton();
         cButton.setBounds(430 ,300 , 75, 25);
         cButton.setText("Cancel");
         panel1.add(cButton);
         
         JTextArea text1 = new JTextArea();
         text1.setBounds(40, 60, 450, 175);
         text1.setBackground(Color.white);
         panel1.add(text1);
         
         
         
         
     }
                  
         public void Runs(){
             panel3 = new JPanel();
             panel3.setLayout(null);
             
             JTextField jField = new JTextField();
             jField.setBounds(30, 70, 300, 30);
             panel3.add(jField);
             
             JLabel label4 = new JLabel();
             label4.setBounds(30, 40, 100, 30);
             label4.setText("Output");
             panel3.add(label4);
             
             JLabel label5 = new JLabel();
             label5.setBounds(30, 175, 200, 30);
             label5.setText("Number of Runs:");
             panel3.add(label5);
             
             String[] numbers = {"5","4","3","2","1","0"};
             JComboBox box1 = new JComboBox(numbers);
             box1.setSelectedIndex(5);
             box1.setBounds(150, 175, 100, 30);
             panel3.add(box1);
             
             JButton browse = new JButton();
             browse.setBounds(340,70,100,30);
             browse.setText("Browse");
             panel3.add(browse);
             
             JButton nextButton = new JButton();
             nextButton.setBounds(375,300,100,30);
             nextButton.setText("Next");
             panel3.add(nextButton);
             
             JButton backButton = new JButton();
             backButton.setBounds(475, 300, 100, 30);
             backButton.setText("Back");
             panel3.add(backButton);
             
             
             
         }
         
        public void scnrAndCmdInputs(){
            panel4 = new JPanel();
            panel4.setLayout(null);
            
            JLabel factorial = new JLabel();
            factorial.setBounds(30, 30, 100, 20);
            factorial.setText("Factorial");
            panel4.add(factorial);
            
            JLabel cmdArgs = new JLabel();
            cmdArgs.setBounds(100, 125, 150, 20);
            cmdArgs.setText("Command-Line Args: ");
            panel4.add(cmdArgs);
            
            JLabel scnrInput = new JLabel();
            scnrInput.setBounds(100,150,150,20);
            scnrInput.setText("Scanner Input");
            panel4.add(scnrInput);
            
           JTextField textField1 = new JTextField();
           textField1.setBounds(250,125, 200, 20);
           panel4.add(textField1);
           
           JTextField textField2 = new JTextField();
           textField2.setBounds(200,150, 250, 20);
           panel4.add(textField2);
           
           JCheckBox checkBox = new JCheckBox();
           checkBox.setBounds(200, 175, 100, 30);
           checkBox.setText("None");
           panel4.add(checkBox);
           
           JButton button = new JButton();
           button.setBounds(375, 300, 100, 30);
           button.setText("Next");
           panel4.add(button);
           
           JButton button2 = new JButton();
           button2.setBounds(475, 300, 100, 30);
           button2.setText("Back");
           panel4.add(button2);
           
        }
        
        public void output(){
            panel5 = new JPanel();
            panel5.setLayout(null);
            
            JButton backButton = new JButton();
            backButton.setBounds(375, 300, 100, 30);
            backButton.setText("Back");
            panel5.add(backButton);
            
            JButton finishButton = new JButton();
            finishButton.setBounds(475, 300, 100, 30);
            finishButton.setText("Finish");
            panel5.add(finishButton);
            
            
        }

   
    }

   
    

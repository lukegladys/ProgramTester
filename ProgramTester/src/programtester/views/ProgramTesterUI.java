/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import programtester.TrivialEdit;
import programtester.controllers.OutputPathChooserController;
import programtester.controllers.ProgramTesterCntl;
import programtester.models.Run;

public class ProgramTesterUI extends JFrame {

    ProgramTesterCntl theProgramTesterCntl;
    private JPanel mainPanel, navPanel;
    private JLabel introLabel;
    private JButton previousButton, nextButton;
    
    public StepOnePanel stepOnePanel;
    public StepTwoPanel stepTwoPanel;
    public StepThreePanel stepThreePanel;
    public StepFourPanel stepFourPanel;

    // <editor-fold defaultstate="collapsed" desc="Step 4: Specify scanner and cmd inputs">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 5: Specify output folder and output file name. Specify whether student name or student handle should be used in the output file">
    OutputPathChooserController theOutputPathChooserController;

    private JFileChooser chooser;
    private String choosertitle;
    private String outputPath;
    private String outputName;

    private JButton browseButton;
    private JTextField fileLocationTestField;
    private JLabel jLabel1;
    private JTextField outputNameField;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JMenuBar jMenuBar1;
    private JMenu jMenu1;
    private JMenu jMenu2;

    private JRadioButton nameRadioButton;
    private JRadioButton handleRadioButton;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 6: Run and open the output file">
    private JButton runButton;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitMenuItem;
    private JMenu editMenu;
    private JMenuItem cutMenuItem;
    private JMenuItem copyMenuItem;
    private JMenuItem pasteMenuItem;
    private JMenuItem deleteMenuItem;
    // </editor-fold>

    public ProgramTesterUI(ProgramTesterCntl parentProgramTesterCntl) {
        theProgramTesterCntl = parentProgramTesterCntl;

        this.theProgramTesterCntl = parentProgramTesterCntl;
        previousButton = new JButton("Back");
        nextButton = new JButton("Next");
        navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(1, 2));
        navPanel.add(new JLabel());
        navPanel.add(previousButton);
        navPanel.add(nextButton);
        mainPanel = new JPanel();
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(navPanel, BorderLayout.PAGE_END);
        this.renderComponents(0);
        
        stepOnePanel = new StepOnePanel(this.theProgramTesterCntl);
        stepTwoPanel = new StepTwoPanel(this.theProgramTesterCntl);
        //stepThreePanel = new StepThreePanel(this.theProgramTesterCntl);
        //stepFourPanel = new StepFourPanel(this);

        this.setSize(650, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void renderComponents(int stepInWizard) {
        mainPanel.removeAll();

        for (ActionListener a : previousButton.getActionListeners()) {
            previousButton.removeActionListener(a);
        }
        for (ActionListener a : nextButton.getActionListeners()) {
            nextButton.removeActionListener(a);
        }

        switch (stepInWizard) {
            case 0:
                // Remove old elements
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                
                // Set title
                this.setTitle("Program Tester");
                
                // Paint new elements
                mainPanel.setLayout(new GridLayout(1, 1, 60, 60));
                introLabel = new JLabel("   Welcome to the ProgramTester Wizard!  Press Next to continue...");
                mainPanel.add(introLabel);
                mainPanel.revalidate();
                mainPanel.repaint();

                previousButton.setEnabled(false);
                nextButton.addActionListener(new ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(1);
                    }
                });
                break;
            case 1:
                // Remove old elements
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                
                // Set title
                this.setTitle("Choose Files/Folders");
                
                // Paint new elements
                mainPanel.add(this.theProgramTesterCntl.getStepOnePanel());
                mainPanel.revalidate();
                mainPanel.repaint();
                
                // Update button actions
                previousButton.setEnabled(true);
                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(0);
                    }
                });
                
                nextButton.setEnabled(true);
                nextButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(2);
                    }
                });
                break;
            case 2:
                // Remove old elements
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                
                // Set title
                this.setTitle("Set Run Parameters");
                
                // Paint new elements
                mainPanel.add(this.theProgramTesterCntl.getStepTwoPanel());
                mainPanel.revalidate();
                mainPanel.repaint();
                
                previousButton.setEnabled(true);
                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(1);
                    }
                });

                nextButton.setEnabled(true);
                nextButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        boolean validateRunCreation = ProgramTesterUI.this.theProgramTesterCntl.getStepTwoPanel().CreateRuns();
                        if(validateRunCreation) {
                            theProgramTesterCntl.step(3);
                        }
                    }
                });
                break;
            case 3:
                // Remove old elements
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                
                // Set title
                this.setTitle("Set Arguments");
                
                // Create stepThreePanel
                stepThreePanel = new StepThreePanel(this.theProgramTesterCntl);
                
                // Paint new elements
                mainPanel.add(this.theProgramTesterCntl.getStepThreePanel());
                mainPanel.revalidate();
                mainPanel.repaint();
                
                previousButton.setEnabled(true);
                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(2);
                    }
                });

                nextButton.setEnabled(true);
                nextButton.setText("Next");
                nextButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ProgramTesterUI.this.theProgramTesterCntl.getStepThreePanel().DoRuns();
                    }
                });
                break;
            // <editor-fold defaultstate="collapsed" desc="Step 4: Specify scanner and cmd inputs">
            case 4:
                // Remove old elements
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                
                // Set title
                this.setTitle("Set Output Parameters");
                
                // Paint new elements
                mainPanel.setLayout(null);
                
                browseButton = new JButton("Browse");
                browseButton.setBounds(515, 30, 100, 20);
                browseButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        browseButtonActionPerformed(evt);
                    }
                });
                mainPanel.add(browseButton);

                fileLocationTestField = new JTextField();
                fileLocationTestField.setEditable(false);
                fileLocationTestField.setBounds(230, 30, 275, 20);
                fileLocationTestField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        fileLocationTestFieldActionPerformed(evt);
                    }
                });
                mainPanel.add(fileLocationTestField);

                jLabel1 = new JLabel();
                jLabel1.setBounds(30, 30, 180, 20);
                jLabel1.setText("Choose an output folder:");
                mainPanel.add(jLabel1);

                outputNameField = new JTextField();
                outputNameField.setBounds(230, 60, 275, 20);
                outputNameField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        outputNameFieldActionPerformed(evt);
                    }
                });
                mainPanel.add(outputNameField);

                jLabel2 = new JLabel();
                jLabel2.setBounds(30, 60, 180, 20);
                jLabel2.setText("Choose an output file name:");
                mainPanel.add(jLabel2);
                
                jLabel3 = new JLabel();
                jLabel3.setBounds(505, 60, 50, 20);
                jLabel3.setText(".txt");
                mainPanel.add(jLabel3);
                
                previousButton.setEnabled(false);
                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(3);
                    }
                });

                nextButton.setEnabled(true);
                nextButton.setText("Submit");
                nextButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        // Set variables with user input
                        String outputPath = fileLocationTestField.getText();
                        String outputFilename = outputNameField.getText();
                        
                        // Set stdout to file for batch output
                        PrintStream original = new PrintStream(System.out);
                        File outputFile = new File(outputPath + "/" + outputFilename + ".txt");
                        System.out.println(outputFile.getAbsolutePath());
                        if(!outputFile.exists() && !outputFile.isDirectory()) {
                            try {
                                outputFile.createNewFile();
                            } catch (IOException ex) {
                                Logger.getLogger(ProgramTesterUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        try {
                            System.out.println("Outputting to file...please wait.");
                            System.setOut(new PrintStream(outputFile));
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ProgramTesterUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        theProgramTesterCntl.runTests(outputPath, outputFilename);
                        
                        nextButton.setEnabled(false);
                        nextButton.setText("Tests Completed");
                        
                        System.setOut(original);
                        
                        // Display results
                        System.out.println("Tests complete. Displaying results.");
                        TrivialEdit resultsDisplay = new TrivialEdit("output-batch.txt");
                        String [] editArgs = {outputFile.getAbsolutePath()};
                        TrivialEdit.main(editArgs);
                        System.out.println("Results displayed.");

                    }
                });
                break;
            // </editor-fold>
            // <editor-fold defaultstate="collapsed" desc="Step 5: Specify output folder and output file name. Specify whether student name or student handle should be used in the output file">    
            case 5:

                browseButton = new JButton("Browse");
                browseButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        browseButtonActionPerformed(evt);
                    }
                });

                fileLocationTestField = new JTextField();
                fileLocationTestField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        fileLocationTestFieldActionPerformed(evt);
                    }
                });

                jLabel1 = new JLabel();
                jLabel1.setText("Choose an output location:");

                outputNameField = new JTextField();
                outputNameField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        outputNameFieldActionPerformed(evt);
                    }
                });

                jLabel2 = new JLabel();
                jLabel2.setText("Choose an output file name:");

                /*jMenuBar1 = new JMenuBar();

                jMenu1 = new JMenu();
                jMenu1.setText("File");
                jMenuBar1.add(jMenu1);

                jMenu2 = new JMenu();
                jMenu2.setText("Edit");
                jMenuBar1.add(jMenu2);*/

                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(4);
                    }
                });
                
                nextButton.setEnabled(false);
                nextButton.setText("Next");

                //setJMenuBar(jMenuBar1);
                //TODO SET PANEL LAYOUTS HERE*************************************
                break;
            // </editor-fold>
        }

        mainPanel.updateUI();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Step 5 ActionListeners">
    private void fileLocationTestFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileLocationTestFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileLocationTestFieldActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // disable the "All files" option.
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(mainPanel) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            outputPath = chooser.getSelectedFile().toString();
            this.fileLocationTestField.setText(outputPath);

        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void outputNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputNameFieldActionPerformed

    /*
     * When the next button is clicked, the controller takes the output path and
     * the name of the new file and hands it to the controller.
     * The next GUI is then also instantiated. 
     */
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        this.theOutputPathChooserController.setOutputPath(outputPath);
        outputName = outputNameField.getText();
        this.theOutputPathChooserController.setFileName(outputName);
        //this.theOutputPathChooserController.showOutputTitleChooserGUI();
    }//GEN-LAST:event_nextButtonActionPerformed
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 6 ActionListeners">

    // </editor-fold>
}

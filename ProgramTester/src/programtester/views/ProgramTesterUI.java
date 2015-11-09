/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
        stepThreePanel = new StepThreePanel(this.theProgramTesterCntl);
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
                this.setTitle("Program Tester");
                mainPanel.setLayout(new GridLayout(1, 1, 60, 60));
                introLabel = new JLabel("       Welcome to the ProgramTester Wizard!  Press Next to continue...");
                mainPanel.add(introLabel);

                nextButton.addActionListener(new ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(1);
                    }
                });
                break;
            case 1:
                mainPanel = this.theProgramTesterCntl.getStepOnePanel();
                this.setTitle("Choose Files");
                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(1);
                    }
                });

                nextButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(2);
                    }
                });
                break;
            case 2:
                mainPanel = this.theProgramTesterCntl.getStepTwoPanel();
                this.setTitle("Run parameters");
                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(1);
                    }
                });

                nextButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ProgramTesterUI.this.theProgramTesterCntl.getStepTwoPanel().CreateRuns();
                    }
                });
                break;
            case 3:

                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(3);
                    }
                });

                nextButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ProgramTesterUI.this.theProgramTesterCntl.getStepThreePanel().DoRuns();
                        theProgramTesterCntl.step(4);
                    }
                });
                break;
            // <editor-fold defaultstate="collapsed" desc="Step 4: Specify scanner and cmd inputs">
            case 4:

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

                jMenuBar1 = new JMenuBar();

                jMenu1 = new JMenu();
                jMenu1.setText("File");
                jMenuBar1.add(jMenu1);

                jMenu2 = new JMenu();
                jMenu2.setText("Edit");
                jMenuBar1.add(jMenu2);

                previousButton.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theProgramTesterCntl.step(4);
                    }
                });

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

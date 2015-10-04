/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import programtester.controllers.OutputPathChooserController;
import programtester.controllers.ProgramTesterCntl;
import programtester.models.Run;

/**
 *
 * @author Luke
 */
public class ProgramTesterUI extends JFrame {

    ProgramTesterCntl theProgramTesterCntl;
    private JPanel mainPanel, navPanel;
    private JLabel introLabel;
    private JButton previousButton, nextButton;

    // <editor-fold defaultstate="collapsed" desc="Step 1: Set files-dir, files-zip and files-test folder locations">
    private JTextArea unzippedFileNames;
    private JScrollPane unzippedScrollPane;
    private JFileChooser unzippedFiles;
    private JButton unzippedFilesButton;

    private JTextArea zippedFileNames;
    private JFileChooser zippedFiles;
    private JButton zippedFilesButton;

    private JTextArea testFileNames;
    private JFileChooser testFiles;
    private JButton testFilesButton;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 2: Flag master folder">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 3: Input names of files and the number of runs for each file">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 4: Specify scanner and cmd inputs">
    private JButton submitButton;
    private JLabel fileNameLabel;
    private JLabel runNumberLabel;
    private JTextField cmdArgsField;
    private JTextField scannerInputField;
    private JRadioButton noScannerRadioButton;
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
                introLabel = new JLabel("Welcome to the ProgramTester Wizard!  Press Next to continue...");
                mainPanel.add(introLabel);

                nextButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    theProgramTesterCntl.step(1);
                });

                break;
            // <editor-fold defaultstate="collapsed" desc="Step 1: Set files-dir, files-zip and files-test folder locations">
            case 1:
                this.setTitle("Choose Files");
                mainPanel.setLayout(new GridLayout(4, 2, 60, 60));

                unzippedFileNames = new JTextArea();
                unzippedFileNames.setEditable(false);
                unzippedFileNames.setPreferredSize(new Dimension(2, 20));
                unzippedFileNames.setLineWrap(true);
                if (this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles() != null) {
                    for (int i = 0; i < this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles().length; i++) {
                        unzippedFileNames.append(this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles()[i].getName() + ", ");
                    }
                }
                unzippedFiles = new JFileChooser();
                unzippedFiles.setMultiSelectionEnabled(true);
                unzippedFilesButton = new JButton("Select...");

                unzippedFilesButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        unzippedFilesButtonActionPerformed(evt);
                    }
                });

                mainPanel.add(unzippedFileNames);
                mainPanel.add(unzippedFilesButton);

                zippedFileNames = new JTextArea("Zipped Files");
                zippedFileNames.setEditable(false);
                zippedFileNames.setPreferredSize(new Dimension(2, 20));
                zippedFileNames.setLineWrap(true);
                zippedFiles = new JFileChooser();
                zippedFiles.setMultiSelectionEnabled(true);
                zippedFilesButton = new JButton("Select...");

                zippedFilesButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        zippedFilesButtonActionPerformed(evt);
                    }
                });

                mainPanel.add(zippedFileNames);
                mainPanel.add(zippedFilesButton);

                testFileNames = new JTextArea("Test Files");
                testFileNames.setEditable(false);
                testFileNames.setPreferredSize(new Dimension(2, 20));
                testFileNames.setLineWrap(true);
                testFiles = new JFileChooser();
                testFiles.setMultiSelectionEnabled(true);
                testFilesButton = new JButton("Select...");

                testFilesButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        testFilesButtonActionPerformed(evt);
                    }
                });

                mainPanel.add(testFileNames);
                mainPanel.add(testFilesButton);

                previousButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    theProgramTesterCntl.step(0);
                });

                nextButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    //TODO CHANGE WHEN NEW STEPS COME IN
                    theProgramTesterCntl.step(3);
                });

                break;
            // </editor-fold>
            case 2:

                break;
            // <editor-fold defaultstate="collapsed" desc="Step 3: Input names of files and the number of runs for each file">
            case 3:
                mainPanel.setLayout(null);

                JTextField jField = new JTextField();
                jField.setBounds(30, 70, 300, 30);
                mainPanel.add(jField);

                JLabel label4 = new JLabel();
                label4.setBounds(30, 40, 100, 30);
                label4.setText("Output");
                mainPanel.add(label4);

                JLabel label5 = new JLabel();
                label5.setBounds(30, 175, 200, 30);
                label5.setText("Number of Runs:");
                mainPanel.add(label5);

                String[] numbers = {"5", "4", "3", "2", "1", "0"};
                JComboBox box1 = new JComboBox(numbers);
                box1.setSelectedIndex(5);
                box1.setBounds(150, 175, 100, 30);
                mainPanel.add(box1);

                JButton browse = new JButton();
                browse.setBounds(340, 70, 100, 30);
                browse.setText("Browse");
                mainPanel.add(browse);

                previousButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    theProgramTesterCntl.step(1);
                });

                nextButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    theProgramTesterCntl.step(4);
                });
                break;
            // </editor-fold>   
            // <editor-fold defaultstate="collapsed" desc="Step 4: Specify scanner and cmd inputs">
            case 4:
                mainPanel.setLayout(null);

                fileNameLabel.setBounds(30, 30, 100, 20);
                fileNameLabel.setText(Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).getFileName());
                mainPanel.add(fileNameLabel);

                JLabel cmdArgs = new JLabel();
                cmdArgs.setBounds(100, 125, 150, 20);
                cmdArgs.setText("Command-Line Args: ");
                mainPanel.add(cmdArgs);

                JLabel scnrInput = new JLabel();
                scnrInput.setBounds(100, 150, 150, 20);
                scnrInput.setText("Scanner Input: ");
                mainPanel.add(scnrInput);

                cmdArgsField.setBounds(250, 125, 200, 20);
                mainPanel.add(cmdArgsField);

                scannerInputField.setBounds(200, 150, 250, 20);
                mainPanel.add(scannerInputField);

                noScannerRadioButton.setBounds(200, 175, 100, 30);
                noScannerRadioButton.setText("None");
                mainPanel.add(noScannerRadioButton);

                previousButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    theProgramTesterCntl.step(3);
                });

                nextButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).setCmdArgs(cmdArgsField.getText());
                    if (noScannerRadioButton.isSelected()) {
                        Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).setScannerArgs("None");
                    } else {
                        Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).setScannerArgs(scannerInputField.getText());
                    }

                    if (this.theProgramTesterCntl.getCurrentViewModel().getRunNumber() + 1 < Run.getRunList().size()) {
                     this.theProgramTesterCntl.getCurrentViewModel().setRunNumber(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()+1);
                     theProgramTesterCntl.step(4);

                     } else {
                     this.theProgramTesterCntl.getCurrentViewModel().printFiles();
                     theProgramTesterCntl.step(5);
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

                jMenuBar1 = new JMenuBar();

                jMenu1 = new JMenu();
                jMenu1.setText("File");
                jMenuBar1.add(jMenu1);

                jMenu2 = new JMenu();
                jMenu2.setText("Edit");
                jMenuBar1.add(jMenu2);

                previousButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                    theProgramTesterCntl.step(4);
                });

                //setJMenuBar(jMenuBar1);
                //TODO SET PANEL LAYOUTS HERE*************************************
                break;
            // </editor-fold>
        }

        mainPanel.updateUI();
    }

    // <editor-fold defaultstate="collapsed" desc="Step 1 ActionListeners">
    private void unzippedFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = unzippedFiles.showOpenDialog(ProgramTesterUI.this.mainPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            ProgramTesterUI.this.theProgramTesterCntl.getCurrentViewModel().setSelectedUnzippedFiles(unzippedFiles.getSelectedFiles());
            String filelist = "";
            for (int i = 0; i < ProgramTesterUI.this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles().length; i++) {
                filelist += ProgramTesterUI.this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles()[i].getName() + ", ";
            }
            ProgramTesterUI.this.unzippedFileNames.setText(filelist);
        }
    }

    private void zippedFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = zippedFiles.showOpenDialog(ProgramTesterUI.this.mainPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            ProgramTesterUI.this.theProgramTesterCntl.getCurrentViewModel().setSelectedZippedFiles(zippedFiles.getSelectedFiles());
            String filelist = "";
            for (int i = 0; i < ProgramTesterUI.this.theProgramTesterCntl.getCurrentViewModel().getSelectedZippedFiles().length; i++) {
                filelist += ProgramTesterUI.this.theProgramTesterCntl.getCurrentViewModel().getSelectedZippedFiles()[i].getName() + ", ";
            }
            ProgramTesterUI.this.zippedFileNames.setText(filelist);
        }
    }

    private void testFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = testFiles.showOpenDialog(ProgramTesterUI.this.mainPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            ProgramTesterUI.this.theProgramTesterCntl.getCurrentViewModel().setSelectedTestFiles(testFiles.getSelectedFiles());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 2 ActionListeners">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 3 ActionListeners">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 4 ActionListeners">

    // </editor-fold>
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

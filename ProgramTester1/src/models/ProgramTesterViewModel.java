
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.models;


import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controllers.OutputPathChooserController;

/**
 *
 * @author Luke
 */
public class ProgramTesterViewModel extends JPanel {

    private JButton previousButton, nextButton;

    // <editor-fold defaultstate="collapsed" desc="Step 1: Set files-dir, files-zip and files-test folder locations">
    private JTextArea unzippedFileNames;
    private JFileChooser unzippedFiles;
    private JButton unzippedFilesButton;
    private File[] selectedUnzippedFiles;
    //private File filesDir = new File("src/files-dir/");
    private JTextArea zippedFileNames;
    private JFileChooser zippedFiles;
    private JButton zippedFilesButton;
    private File[] selectedZippedFiles;
    //private File filesZip = new File("src/files-zip/");
    private JTextArea testFileNames;
    private JFileChooser testFiles;
    private JButton testFilesButton;
    private File[] selectedTestFiles;
    //private File filesTest = new File("src/files-test/");
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 2: Flag master folder">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 3: Input names of files and the number of runs for each file">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 4: Specify scanner and cmd inputs">
    private int runNumber;
    private JButton submitButton;
    private JLabel fileNameLabel;
    private JLabel runNumberLabel;
    private JLabel jLabel3;
    private JLabel jLabel4;
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

    public ProgramTesterViewModel(int stepInWizard) {
        previousButton = new JButton("Back");
        nextButton = new JButton("Next");
        switch (stepInWizard) {
            case 1:
                unzippedFileNames = new JTextArea(2, 20);
                unzippedFileNames.setEditable(false);
                unzippedFiles = new JFileChooser();
                unzippedFilesButton = new JButton("Select...");

                unzippedFilesButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        unzippedFilesButtonActionPerformed(evt);
                    }
                });

                unzippedFiles.setMultiSelectionEnabled(true);
                selectedUnzippedFiles = unzippedFiles.getSelectedFiles();
                zippedFileNames = new JTextArea(2, 20);
                zippedFileNames.setEditable(false);
                zippedFiles = new JFileChooser();
                zippedFilesButton = new JButton("Select...");

                zippedFilesButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        zippedFilesButtonActionPerformed(evt);
                    }
                });

                zippedFiles.setMultiSelectionEnabled(true);
                selectedZippedFiles = zippedFiles.getSelectedFiles();
                testFileNames = new JTextArea(2, 20);
                testFileNames.setEditable(false);
                testFiles = new JFileChooser();
                testFilesButton = new JButton("Select...");

                testFilesButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        testFilesButtonActionPerformed(evt);
                    }
                });

                testFiles.setMultiSelectionEnabled(true);
                selectedTestFiles = testFiles.getSelectedFiles();

                //TODO SET PANEL LAYOUTS HERE*************************************
                break;
                
            case 2:

                break;
                
            case 3:

                break;
                
            case 4:
                submitButton = new JButton();
                fileNameLabel = new JLabel();
                runNumberLabel = new JLabel();
                jLabel3 = new JLabel();
                jLabel4 = new JLabel();
                cmdArgsField = new JTextField();
                scannerInputField = new JTextField();
                noScannerRadioButton = new JRadioButton();

                submitButton.setText("Next");
                submitButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        submitButtonActionPerformed(evt);
                    }
                });

                fileNameLabel.setText("jLabel1");

                runNumberLabel.setText("jLabel2");

                jLabel3.setText("Command-Line Args:");

                jLabel4.setText("Scanner Input:");

                noScannerRadioButton.setText("None");
                noScannerRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        noScannerRadioButtonActionPerformed(evt);
                    }
                });

                //TODO SET PANEL LAYOUTS HERE*************************************
                
                break;
                
            case 5:
                browseButton.setText("Browse");
                browseButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        browseButtonActionPerformed(evt);
                    }
                });

                fileLocationTestField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        fileLocationTestFieldActionPerformed(evt);
                    }
                });

                jLabel1.setText("Choose an output location:");

                outputNameField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        outputNameFieldActionPerformed(evt);
                    }
                });

                jLabel2.setText("Choose an output file name:");

                nextButton.setText("Next");
                nextButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        nextButtonActionPerformed(evt);
                    }
                });

                jMenu1.setText("File");
                jMenuBar1.add(jMenu1);

                jMenu2.setText("Edit");
                jMenuBar1.add(jMenu2);

                //setJMenuBar(jMenuBar1);
                //TODO SET PANEL LAYOUTS HERE*************************************
                break;
        }
    }

    public ProgramTesterViewModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // <editor-fold defaultstate="collapsed" desc="Step 1 ActionListeners">
    private void unzippedFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = unzippedFiles.showOpenDialog(ProgramTesterViewModel.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedUnzippedFiles = unzippedFiles.getSelectedFiles();
        }
    }

    private void zippedFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = zippedFiles.showOpenDialog(ProgramTesterViewModel.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedZippedFiles = zippedFiles.getSelectedFiles();
        }
    }

    private void testFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = testFiles.showOpenDialog(ProgramTesterViewModel.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedTestFiles = testFiles.getSelectedFiles();
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 2 ActionListeners">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 3 ActionListeners">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 4 ActionListeners">
    private void noScannerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Run.getRunList().get(runNumber).setCmdArgs(cmdArgsField.getText());
        if (noScannerRadioButton.isSelected()) {
            Run.getRunList().get(runNumber).setScannerArgs("None");
        } else {
            Run.getRunList().get(runNumber).setScannerArgs(scannerInputField.getText());
        }

        //TODO REFRESH FRAME WITH CORRECT INFO HERE
        /*if (runNumber + 1 < Run.getRunList().size()) {
         ScannerInputs newScannerInput = new ScannerInputs(Run.getRunList().get(runNumber + 1).getFileName(), runNumber + 1, Run.getRunList().size(), theParentInputsCntl);

         } else {
         theParentInputsCntl.printFiles();
         }
         this.dispose();*/
    }

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

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import programtester.controllers.*;

public class StepOnePanel extends JPanel {

    private ProgramTesterCntl theProgramTesterCntl;
    private JTextArea sourceFolderNameArea;
    private JFileChooser sourceFolderFileChooser;
    private JButton sourceFolderButton;

    public StepOnePanel(ProgramTesterCntl parentProgramTesterCntl) {

        this.theProgramTesterCntl = parentProgramTesterCntl;

        this.setLayout(null);
        
        String instructions = "First, select the lowest-level folder containing "
                + "a single folder for each student's work. Once you select a "
                + "directory, the names of the students inside will appear "
                + "within the textarea below.";
        LabelArea instructionLabel = new LabelArea(instructions);
        instructionLabel.setBounds(100, 30, 400, 100);
        this.add(instructionLabel);
        
        JLabel selectLabel = new JLabel ("Select folder:");
        selectLabel.setBounds(100, 130, 180, 20);
        this.add(selectLabel);
        
        JLabel studentLabel = new JLabel ("Students' Names:");
        studentLabel.setBounds(100, 160, 180, 20);
        this.add(studentLabel);
        
        sourceFolderNameArea = new JTextArea();
        sourceFolderNameArea.setBounds(300, 160, 250, 200);
        sourceFolderNameArea.setEditable(false);
        sourceFolderNameArea.setLineWrap(true);
        if (this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles() != null) {
            for (File selectedUnzippedFile : this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles()) {
                sourceFolderNameArea.append(selectedUnzippedFile.getName() + ", ");
            }
        } else {
            sourceFolderNameArea.setText("Click the select button in order to select your source folder.");
        }
        sourceFolderFileChooser = new JFileChooser("./");
        sourceFolderFileChooser.setMultiSelectionEnabled(false);
        sourceFolderFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        sourceFolderButton = new JButton("Select...");
        sourceFolderButton.setBounds(300, 130, 100, 20);

        sourceFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unzippedFilesButtonActionPerformed(evt);
            }
        });

        this.add(sourceFolderNameArea);
        this.add(sourceFolderButton);
    }

// <editor-fold defaultstate="collapsed" desc="Step 1 ActionListeners">
    private void unzippedFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = sourceFolderFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.theProgramTesterCntl.getCurrentViewModel().setSelectedUnzippedFiles(sourceFolderFileChooser.getSelectedFile());
            String filelist = "";
            for (File selectedUnzippedFile : this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles()) {
                filelist += selectedUnzippedFile.getName() + ", ";
            }
            this.sourceFolderNameArea.setText(filelist);
            theProgramTesterCntl.createConfigBatchFile();
            theProgramTesterCntl.retrievePossibleTestFiles();
        }
    }
// </editor-fold>

}

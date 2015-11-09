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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import programtester.controllers.*;

public class StepOnePanel extends JPanel {

    private ProgramTesterCntl theProgramTesterCntl;

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

    public StepOnePanel(ProgramTesterCntl parentProgramTesterCntl) {

        this.theProgramTesterCntl = parentProgramTesterCntl;

        this.setLayout(new GridLayout(4, 2, 60, 60));

        unzippedFileNames = new JTextArea();
        unzippedFileNames.setEditable(false);
        unzippedFileNames.setPreferredSize(new Dimension(2, 20));
        unzippedFileNames.setLineWrap(true);
        if (this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles() != null) {
            for (File selectedUnzippedFile : this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles()) {
                unzippedFileNames.append(selectedUnzippedFile.getName() + ", ");
            }
        } else {
            unzippedFileNames.setText("Unzipped Files");
        }
        unzippedFiles = new JFileChooser("./");
        unzippedFiles.setMultiSelectionEnabled(true);
        unzippedFilesButton = new JButton("Select...");

        unzippedFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unzippedFilesButtonActionPerformed(evt);
            }
        });

        this.add(unzippedFileNames);
        this.add(unzippedFilesButton);

        zippedFileNames = new JTextArea();
        zippedFileNames.setEditable(false);
        zippedFileNames.setPreferredSize(new Dimension(2, 20));
        zippedFileNames.setLineWrap(true);
        if (this.theProgramTesterCntl.getCurrentViewModel().getSelectedZippedFiles() != null) {
            for (File selectedZippedFile : this.theProgramTesterCntl.getCurrentViewModel().getSelectedZippedFiles()) {
                zippedFileNames.append(selectedZippedFile.getName() + ", ");
            }
        } else {
            zippedFileNames.setText("Zipped Files");
        }
        zippedFiles = new JFileChooser("./");
        zippedFiles.setMultiSelectionEnabled(true);
        zippedFilesButton = new JButton("Select...");

        zippedFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zippedFilesButtonActionPerformed(evt);
            }
        });

        this.add(zippedFileNames);
        this.add(zippedFilesButton);

        testFileNames = new JTextArea("Test Files");
        testFileNames.setEditable(false);
        testFileNames.setPreferredSize(new Dimension(2, 20));
        testFileNames.setLineWrap(true);
        testFiles = new JFileChooser("./");
        testFiles.setMultiSelectionEnabled(true);
        testFilesButton = new JButton("Select...");

        testFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testFilesButtonActionPerformed(evt);
            }
        });

        this.add(testFileNames);
        this.add(testFilesButton);
    }

// <editor-fold defaultstate="collapsed" desc="Step 1 ActionListeners">
    private void unzippedFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = unzippedFiles.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.theProgramTesterCntl.getCurrentViewModel().setSelectedUnzippedFiles(unzippedFiles.getSelectedFiles());
            String filelist = "";
            for (File selectedUnzippedFile : this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles()) {
                filelist += selectedUnzippedFile.getName() + ", ";
            }
            this.unzippedFileNames.setText(filelist);
        }
    }

    private void zippedFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = zippedFiles.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.theProgramTesterCntl.getCurrentViewModel().setSelectedZippedFiles(zippedFiles.getSelectedFiles());
            String filelist = "";
            for (File selectedZippedFile : this.theProgramTesterCntl.getCurrentViewModel().getSelectedZippedFiles()) {
                filelist += selectedZippedFile.getName() + ", ";
            }
            this.zippedFileNames.setText(filelist);
        }
    }

    private void testFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = testFiles.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.theProgramTesterCntl.getCurrentViewModel().setSelectedTestFiles(testFiles.getSelectedFiles());
        }
    }
// </editor-fold>

}

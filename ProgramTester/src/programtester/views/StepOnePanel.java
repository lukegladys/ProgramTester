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
import javax.swing.JTextArea;
import programtester.controllers.*;

public class StepOnePanel extends JPanel {

    private ProgramTesterCntl theProgramTesterCntl;

    private JTextArea sourceFolderNameArea;
    private JFileChooser sourceFolderFileChooser;
    private JButton sourceFolderButton;

    public StepOnePanel(ProgramTesterCntl parentProgramTesterCntl) {

        this.theProgramTesterCntl = parentProgramTesterCntl;

        this.setLayout(new GridLayout(4, 2, 60, 60));

        sourceFolderNameArea = new JTextArea();
        sourceFolderNameArea.setEditable(false);
        sourceFolderNameArea.setPreferredSize(new Dimension(2, 20));
        sourceFolderNameArea.setLineWrap(true);
        if (this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles() != null) {
            for (File selectedUnzippedFile : this.theProgramTesterCntl.getCurrentViewModel().getSelectedUnzippedFiles()) {
                sourceFolderNameArea.append(selectedUnzippedFile.getName() + ", ");
            }
        } else {
            sourceFolderNameArea.setText("Click the button to the right in order to select your source folder.");
        }
        sourceFolderFileChooser = new JFileChooser("./");
        sourceFolderFileChooser.setMultiSelectionEnabled(false);
        sourceFolderFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        sourceFolderButton = new JButton("Select...");

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
        }
    }
// </editor-fold>

}

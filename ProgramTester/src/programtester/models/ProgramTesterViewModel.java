/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.models;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Luke
 */
public class ProgramTesterViewModel extends JPanel
                             implements ActionListener{
    
    private ArrayList<Object> listOfComponents;
    private JButton previousButton, nextButton;
    
    // <editor-fold desc="Step 1">
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
    // <editor-fold desc="Step 2">
    // </editor-fold>
    // <editor-fold desc="Step 3">
    // </editor-fold>
    // <editor-fold desc="Step 4">
    // </editor-fold>
    // <editor-fold desc="Step 5">
    // </editor-fold>
    // <editor-fold desc="Step 6">
    private JButton runBatchButton;
    private JButton singleTesterButton;
    // </editor-fold>
    
    public ProgramTesterViewModel(int stepInWizard){
        switch(stepInWizard){
            case 1:  
                unzippedFileNames = new JTextArea(2,20);
                unzippedFileNames.setEditable(false);
                unzippedFiles = new JFileChooser();
                unzippedFilesButton = new JButton("Select...");
                unzippedFilesButton.addActionListener(this);
                listOfComponents.add(unzippedFileNames);
                listOfComponents.add(unzippedFiles);
                unzippedFiles.setMultiSelectionEnabled(true);
                selectedUnzippedFiles = unzippedFiles.getSelectedFiles();
                zippedFileNames = new JTextArea(2,20);
                zippedFileNames.setEditable(false);
                zippedFiles = new JFileChooser();
                zippedFilesButton = new JButton("Select...");
                zippedFilesButton.addActionListener(this);
                listOfComponents.add(zippedFileNames);
                listOfComponents.add(zippedFiles);
                zippedFiles.setMultiSelectionEnabled(true);
                selectedZippedFiles = zippedFiles.getSelectedFiles();
                testFileNames = new JTextArea(2,20);
                testFileNames.setEditable(false);
                testFiles = new JFileChooser();
                testFilesButton = new JButton("Select...");
                testFilesButton.addActionListener(this);
                listOfComponents.add(testFileNames);
                listOfComponents.add(testFiles);
                testFiles.setMultiSelectionEnabled(true);
                selectedTestFiles = testFiles.getSelectedFiles();
                //SET PANEL LAYOUT HERE
                for(int i=0 ; i<listOfComponents.size() ; i++){
                    ProgramTesterViewModel.this.add((Component)listOfComponents.get(i));
                }
                break;
            case 2:  
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unzippedFilesButton) {
            int returnVal = unzippedFiles.showOpenDialog(ProgramTesterViewModel.this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
                selectedUnzippedFiles = unzippedFiles.getSelectedFiles();
        } else if (e.getSource() == zippedFilesButton) {
            int returnVal = zippedFiles.showOpenDialog(ProgramTesterViewModel.this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
                selectedZippedFiles = zippedFiles.getSelectedFiles();
        } else if(e.getSource() == testFilesButton){
            int returnVal = testFiles.showOpenDialog(ProgramTesterViewModel.this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
                selectedTestFiles = testFiles.getSelectedFiles();
        }
    }
    
}
